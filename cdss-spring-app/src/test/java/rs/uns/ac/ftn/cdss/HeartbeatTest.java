package rs.uns.ac.ftn.cdss;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.drools.core.ClassObjectFilter;
import org.drools.core.ClockType;
import org.drools.core.time.SessionPseudoClock;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.conf.ClockTypeOption;

import rs.uns.ac.ftn.cdss.event.HeartbeatEvent;
import rs.uns.ac.ftn.cdss.event.HeartbeatNotGoodEvent;
import rs.uns.ac.ftn.cdss.model.Patient;

public class HeartbeatTest {

	@Test
	public void testHeartbeat() {

		KieServices kieServices = KieServices.Factory.get();
		KieContainer kContainer = kieServices
				.newKieContainer(kieServices.newReleaseId("rs.uns.ac.ftn", "cdss-drools", "0.0.1-SNAPSHOT"));

		KieBaseConfiguration kconf = kieServices.newKieBaseConfiguration();
		kconf.setOption(EventProcessingOption.STREAM);
		KieBase kieBase = kContainer.newKieBase(kconf);

		KieSessionConfiguration kconfig1 = kieServices.newKieSessionConfiguration();
		kconfig1.setOption(ClockTypeOption.get(ClockType.PSEUDO_CLOCK.getId()));
		KieSession kSession1 = kieBase.newKieSession(kconfig1, null);

		KieSessionConfiguration kconfig2 = kieServices.newKieSessionConfiguration();
		kconfig2.setOption(ClockTypeOption.get(ClockType.PSEUDO_CLOCK.getId()));
		KieSession kSession2 = kieBase.newKieSession(kconfig2, null);

		runPositiveTest(kSession1);
		runNegativeTest(kSession2);
	}

	private void runPositiveTest(KieSession kieSession) {
		SessionPseudoClock clock = kieSession.getSessionClock();
		Patient p = new Patient(1L, "Pera");
		for (int i = 0; i < 30; i++) {
			HeartbeatEvent heartbeatEvent = new HeartbeatEvent(p);
			kieSession.insert(heartbeatEvent);
		}

		clock.advanceTime(10, TimeUnit.SECONDS);
		kieSession.getAgenda().getAgendaGroup("heartbeats").setFocus();
		kieSession.fireUntilHalt();
		Collection<?> collection = kieSession.getObjects(new ClassObjectFilter(HeartbeatNotGoodEvent.class));
		assertEquals(collection.size(), 1);
		HeartbeatNotGoodEvent hbe = (HeartbeatNotGoodEvent) collection.iterator().next();
		Long l = 1L;
		assertEquals(hbe.getPatient().getId(), l);
	}

	private void runNegativeTest(KieSession kieSession) {
		SessionPseudoClock clock = kieSession.getSessionClock();
		Patient p = new Patient(1L, "Pera");
		for (int i = 0; i < 20; i++) {
			HeartbeatEvent heartbeatEvent = new HeartbeatEvent(p);
			kieSession.insert(heartbeatEvent);
		}
		clock.advanceTime(10, TimeUnit.SECONDS);
		kieSession.getAgenda().getAgendaGroup("heartbeat-event").setFocus();
		int firedRules = kieSession.fireAllRules();
		assertEquals(firedRules, 0);
		Collection<?> coll = kieSession.getObjects(new ClassObjectFilter(HeartbeatNotGoodEvent.class));
		assertEquals(coll.size(), 0);
	}
}
