package com.satish.apps.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class AppsConfig{
		
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { 
        return http.csrf().disable() 
                .authorizeHttpRequests() 
                .anyRequest().authenticated()
                .and().httpBasic() 
                .and().build(); 
    } 
	
}
