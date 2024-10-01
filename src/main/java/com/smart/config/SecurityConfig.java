package com.smart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.smart.auth.CustomAuthenticationProvider;
import com.smart.auth.JwtAuthenticationFilter;
import com.smart.auth.OtpAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean 
    public AuthenticationProvider otpAuthenticationProvider() {
    	return new OtpAuthenticationProvider();
	}
    

    @Bean 
    public AuthenticationProvider customAuthenticationProvider() {
    	return new CustomAuthenticationProvider();
    }
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
   

    // Defining the SecurityFilterChain instead of using WebSecurityConfigurerAdapter
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        	 
        	.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**", "/register").permitAll()
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            );
            // Add JWT filter here (e.g., .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class))
        return http.build();
    }

    // Configuring the AuthenticationManager to use the custom authentication providers
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
        		.authenticationProvider(otpAuthenticationProvider())
        		.authenticationProvider(customAuthenticationProvider())
                
               
                .build();
    }

    

}
