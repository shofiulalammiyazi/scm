package com.project.scm.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				//.requestMatchers("/")
				//.permitAll()
				.anyRequest()
				.authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails user =User.withDefaultPasswordEncoder()
					.username("admin")
					.password("123")
					.roles("ADMIN")	
					.build();
		
		UserDetails bkash =
				 User.withDefaultPasswordEncoder()
					.username("bkash")
					.password("1234")
					.roles("BKASH")
					.build();
		
		UserDetails nagad =
				 User.withDefaultPasswordEncoder()
					.username("nagad")
					.password("12345")
					.roles("NAGAD")
					.build();
		
		return new InMemoryUserDetailsManager(user , bkash , nagad);
	}
}
