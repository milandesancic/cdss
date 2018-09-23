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

import rs.uns.ac.ftn.cdss.event.OxygenEvent;
import rs.uns.ac.ftn.cdss.event.OxygenLevelNotGoodEvent;
import rs.uns.ac.ftn.cdss.model.Patient;

public class OxygenTest {

	@Test
	public void testOxygenProblem() {

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
		Patient p = new Patient(1L, "Djura");
		for (int index = 0; index < 5; index++) {
			OxygenEvent oxygenEvent = new OxygenEvent(p, 50);
			kieSession.insert(oxygenEvent);
		}

		clock.advanceTime(15, TimeUnit.MINUTES);
		kieSession.getAgenda().getAgendaGroup("oxygen").setFocus();
		kieSession.fireUntilHalt();
		Collection<?> coll = kieSession.getObjects(new ClassObjectFilter(OxygenLevelNotGoodEvent.class));
		assertEquals(coll.size(), 1);
		OxygenLevelNotGoodEvent ole = (OxygenLevelNotGoodEvent) coll.iterator().next();
		Long l = 1L;
		assertEquals(ole.getPatient().getId(), l);
	}

	private void runNegativeTest(KieSession kieSession) {
		SessionPseudoClock clock = kieSession.getSessionClock();
		Patient p = new Patient(1L, "Djura");
		int level = 68;
		for (int index = 0; index < 5; index++) {
			//Porast svaki put podizemo nivo kiseonika
			OxygenEvent oxygenEvent = new OxygenEvent(p, level++);
			kieSession.insert(oxygenEvent);
		}

		clock.advanceTime(15, TimeUnit.MINUTES);

		kieSession.getAgenda().getAgendaGroup("oxygen").setFocus();
		kieSession.fireAllRules();
		Collection<?> coll = kieSession.getObjects(new ClassObjectFilter(OxygenLevelNotGoodEvent.class));
		assertEquals(coll.size(), 0);
		OxygenLevelNotGoodEvent ole = (OxygenLevelNotGoodEvent) coll.iterator().next();
		assertEquals(ole, null);

	}
}