package rs.uns.ac.ftn.cdss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.uns.ac.ftn.cdss.model.MedicineComponent;
import rs.uns.ac.ftn.cdss.repository.MedicineComponentRepository;
import rs.uns.ac.ftn.cdss.service.MedicineComponentService;

@Service
public class MedicineComponentServiceImpl implements MedicineComponentService {

	@Autowired
	MedicineComponentRepository medicineComponentRepository;
	@Override
	public List<MedicineComponent> getAll() {
		return medicineComponentRepository.findAll();
	}

}
