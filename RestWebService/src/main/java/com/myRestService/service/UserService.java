package com.myRestService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myRestService.bean.UserBean;
import com.myRestService.doa.UserDao;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public List<UserBean> getAllUsers() {
		System.out.println("inside sevice - to get list of all users");
		return userDao.findAll();
	}

	public Optional<UserBean> getSingleUser(int id) {
		System.out.println("single user is : "+userDao.findById(id));
		Optional<UserBean> user = userDao.findById(id);
		
		return user;
	}

	public void deleteUser(int id) {
		System.out.println("deleting user by id");
		userDao.deleteById(id);
	}

	public UserBean createUser(UserBean user) {
		return userDao.save(user);
	}

}
