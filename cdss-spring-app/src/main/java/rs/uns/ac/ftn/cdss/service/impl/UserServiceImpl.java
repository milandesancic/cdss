package rs.uns.ac.ftn.cdss.service.impl;

import java.util.List;

import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.uns.ac.ftn.cdss.CdssSpringAppApplication;
import rs.uns.ac.ftn.cdss.dto.AuthenticationRequestDto;
import rs.uns.ac.ftn.cdss.model.Disease;
import rs.uns.ac.ftn.cdss.model.User;
import rs.uns.ac.ftn.cdss.model.UserRole;
import rs.uns.ac.ftn.cdss.repository.DiseaseRepository;
import rs.uns.ac.ftn.cdss.repository.UserRepository;
import rs.uns.ac.ftn.cdss.security.TokenUtils;
import rs.uns.ac.ftn.cdss.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	DiseaseRepository diseaseRepository;

	@Autowired
	TokenUtils tokenUtils;

	private final KieContainer kieContainer;

	@Autowired
	public UserServiceImpl(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	@Override
	public User getByUsername(String username) {
		return this.userRepository.getByUsername(username);
	}

	@Override
	public Boolean login(AuthenticationRequestDto userDto) {

		User user = getByUsername(userDto.getUsername());
		if (user == null)
			return false;
		// Proveri da li se paswordi poklapaju
		if (!user.getPassword().equals(userDto.getPassword()))
			return false;
		{

			if (user.getRole() == UserRole.ADMIN) {
				// Ako je admin ne treba da instanciram kie sesiju jer admin radi samo CRUD
				return true;
			}

			KieServices ks = KieServices.Factory.get();
			KieBaseConfiguration kbconf = ks.newKieBaseConfiguration();
			kbconf.setOption(EventProcessingOption.STREAM);
			KieBase kbase = kieContainer.newKieBase(kbconf);
			KieSession kieSession = kbase.newKieSession();

			if (!CdssSpringAppApplication.kieSessions.containsKey(user.getUsername())) {

				// Dodavanje svih bolesti iz sistema u sesiju
				List<Disease> diseases = diseaseRepository.findAll();
				for (Disease d : diseases) {
					kieSession.insert(d);
				}

				CdssSpringAppApplication.kieSessions.put(user.getUsername(), kieSession);
			}

			return true;
		}
	}

	@Override
	public Boolean logout(String username) {
		//Izbaciti sesiju iz mape
		
		CdssSpringAppApplication.kieSessions.remove(username);
		return true;
	}

}
