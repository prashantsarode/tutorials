package com.sampleprograms.spring.boot.rest.webservices.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public User findUserById(Integer userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		return optionalUser.isPresent() ? optionalUser.get() : null;
	}

	public void deleteUser(User user) {
		userRepository.delete(user);
	}

}
