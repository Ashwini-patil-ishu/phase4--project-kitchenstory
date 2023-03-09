package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDao {
	
	@Autowired
	UserRepo repo;
	 public User insertuser(User u) {
		 return repo.save(u);
	 }
	 public List<User> getalll()
		{
			return repo.findAll();
		}
	public User findByFNamePassword(String Fname, String password) {
//		// TODO Auto-generated method stub
		return repo.findByFNamePass(Fname, password);
	}
	public User login(User u) {
		// TODO Auto-generated method stub
		return repo.save(u);
	}
		
	}