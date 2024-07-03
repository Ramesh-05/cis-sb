package com.orchasp.contactInformationSystem.controller;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orchasp.contactInformationSystem.dao.UserDaoImpl;
import com.orchasp.contactInformationSystem.entity.Users;
import com.orchasp.contactInformationSystem.service.UserServiceImpl;
import com.orchasp.contactInformationSystem.util.ResponseStructure;

@CrossOrigin(origins = "https://cisorchasp-sepia.vercel.app")
@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private UserDaoImpl dao;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Users>> saveUser(@RequestBody Users user){
		return userService.saveUser(user);
	}
	@GetMapping("/fetch/{memberId}")
	public Users fetchUser(@PathVariable int memberId){
		return dao.fetchById(memberId);
	}
	@PutMapping("/update/{memberId}")
	public ResponseEntity<ResponseStructure<Users>> updateUser(@PathVariable int memberId,@RequestBody Users user){
		return userService.updateUser(memberId,user);
	}
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<ResponseStructure<Users>> deleteUser(@PathVariable int userId){
		return userService.deleteUser(userId);
	}
	
	@GetMapping("/fetchall")
	public List<Users> fetchAll() {
		return dao.fetchAll();
	}
	
	@GetMapping("/login")
	public Users loginUser(@RequestParam String emailId, @RequestParam String password) {
		return dao.login(emailId, password);
	}
//	http://localhost:7777//api/user/login?userId=Dp7420&password=123

	@PutMapping("/changePassword/{memberId}")
	public ResponseEntity<?> changePassword(@PathVariable int memberId, @RequestBody Map<String, String> request) {
		try {
			String oldPassword = request.get("oldPassword");
			String newPassword = request.get("newPassword");
			Users updateUser = dao.changePassword(memberId, oldPassword, newPassword);
			return ResponseEntity.ok(updateUser);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
