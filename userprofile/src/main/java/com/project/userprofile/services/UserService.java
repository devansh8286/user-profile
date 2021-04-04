package com.project.userprofile.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.userprofile.model.User;
import com.project.userprofile.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void saveuser(User user) {

		User save = this.userRepository.save(user);

		System.out.println(save);

	}

	public Iterable<User> displayalldata(User user) {

		Iterable<User> findAll = this.userRepository.findAll();

		return findAll;
	}

	public Iterable<User> deleteUserByUsername(String username) {
		this.userRepository.deleteByUsername(username);

		return this.userRepository.findAll();

	}

}
