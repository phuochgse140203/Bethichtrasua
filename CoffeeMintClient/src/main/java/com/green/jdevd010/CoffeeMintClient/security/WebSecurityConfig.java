package com.green.jdevd010.CoffeeMintClient.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration()
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {

	private final String password = "$2a$10$Q/zcvmPLmSrGr/5ej9Qnt.hexa/vovXp1XhwBrsJNZzx1iYNlscCi";
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails userAdmin = User.withUsername("admin")
				.password(password).roles("ADMIN").build();
		
		UserDetails userGreen = User.withUsername("green")
				.password(password).roles("USER").build();
		
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		
		manager.createUser(userAdmin);
		manager.createUser(userGreen);
		
		return manager;
	}
}
