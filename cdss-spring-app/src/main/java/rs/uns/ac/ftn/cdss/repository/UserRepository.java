package rs.uns.ac.ftn.cdss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.uns.ac.ftn.cdss.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User getByUsername(String username);
}
