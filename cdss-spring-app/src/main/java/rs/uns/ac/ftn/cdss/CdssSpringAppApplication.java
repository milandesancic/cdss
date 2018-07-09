package rs.uns.ac.ftn.cdss;

import java.util.HashMap;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CdssSpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CdssSpringAppApplication.class, args);
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
}
