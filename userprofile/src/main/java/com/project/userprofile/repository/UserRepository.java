package com.project.userprofile.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.userprofile.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public Iterable<User> deleteByUsername(String username);

}
