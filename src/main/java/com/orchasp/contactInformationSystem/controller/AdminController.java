package com.orchasp.contactInformationSystem.controller;

import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orchasp.contactInformationSystem.dao.AdminDao;
import com.orchasp.contactInformationSystem.entity.Admin;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "https://cisorchasp-sepia.vercel.app")
public class AdminController {
	@Autowired
	private AdminDao adminDao;

	@GetMapping("/login")
	public Admin login(@RequestParam String adminUsername, @RequestParam String adminPassword) {
		return adminDao.login(adminUsername, adminPassword);
	}
//	http://localhost:7777/admin/login?adminUsername=123&adminPassword=Dp

	@PutMapping("/changePassword/{id}")
	public ResponseEntity<?> changePassword(@PathVariable int id, @RequestBody Map<String, String> request) {
		try {
			String oldPassword = request.get("oldPassword");
			String newPassword = request.get("newPassword");
			Admin updatedAdmin = adminDao.changePassword(id, oldPassword, newPassword);
			return ResponseEntity.ok(updatedAdmin);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
