package com.pazienza.friendsapi.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	/**
	 * HTTP GET /user/all
	 * <p>
	 * Retrieves the full list of users from the database
	 *
	 * @return The list of retrieved users
	 */
	@GetMapping(path = "/all")
	public @ResponseBody
	Iterable<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}


	/**
	 * HTTP GET /user/{id}
	 * <p>
	 * Given an ID retrieve the user from the database for that ID.
	 *
	 * @return The user which was retrieved from the database
	 */
	@GetMapping(path = "/{id}")
	public @ResponseBody
	ResponseEntity<UserEntity> getUserById(@PathVariable Integer id) {
		Optional<UserEntity> userEntity = userRepository.findById(id);
		return userEntity
				.map(entity -> new ResponseEntity<>(entity, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}


	/**
	 * HTTP GET /user/{id}/friends
	 * <p>
	 * Given an ID retrieve the user's friends from the database.
	 *
	 * @return The list of friends for user
	 */
	@GetMapping(path = "/{id}/friends")
	public @ResponseBody
	ResponseEntity getFriendsOfUserById(@PathVariable Integer id) {
		Optional<UserEntity> userEntity = userRepository.findById(id);

		if (userEntity.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Iterable<UserEntity> friends
				= userRepository.findAllFriendsForUserById(id);

		return new ResponseEntity<>(friends, HttpStatus.OK);
	}
}
