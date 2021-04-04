package com.project.userprofile.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.userprofile.model.User;
import com.project.userprofile.services.UserService;

@RestController
//@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userservice;

//	@RequestMapping("/url")
//	@ResponseBody
//	public String name() {
//
//		return "Hello World";
//	}

//	create user

	@RequestMapping("/create")
	@Transactional
	public String createuser(@RequestBody User user) {

//		System.out.println("created ");

		this.userservice.saveuser(user);

		return "user created sucessfully";
	}

	// display all user

	@RequestMapping("/displayall")
	public Iterable<User> fetchall(User User) {

		return this.userservice.displayalldata(null);

	}

//	delete user by user name

	@RequestMapping("/deleteuser/{username}")
	@Transactional
	public Iterable<User> deleteUser(@PathVariable String username) {

		return this.userservice.deleteUserByUsername(username);
	}

//get single user details

	@RequestMapping("/finduser/{username}")
	public User findUser(@PathVariable String username) {

		return this.userservice.getUserByUsername(username);
	}

}
