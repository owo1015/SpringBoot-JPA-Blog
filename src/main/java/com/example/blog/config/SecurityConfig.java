package com.example.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.blog.config.auth.PrincipalDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean
	BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}

	void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(encode());
	}
	
	@Bean
	SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http
			.csrf((csrf) -> csrf.disable())
        	.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
        			.requestMatchers(new AntPathRequestMatcher("/")).permitAll()
        			.requestMatchers(new AntPathRequestMatcher("/auth/**")).permitAll()
        			.requestMatchers(new AntPathRequestMatcher("/js/**")).permitAll()
        			.requestMatchers(new AntPathRequestMatcher("/css/**")).permitAll()
        			.requestMatchers(new AntPathRequestMatcher("/image/**")).permitAll()
        			.requestMatchers(new AntPathRequestMatcher("/WEB-INF/**")).permitAll()
        			.anyRequest().authenticated())
        	.formLogin((formLogin)-> formLogin
        			.loginPage("/auth/loginForm").permitAll()
        			.loginProcessingUrl("/auth/loginProc")
        			.defaultSuccessUrl("/"));
        
		return http.build();
	}
}
