package rs.uns.ac.ftn.cdss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.uns.ac.ftn.cdss.model.Disease;

public interface DiseaseRepository extends JpaRepository<Disease,Long> {

}
