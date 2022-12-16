package com.multiplex.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.dto.UserDTO;
import com.multiplex.entities.User;
import com.multiplex.exception.UserAlreadyExistsException;
import com.multiplex.exception.UserNotFoundException;
import com.multiplex.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	
	 @Autowired
	    private UserRepository userRepository;

	@Override
	public List<UserDTO> getAllUsers() throws UserNotFoundException{
		Iterable<User> users = userRepository.findAll();
		List<UserDTO> user2 = new ArrayList<>();
		users.forEach(user->{
		UserDTO user1 = new UserDTO();
		user1.setUserId(user.getUserId());
		user1.setUserName(user.getUserName());
		user1.setEmailId(user.getEmailId());
		user1.setPassword(user.getPassword());
		user1.setPhoneNumber(user.getPhoneNumber());
		user2.add(user1);
		});
		if(user2.isEmpty()) {
			throw new UserNotFoundException();
		}
		return user2;
	}

	@Override
	public User addUser(UserDTO userDTO) throws UserAlreadyExistsException{
		if(userRepository.findByEmailId(userDTO.getEmailId()).isEmpty()){
			User userEntity=new User();
			userEntity.setUserId(userDTO.getUserId());
			userEntity.setUserName(userDTO.getUserName());
			userEntity.setEmailId(userDTO.getEmailId());
			userEntity.setPassword(userDTO.getPassword());
			userEntity.setPhoneNumber(userDTO.getPhoneNumber());
			User user = userRepository.save(userEntity);
			return user;
		}
		else {
			throw new UserAlreadyExistsException();
		}
			
	}

	@Override
	public UserDTO getUserById(Integer userId) throws UserNotFoundException {
		Optional<User> optional = userRepository.findById(userId);
		User user = optional.orElseThrow(() -> new UserNotFoundException());
		UserDTO user2 = new UserDTO();
		user2.setUserId(user.getUserId());
		user2.setUserName(user.getUserName());
		user2.setEmailId(user.getEmailId());
		user2.setPassword(user.getPassword());
		user2.setPhoneNumber(user.getPhoneNumber());
		return user2;
	}

	@Override
	public void deleteUser(Integer userId) throws UserNotFoundException {
		Optional<User> optional = userRepository.findById(userId);
		User user = optional.orElseThrow(() -> new UserNotFoundException());
		UserDTO user2 = new UserDTO();
		user2.setUserId(user.getUserId());
		user2.setUserName(user.getUserName());
		user2.setEmailId(user.getEmailId());
		user2.setPassword(user.getPassword());
		user2.setPhoneNumber(user.getPhoneNumber());
		userRepository.deleteById(userId);
	}
	
	@Override
    public void updateUserByEmailId(Integer userId, String emailId) throws UserNotFoundException {
        // TODO Auto-generated method stub
        if(userRepository.existsById(userId)) {
            User user=userRepository.findById(userId).get();
            user.setEmailId(emailId);
            userRepository.save(user);
        }
        else {
            throw new UserNotFoundException();
        }
    }
	
	@Override
	public List<UserDTO> getUserByName(String userName) throws UserNotFoundException{
		List<User> user=userRepository.getUserByName(userName);
		if(user.isEmpty()) {
			throw new UserNotFoundException();
		}
		else {
			UserDTO user2 = new UserDTO();
			List<UserDTO> u = new ArrayList<>();
			for(User us : user) {
			user2.setUserId(us.getUserId());
			user2.setUserName(us.getUserName());
			user2.setEmailId(us.getEmailId());
			user2.setPassword(us.getPassword());
			user2.setPhoneNumber(us.getPhoneNumber());
			u.add(user2);
		}
			return u;
		}
	}
}
