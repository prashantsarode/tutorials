package com.sampleprograms.spring.boot.rest.webservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	static {
		users.add(new User(1, "Joe", new Date()));
		users.add(new User(2, "Adam", new Date()));
		users.add(new User(3, "Chlow", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(users.size() + 1);
		}
		users.add(user);
		return user;
	}

	public User fineUser(Integer userId) {
		Optional<User> optionalUser = users.stream().filter(user -> user.getId() == userId).findFirst();
		return optionalUser.isPresent() ? optionalUser.get() : null;
	}

}
