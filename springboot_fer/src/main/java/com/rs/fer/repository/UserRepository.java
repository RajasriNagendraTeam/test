package com.rs.fer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	// User login(String userName, String password);
	
	List<User> findByEmail(String email);
	
	List<User> findByUserNameAndPassword(String userName, String password);
	
}
