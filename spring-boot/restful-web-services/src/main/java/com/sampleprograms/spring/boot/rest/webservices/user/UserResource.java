package com.sampleprograms.spring.boot.rest.webservices.user;

import java.util.List;

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

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDaoService;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userDaoService.findAll();
	}

	@GetMapping("/users/{userId}")
	public User retrieveUser(@PathVariable Integer userId) {
		User user = userDaoService.findUserById(userId.intValue());
		if (user == null) {
			throw new UserNotFoundException("id : " + userId);
		}
		return userDaoService.findUserById(userId.intValue());
	}

	@DeleteMapping("/users/{userId}")
	public void deleteUser(@PathVariable Integer userId) {
		User user = userDaoService.deleteUserById(userId.intValue());
		if (user == null) {
			throw new UserNotFoundException("id : " + userId);
		}
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		validateUser(user);
		// In order to send 201 response to successful request,
		// ResponseEntity needs to be used
		// ServletUriComponentBuilder is used to send custom response URI
		// to be shared with client
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{userId}")
				.buildAndExpand((userDaoService.save(user)).getId()).toUri()).build();
	}

	private void validateUser(User user) {
		validateUserId(user.getId());
	}

	private void validateUserId(Integer id) {
		if (id != null && userDaoService.findUserById(id) != null) {
			throw new UserAlreadyExistsException("User Already Exists for id : " + id);
		}
	}
}
