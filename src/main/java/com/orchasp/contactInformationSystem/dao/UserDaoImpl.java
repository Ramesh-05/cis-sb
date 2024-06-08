package com.orchasp.contactInformationSystem.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.orchasp.contactInformationSystem.entity.Users;
import com.orchasp.contactInformationSystem.repo.UserRepo;
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private UserRepo repo;

	@Override
	public Users saveUser(Users u) {
		return repo.save(u);
	}

	@Override
	public List<Users> fetchAll() {
		return repo.findAll();
	}

	@Override
	public Users fetchById(int memberId) {
		Optional<Users> op=repo.findById(memberId);
		if(op.isPresent())
			return op.get();
		else
			return null;
	}

	@Override
	public Users updateUser(int memberId,Users s){
		Optional<Users> op=repo.findById(memberId);
		if(op.isPresent()) {
			Users us=op.get();
			if(s.getConfirmPassword()!=null)
				us.setConfirmPassword(s.getConfirmPassword());
			if(s.getContactAddress()!=null)
				us.setContactAddress(s.getContactAddress());
			if(s.getEmail()!=null)
				us.setEmail(s.getEmail());
			if(s.getMobileNumber()!=0)
				us.setMobileNumber(s.getMobileNumber());
			if(s.getName()!=null)
				us.setName(s.getName());
			if(s.getPassword()!=null)
				us.setPassword(s.getPassword());
			if(s.getTelephoneNumber()!=null)
				us.setTelephoneNumber(s.getTelephoneNumber());
			return repo.save(us);
		}
		else
			return  null;
	}

	@Override
	public Users deleteById(int id) {
		Optional<Users> op=repo.findById(id);
		if(op.isPresent()) {
			repo.deleteById(id);
			return op.get();
		}
		else
			return null;
	}
	
	public Users login(String name, String password) {
		return repo.findByUserIdAndPassword(name, password);
	}

	public Users changePassword(int id, String oldPassword, String newPassword) {
		Optional<Users> adminOptional = repo.findById(id);
		if (adminOptional.isPresent()) {
			Users user = adminOptional.get();
			if (user.getPassword().equals(oldPassword)) { // Verify old password
				user.setPassword(newPassword);
				return repo.save(user);
			} else {
				throw new IllegalArgumentException("Old password is incorrect");
			}
		} else {
			throw new EntityNotFoundException("Admin not found");
		}
	}

}
