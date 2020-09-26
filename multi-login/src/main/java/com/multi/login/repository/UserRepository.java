package com.multi.login.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.multi.login.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByName(String name);
	User findByIdUser(Integer id);
	User findByNameAndPassword(String name, String password);
}
