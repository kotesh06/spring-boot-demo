package com.example.kotesh.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.kotesh.security.jwt.JWTAuthenticationFilter;
import com.example.kotesh.security.jwt.JWTLoginFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	

	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        // disable caching
	        http.headers().cacheControl();

	        http.csrf().disable() // disable csrf for our requests.
	        .authorizeRequests()
	        .antMatchers("/").permitAll()
	        .antMatchers(HttpMethod.POST,"/login").permitAll()
	        .anyRequest().authenticated()
	        .and()
	        // We filter the api/login requests
	        .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
	        // And filter other requests to check the presence of JWT in header
	        .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	        // Create a default account
	        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())  
	                .withUser("admin")
	                .password("$2a$10$v7oyNAglQmw3fho54x0koeMrfDkU6TtTSyUuao043.DNp0BMCPdi6")
	                .roles("ADMIN");
	    }

	    public static void main(String[] args) {
			
	    	String encodedPwd = new BCryptPasswordEncoder().encode("password");
	    	System.out.println(encodedPwd);
		}
}
