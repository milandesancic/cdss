package rs.uns.ac.ftn.cdss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.uns.ac.ftn.cdss.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}
