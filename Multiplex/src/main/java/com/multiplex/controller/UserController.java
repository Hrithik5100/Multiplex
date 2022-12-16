package com.multiplex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.multiplex.dto.UserDTO;
import com.multiplex.entities.User;
import com.multiplex.exception.UserAlreadyExistsException;
import com.multiplex.exception.UserNotFoundException;
import com.multiplex.services.UserService;

@RestController

public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/usertable")
	public ResponseEntity <List<UserDTO>> getAllUsers() throws UserNotFoundException {
		List<UserDTO> userList = userService.getAllUsers();
		return new ResponseEntity<List<UserDTO>>(userList, HttpStatus.OK);
	}
	
	@PostMapping(value = "/usertable")
	public ResponseEntity<String> addUser(@RequestBody UserDTO userDTO) throws UserAlreadyExistsException{
		User userId = userService.addUser(userDTO);
		return new ResponseEntity<String>("API.INSERT_CREATED", HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/usertable/{userId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Integer userId) throws UserNotFoundException{
		UserDTO user = userService.getUserById(userId);
		return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/usertable/{userId}")
	public ResponseEntity deleteUserById(@PathVariable Integer userId) throws UserNotFoundException{
		userService.deleteUser(userId);
		return new ResponseEntity<String>("API.DELETE_SUCCESS", HttpStatus.OK);
	}
	
	@GetMapping("/usertable/u/{userName}")
	public ResponseEntity getUserByName(@PathVariable String userName) throws UserNotFoundException{
		return new ResponseEntity(userService.getUserByName(userName), HttpStatus.OK);
	}
	
	@PutMapping(value="/usertable/u/{userId}")
	public ResponseEntity updateUserByEmailId(@PathVariable Integer userId, @RequestBody UserDTO user) throws UserNotFoundException{
	    userService.updateUserByEmailId(userId, user.getEmailId());
	    return new ResponseEntity("Email Updated Successfully", HttpStatus.ACCEPTED);
	}
}
