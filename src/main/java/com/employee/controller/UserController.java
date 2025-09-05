package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.UserDetails;
import com.employee.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService = new UserService();

	@PostMapping("/save")
	public String saveUser(@RequestBody UserDetails user) {
		userService.saveUser(user);
		return "user details Successfully saved ";
	}

	@DeleteMapping("/delete/{userId}")
	public String deleteUser(@PathVariable UserDetails userId) {
		userService.deleteUser(userId);
		return "user details Successfully delete";
	}

	@GetMapping("/viewUser/{userId}")
	public ResponseEntity<?> viewUser(@PathVariable int userId) {
		Optional<?> user = userService.viewUser(userId);
		return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/update/{userId}")
	public ResponseEntity<?> updateuser(@PathVariable int userId, @RequestBody UserDetails user) {
		return userService.updateuser(userId, user).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/viewAlluser")
	public ResponseEntity<List<UserDetails>> viewAlluser() {
		return ResponseEntity.ok(userService.viewAlluser());
	}
	
	@GetMapping("/viewAllUserCity/{userCity}")
	public ResponseEntity<List<?>> viewAllUserCity(@PathVariable  String userCity)
	{
		return ResponseEntity.ok(userService.viewAllUserCity(userCity));
	}
}
//http://localhost:9091/user/save
// http://localhost:9091/user/delete/{userId}
//http://localhost:9091/user/viewUser/{userId}
//http://localhost:9091/user/update/{userId}
//http://localhost:9091/user/viewAlluser
//http://localhost:9091/user/viewAllUserCity/{city}