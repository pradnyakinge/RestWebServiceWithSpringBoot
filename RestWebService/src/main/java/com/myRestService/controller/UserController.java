package com.myRestService.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.myRestService.bean.UserBean;
import com.myRestService.service.UserService;
import com.myRestService.service.Exception.UserNotFoundException;


@RestController
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@GetMapping("/listOfAllUsers")
	public List<UserBean> getAllUsers()
	{
		System.out.println("inside controller - to get all user details");
		return userService.getAllUsers();
	}
	
	@GetMapping("/getUser/{id}")
	public Optional<UserBean> getSingleUser(@PathVariable int id)
	{
		// optional is use coz, whenever user is present in db or not, jpa provide proper response to us. So user is not null in any case.
		Optional<UserBean> user = userService.getSingleUser(id);
		if(!user.isPresent())
		{
			throw new UserNotFoundException("user is not found with id"+id);
		}
		return user;
	}
	
	
	  @PostMapping("/createUser/user") //@Valid for enabling validation over UseBean
	  public ResponseEntity<UserBean> createUser(@Valid @RequestBody UserBean user)
	  {
		  UserBean savedUser = userService.createUser(user);
		  
		  URI location =ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		  //ResponseEntity to send response back to client.Ater created user, location is getting in header of client.
		  return ResponseEntity.created(location).build();
	  }
	 
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable int id)
	{
		userService.deleteUser(id);
	}

}
