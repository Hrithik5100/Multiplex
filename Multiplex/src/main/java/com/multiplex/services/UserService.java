package com.multiplex.services;

import java.util.List;

import com.multiplex.dto.UserDTO;
import com.multiplex.entities.User;
import com.multiplex.exception.UserAlreadyExistsException;
import com.multiplex.exception.UserNotFoundException;

public interface UserService {
	public List<UserDTO> getAllUsers() throws UserNotFoundException;
	public User addUser(UserDTO userDTO) throws UserAlreadyExistsException;
	public UserDTO getUserById(Integer userId) throws UserNotFoundException;
	public void deleteUser(Integer userId) throws UserNotFoundException;
	public List<UserDTO> getUserByName(String userName) throws UserNotFoundException;
	public void updateUserByEmailId(Integer userId, String emailId) throws UserNotFoundException;

}
