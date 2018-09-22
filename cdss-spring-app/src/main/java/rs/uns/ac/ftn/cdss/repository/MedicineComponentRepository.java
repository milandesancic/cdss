package rs.uns.ac.ftn.cdss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.uns.ac.ftn.cdss.model.MedicineComponent;

public interface MedicineComponentRepository extends JpaRepository<MedicineComponent, Long> {
	
	public MedicineComponent findByName(String name);
}
