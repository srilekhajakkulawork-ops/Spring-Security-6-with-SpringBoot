package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class Securityconfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtFilter jwtFilter;
	
	@Bean @Order(1)
	  SecurityFilterChain api(HttpSecurity http) throws Exception {
	    return http
	        .securityMatcher("/api/**")
	        .csrf(csrf -> csrf.disable())
	        .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	        .authorizeHttpRequests(req -> req
	            .requestMatchers("/api/auth/login", "/api/auth/register").permitAll()
	            .anyRequest().authenticated())
	        .authenticationProvider(authenticationProvider())
	        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
	        .build();
    }
	@Bean
	@Order(2)
	SecurityFilterChain web(HttpSecurity http) throws Exception {
	    return http
	        .csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(req -> req
	            .requestMatchers(
	                "/login", "/register-page", "/register",
	                "/oauth2/**", "/login/oauth2/**",
	                "/css/**", "/js/**", "/images/**", "/error"
	            ).permitAll()
	            .anyRequest().authenticated()
	        )
	       
	        .formLogin(form -> form
	            .loginPage("/login")                 
	            .loginProcessingUrl("/login")        
	            .defaultSuccessUrl("/students", true)
	            .failureUrl("/login?error")          
	            .permitAll()
	        )
	        .oauth2Login(oauth -> oauth
	            .loginPage("/login")
	            .defaultSuccessUrl("/students", true)
	        )
	        
	        .build();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
	@Bean
	public AuthenticationManager authenticationmanager(AuthenticationConfiguration config) throws Exception {
		 return config.getAuthenticationManager();
	}
//} 
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user1 = User
//				.withDefaultPasswordEncoder()
//				.username("Siva")
//				.password("s@123")
//				.roles("USER")
//				.build();
//		UserDetails user2 = User
//				.withDefaultPasswordEncoder()
//				.username("Gan")
//				.password("g@123")
//				.roles("ADMIN")
//				.build();
//		return new InMemoryUserDetailsManager(user1, user2);
//	}
}
