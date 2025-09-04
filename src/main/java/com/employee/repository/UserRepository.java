package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Integer> {
}
