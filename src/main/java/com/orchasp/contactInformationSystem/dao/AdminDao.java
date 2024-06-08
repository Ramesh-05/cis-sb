package com.orchasp.contactInformationSystem.dao;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchasp.contactInformationSystem.entity.Admin;
import com.orchasp.contactInformationSystem.repo.AdminRepo;

@Service
public class AdminDao {
	@Autowired
	private AdminRepo adminRepo;

	public Admin login(String adminUsername, String adminPassword) {
		return adminRepo.findByAdminUserIdAndPassword(adminUsername, adminPassword);
	}

	public Admin changePassword(int id, String oldPassword, String newPassword) {
		Optional<Admin> adminOptional = adminRepo.findById(id);
		if (adminOptional.isPresent()) {
			Admin admin = adminOptional.get();
			if (admin.getAdminPassword().equals(oldPassword)) { // Verify old password
				admin.setAdminPassword(newPassword);
				return adminRepo.save(admin);
			} else {
				throw new IllegalArgumentException("Old password is incorrect");
			}
		} else {
			throw new EntityNotFoundException("Admin not found");
		}
	}

//	
//	public void changePassword(String adminUsername, String oldPassword, String newPassword) {
//        Admin admin = adminRepository.findByAdminUsername(adminUsername);
//        if (admin == null) {
//            throw new UsernameNotFoundException("Admin not found");
//        }
//
//        if (!passwordEncoder.matches(oldPassword, admin.getAdminPassword())) {
//            throw new UnauthorizedException("Invalid old password");
//        }
//
//        admin.setAdminPassword(passwordEncoder.encode(newPassword));
//        adminRepository.save(admin);
//    }
}
