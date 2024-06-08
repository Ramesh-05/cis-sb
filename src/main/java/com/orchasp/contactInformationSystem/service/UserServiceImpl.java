package com.orchasp.contactInformationSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.orchasp.contactInformationSystem.dao.UserDaoImpl;
import com.orchasp.contactInformationSystem.entity.Users;
import com.orchasp.contactInformationSystem.exception.UserNotFound;
import com.orchasp.contactInformationSystem.util.ResponseStructure;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDaoImpl dao;

	@Override
	public ResponseEntity<ResponseStructure<Users>> saveUser(Users user) {
		ResponseStructure<Users> r=new ResponseStructure<Users>();
		r.setData(dao.saveUser(user));
		r.setMessage("user data saved successfully");
		r.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Users>>(r,HttpStatus.CREATED);
	}
	@Override
	public ResponseEntity<ResponseStructure<Users>> fetchUser(int userId) {
		Users db=dao.fetchById(userId);
		if(db!=null) {

			ResponseStructure<Users> m=new ResponseStructure<Users>();
			m.setData(db);
			m.setMessage("user found successfully");
			m.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Users>>(m,HttpStatus.FOUND);
		}else {
			throw new UserNotFound("user not found....") ;
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Users>> updateUser(int memberId,Users user) {
		Users db = dao.fetchById(memberId);
		if (db != null) {
			ResponseStructure<Users> m = new ResponseStructure<Users>();
			m.setData(dao.updateUser(memberId,user));
			m.setMessage("user data fetched successfully");
			m.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Users>>(m, HttpStatus.FOUND);
		} else {
			throw new UserNotFound("no user found");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Users>> deleteUser(int userId) {
		Users db = dao.deleteById(userId);
		if(db!=null) {
		ResponseStructure<Users> s=new ResponseStructure<Users>();
		s.setData(db);
		s.setMessage("student found successfully.........");
		s.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<Users>>(s,HttpStatus.FOUND);
		}
		else {
			throw new UserNotFound("user not found for id:"+userId);
		}
	}

}
