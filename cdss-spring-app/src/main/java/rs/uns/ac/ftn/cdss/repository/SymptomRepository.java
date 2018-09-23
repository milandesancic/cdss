package rs.uns.ac.ftn.cdss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.uns.ac.ftn.cdss.model.Symptom;

public interface SymptomRepository extends JpaRepository<Symptom,Long>{
	
	public Symptom findByName(String name);

}
