package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.UserDetails;
import com.employee.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void saveUser(UserDetails user) {
		userRepository.save(user);
	}

	public void deleteUser(UserDetails userId) {
		userRepository.delete(userId);
	}

	public Optional<UserDetails> viewUser(int userId) {
		return userRepository.findById(userId);
	}

	public Optional<?> updateuser(int userId, UserDetails user) {
		return userRepository.findById(userId).map(existing -> {
			existing.setUserEmail(user.getUserEmail());
			existing.setUserName(user.getUserName());
			existing.setUserNumber(user.getUserNumber());
			return userRepository.save(existing);
		});
	}

	public List<UserDetails> viewAlluser() {
		return userRepository.findAll();
	}

}
