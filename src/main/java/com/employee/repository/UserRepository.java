package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employee.entity.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Integer> {
	@Query(value = "SELECT u FROM UserDetails u WHERE u.userCity = :userCity")
	public List<UserDetails> findAllUserInCity(String   userCity)
;	
}
