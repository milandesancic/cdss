package rs.uns.ac.ftn.cdss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.uns.ac.ftn.cdss.model.Record;

public interface RecordRepository extends JpaRepository<Record, Long>{

}
