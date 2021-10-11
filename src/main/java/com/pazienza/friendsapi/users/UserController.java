package com.pazienza.friendsapi.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	/**
	 * HTTP GET /user/all
	 */
	@GetMapping(path="/all")
	public @ResponseBody Iterable<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}
}
