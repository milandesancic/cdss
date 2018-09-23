package rs.uns.ac.ftn.cdss;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.drools.core.ClassObjectFilter;
import org.drools.core.ClockType;
import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.conf.ClockTypeOption;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import rs.uns.ac.ftn.cdss.event.DialysisImmediatelyEvent;
import rs.uns.ac.ftn.cdss.event.HeartbeatEvent;
import rs.uns.ac.ftn.cdss.event.HeartbeatNotGoodEvent;
import rs.uns.ac.ftn.cdss.event.OxygenEvent;
import rs.uns.ac.ftn.cdss.event.OxygenLevelNotGoodEvent;
import rs.uns.ac.ftn.cdss.event.UrinatingEvent;
import rs.uns.ac.ftn.cdss.model.Disease;
import rs.uns.ac.ftn.cdss.model.Patient;
import rs.uns.ac.ftn.cdss.model.Record;

@SpringBootApplication
public class CdssSpringAppApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(CdssSpringAppApplication.class, args);
		KieSession realTimeKieSession = getRealTimeKieSession();
		

		while (true) {
			oxygen(realTimeKieSession);
			Thread.sleep(1000*10);
			heartbeats(realTimeKieSession);
			Thread.sleep(1000*10);
			dialysis(realTimeKieSession);
			System.out.println("####################################################################################");
			Thread.sleep(1000*30);
		}
		
	}

	public static HashMap<String, KieSession> kieSessions = new HashMap<>();

	@Bean
	public KieContainer kieContainer() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.newKieContainer(ks.newReleaseId("rs.uns.ac.ftn", "cdss-drools", "0.0.1-SNAPSHOT"));
		KieScanner kScanner = ks.newKieScanner(kContainer);
		kScanner.start(10_000);
		return kContainer;
	}

	public static KieSession getKieSession() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kc = ks.getKieClasspathContainer();
		KieSession kie = kc.newKieSession();
		return kie;

	}
	public static KieSession getRealTimeKieSession() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks
				.newKieContainer(ks.newReleaseId("rs.uns.ac.ftn", "cdss-drools", "0.0.1-SNAPSHOT"));

		KieBaseConfiguration kconf = ks.newKieBaseConfiguration();
		kconf.setOption(EventProcessingOption.STREAM);
		KieBase kieBase = kContainer.newKieBase(kconf);

		KieSessionConfiguration kconfig1 = ks.newKieSessionConfiguration();
		kconfig1.setOption(ClockTypeOption.get(ClockType.REALTIME_CLOCK.getId()));
		KieSession ksession = kieBase.newKieSession(kconfig1, null);

		return ksession;
	}
	
	@SuppressWarnings("unchecked")
	public static void oxygen(final KieSession realtimeSession)
			throws InterruptedException {
		Thread t = new Thread() {
			@Override
			public void run() {
				Patient p=new Patient(1L, "Djura");
				//Ubacujem 5 dogadjaja gdje je nivo kiseonika manji od 70, izmedju svakog ubacivanja tred sleep 100
				for (int index = 0; index < 5; index++) {
					OxygenEvent oxygenEvent = new OxygenEvent( p, 67);
					realtimeSession.insert(oxygenEvent);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
			}

		};
		t.setDaemon(true);
		t.start();
		try {
			Thread.sleep(1000*1);
		} catch (InterruptedException e) {
		}
		realtimeSession.getAgenda().getAgendaGroup("oxygen").setFocus();
		realtimeSession.fireUntilHalt();
		Collection<OxygenLevelNotGoodEvent> newEvents = (Collection<OxygenLevelNotGoodEvent>) realtimeSession
				.getObjects(new ClassObjectFilter(OxygenLevelNotGoodEvent.class));

		Iterator<OxygenLevelNotGoodEvent> iter = newEvents.iterator();
		while (iter.hasNext()) {
			OxygenLevelNotGoodEvent ole = iter.next();
			System.out.println(ole);
			break;
		}

	}

	@SuppressWarnings("unchecked")
	public static void heartbeats(final KieSession realtimeSession) throws InterruptedException {
		Thread t = new Thread() {
			@Override
			public void run() {
				Patient p=new Patient(1L, "Pera");
				//Dodajem 30 eventa lupanja srca izmedju svakog dodavanja tread sleep 10 ms
				for (int index = 0; index <30; index++) {
					HeartbeatEvent heartbeatEvent = new HeartbeatEvent(p);
					realtimeSession.insert(heartbeatEvent);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		};
		t.setDaemon(true);
		t.start();
		try {
			Thread.sleep(1000*1);
		} catch (InterruptedException e) {
		}
		realtimeSession.getAgenda().getAgendaGroup("heartbeats").setFocus();
		realtimeSession.fireUntilHalt();
		Collection<HeartbeatNotGoodEvent> newEvents = (Collection<HeartbeatNotGoodEvent>) realtimeSession
				.getObjects(new ClassObjectFilter(HeartbeatNotGoodEvent.class));

		Iterator<HeartbeatNotGoodEvent> iter = newEvents.iterator();
		while (iter.hasNext()) {
			HeartbeatNotGoodEvent hbe = iter.next();
			System.out.println(hbe);
			break;
		}

	}

	
	@SuppressWarnings("unchecked")
	public static void dialysis(final KieSession realtimeSession) throws InterruptedException {
		Thread t = new Thread() {
			@Override
			public void run() {
					Disease disease= new Disease(); disease.setName("Hronicna bubrezna bolest");					
					realtimeSession.insert(disease);
					Patient p=new Patient();
					p.setId(1L);
					p.setName("Mika");
					Record record=new Record();
					record.setDisease(disease);
					p.getPatientHistory().add(record);
					for(int i=0;i<20;i++) {
						//Dodaje se 20 eventa otkucaja srca
						HeartbeatEvent heartbeatEvent = new HeartbeatEvent(p);
						realtimeSession.insert(heartbeatEvent);
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
						}
					}
					for(int i=0;i<5;i++) {
						//Dodaj se 5 dogadjaja mokrenja
						UrinatingEvent ue= new UrinatingEvent(p, 13);
						realtimeSession.insert(ue);
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
						}
					}

			}
		};
		
		t.setDaemon(true);
		t.start();
		try {
			Thread.sleep(1000*1);
		} catch (InterruptedException e) {
		}
		realtimeSession.getAgenda().getAgendaGroup("dialysis").setFocus();
		realtimeSession.fireUntilHalt();
		Collection<DialysisImmediatelyEvent> newEvents = (Collection<DialysisImmediatelyEvent>) realtimeSession
				.getObjects(new ClassObjectFilter(DialysisImmediatelyEvent.class));

		Iterator<DialysisImmediatelyEvent> iter = newEvents.iterator();
		while (iter.hasNext()) {
			DialysisImmediatelyEvent die = iter.next();
			System.out.println(die);
			break;
		}
	}
	
}
