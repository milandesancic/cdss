package rs.uns.ac.ftn.cdss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.uns.ac.ftn.cdss.model.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long>{
	
	public Medicine findByName(String name);
}
