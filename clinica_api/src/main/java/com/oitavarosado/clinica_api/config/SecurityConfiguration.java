package com.oitavarosado.clinica_api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.oitavarosado.clinica_api.filters.SecurityFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	@Autowired
	private SecurityFilter securityFilter;
    
	private static final String[] SWAGGER_WHITELIST= {
			"/swagger-ui/**",
			"/v3/api-docs/**",
			"/swagger-resources/**",
			"/swagger-resources"
	};
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf().disable()
	        .authorizeRequests()
	            .requestMatchers(SWAGGER_WHITELIST).permitAll()
	            .requestMatchers(HttpMethod.POST, "/login").permitAll()
	            .requestMatchers(HttpMethod.POST, "/cadastro").permitAll()
	            .anyRequest().authenticated()
	        .and()
	        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	    return http.build();
	}

    
   
	
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
