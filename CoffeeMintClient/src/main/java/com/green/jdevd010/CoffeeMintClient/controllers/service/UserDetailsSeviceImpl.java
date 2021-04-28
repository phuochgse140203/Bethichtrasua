package com.green.jdevd010.CoffeeMintClient.controllers.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.green.jdevd010.CoffeeMintClient.models.Coffeemint;

import com.green.jdevd010.CoffeeMintClient.daos.UserRepository;

public class UserDetailsSeviceImpl implements UserDetailsService{
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Coffeemint user = userRepository.getUserByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("");
		}
		
		return null;
	}
}
