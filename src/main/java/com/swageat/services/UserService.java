package com.swageat.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.swageat.dos.Order;
import com.swageat.dos.User;

@Service
public interface UserService {
	
	void addUser();
	List<User> getAllUsers();
	void deleteAllUsers();
	void updatePhoneNumber();
	void updateUser();
}
