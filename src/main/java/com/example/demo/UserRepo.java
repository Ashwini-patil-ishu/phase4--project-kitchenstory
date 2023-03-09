package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer> {
	@Query("select user from User user where user.Fname=?1 and user.password=?2")
	public User findByFNamePass(String Fname,String password);
//	//we can still define queires of our own over here 
	}
