package com.jacaranda.primerSpring.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jacaranda.primerSpring.model.User;
import com.jacaranda.primerSpring.repository.UserRepository;



@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository repositorio;

	

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repositorio.findById(username).orElse(null);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return user;
	}

}
