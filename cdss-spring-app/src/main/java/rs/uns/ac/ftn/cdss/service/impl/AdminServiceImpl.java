package rs.uns.ac.ftn.cdss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.uns.ac.ftn.cdss.dto.DoctorDto;
import rs.uns.ac.ftn.cdss.model.User;
import rs.uns.ac.ftn.cdss.model.UserRole;
import rs.uns.ac.ftn.cdss.repository.UserRepository;
import rs.uns.ac.ftn.cdss.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	UserRepository userRepository;

	@Override
	public boolean addDoctor(DoctorDto newDoctr, String username) {
		User admin = userRepository.getByUsername(username);
		if (admin != null && (admin.getRole() != UserRole.ADMIN)) {
			return false;
		}
		User doctor = null;
		doctor = userRepository.getByUsername(newDoctr.getUsername());
		if (doctor != null) {
			// Postoji lekar sa istim korisnickim imenom
			return false;
		}
		doctor = new User(newDoctr);
		userRepository.save(doctor);
		return true;
	}

}
