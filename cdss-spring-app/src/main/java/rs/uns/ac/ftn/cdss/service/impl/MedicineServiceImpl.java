package rs.uns.ac.ftn.cdss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.uns.ac.ftn.cdss.model.Medicine;
import rs.uns.ac.ftn.cdss.repository.MedicineRepository;
import rs.uns.ac.ftn.cdss.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	MedicineRepository medicineRepository;
	
	@Override
	public List<Medicine> getAll() {
		return medicineRepository.findAll();
	}
}
