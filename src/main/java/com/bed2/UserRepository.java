package com.bed2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
	
	Users findByEmail(String Email);

}
