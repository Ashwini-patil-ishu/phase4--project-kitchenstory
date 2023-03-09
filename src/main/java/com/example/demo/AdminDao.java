package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminDao {
	@Autowired
	AdminRepo repo;
	
	public Admin insert(Admin a) {
		return repo.save(a);
	}	
	
	public List<Admin> insertall(List<Admin> ad){
		return repo.saveAll(ad);
		
	}
	public void deletebyid(int id) {
		repo.deleteById(id);
	}


	public Admin usernamepassword(String username, String password) {
		return repo.findByusernamepassword(username, password);
	}
	public List<Admin> getall() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	public List<Admin> forget_pass(String phono){
		return repo.findByPhono(phono);
	}
}