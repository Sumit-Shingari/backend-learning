package com.multi.login.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.multi.login.model.User;
import com.multi.login.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
				new ArrayList<>());
	}
	
	public User save(User user) {
		User newUser = new User();
		newUser.setName(user.getName());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setNotSocial(user.isNotSocial());
		return userDao.save(newUser);
	}
}