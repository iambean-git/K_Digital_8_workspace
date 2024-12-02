package com.rubypaper.board.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityCofig {
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(security->security
				.requestMatchers("/board/**").authenticated()
				.requestMatchers("/admin/**").hasRole("ADMIN")
				//.requestMatchers("/","/system/**").permitAll()
				.anyRequest().permitAll()
				);
		
		http.csrf(cf->cf.disable());
		
		//로그인 성공
		http.formLogin(form->form.loginPage("/login").defaultSuccessUrl("/board/getBoardList", true));
		//접근 권한 없음
		http.exceptionHandling(ex->ex.accessDeniedPage("/system/accessDenied"));
		//로그아웃
		http.logout(logout->logout
				.logoutUrl("/system/logout")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.logoutSuccessUrl("/"));
		
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
