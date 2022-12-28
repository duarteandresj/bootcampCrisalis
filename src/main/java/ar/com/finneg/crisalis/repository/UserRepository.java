package ar.com.finneg.crisalis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.finneg.crisalis.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUsernameAndPassword(String username,String password);

}
