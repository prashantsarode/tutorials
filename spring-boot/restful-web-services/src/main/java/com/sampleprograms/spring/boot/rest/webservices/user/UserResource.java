package com.sampleprograms.spring.boot.rest.webservices.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.sampleprograms.spring.boot.rest.webservices.user.exceptions.UserAlreadyExistsException;
import com.sampleprograms.spring.boot.rest.webservices.user.exceptions.UserNotFoundException;
import com.sampleprograms.spring.boot.rest.webservices.user.post.Post;
import com.sampleprograms.spring.boot.rest.webservices.user.post.PostRepository;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDaoService;
	
	@Autowired
	private PostRepository postRepository;
	
//	@Autowired
//	private FilterProvider ssnFilter;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {

		List<User> users = userDaoService.findAll();

//		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(users);
//		mappingJacksonValue.setFilters(ssnFilter);

		return users;
	}

	@GetMapping("/users/{userId}")
	public Resource<User> retrieveUser(@PathVariable Integer userId) {
		System.out.println("User Id :" + userId);
		User user = findUser(userId);

		// HATEOAS
		Resource<User> userResource = new Resource<>(user);
		ControllerLinkBuilder allUsersLink = ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllUsers());
		userResource.add(allUsersLink.withRel("all-users"));
		
		ControllerLinkBuilder postLink = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getPostForUser(userId));
		userResource.add(postLink.withRel("get-user-post"));
		
//		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userResource);
//		mappingJacksonValue.setFilters(ssnFilter);
		
		
		return userResource;
	}

	private User findUser(Integer userId) {
		User user = userDaoService.findUserById(userId);
		if (user == null) {
			throw new UserNotFoundException("id : " + userId);
		}
		return user;
	}

	@DeleteMapping("/users/{userId}")
	public void deleteUser(@PathVariable Integer userId) {
		User user = findUser(userId);
		userDaoService.deleteUser(user);
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
	
	@GetMapping("/users/{userId}/post")
	public List<Post> getPostForUser(@PathVariable int userId) {
		User user = findUser(userId);
		return user.getPosts();
	}
	
	@PostMapping("/users/{userId}/post")
	public ResponseEntity<Object> createUserPost(@PathVariable int userId, @Valid @RequestBody Post post ) {
		User user = findUser(userId);
		
		post.setUser(user);
		postRepository.save(post);
		
		// In order to send 201 response to successful request,
		// ResponseEntity needs to be used
		// ServletUriComponentBuilder is used to send custom response URI
		// to be shared with client
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{userId}")
				.buildAndExpand((userDaoService.save(user)).getId()).toUri()).build();
	}
	
}
