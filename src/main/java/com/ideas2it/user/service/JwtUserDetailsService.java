package com.ideas2it.user.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ideas2it.user.model.UserEntity;
import com.ideas2it.user.repository.UserRepository;
import com.ideas2it.user.vo.UserVo;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		UserEntity user = userDao.findByUsernameOrEmailId(usernameOrEmail, usernameOrEmail);
		if (user == null) {
			throw new UsernameNotFoundException("User not found for: " + usernameOrEmail);
		}
		return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}

	public UserEntity save(UserVo user) {
		UserEntity newUser = new UserEntity();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setEmailId(user.getEmailId());
		return userDao.save(newUser);
	}
}