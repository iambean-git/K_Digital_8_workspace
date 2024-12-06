package edu.pnu.config;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2AuthorizationSuccessHandler;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	//체크      
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(security->security
					.requestMatchers("/member/**","/loginSuccess").authenticated()
					.requestMatchers("/manager/**").hasAnyRole("MANAGER","ADMIN")
					.requestMatchers("/admin/**").hasRole("ADMIN")
					.anyRequest().permitAll());
		
		http.csrf(cf->cf.disable());
		
		//기본 로그인 기능을 사용
//		http.formLogin(form->{});
		
		//사용자 정의 로그인 화면 적용
		http.formLogin(form->form.loginPage("/login")
								.defaultSuccessUrl("/loginSuccess",true)
					);
		
		// 구글 로그인을 실행하면 DefaultOAuth2UserService가 실행됨
		// 로그인에 성공했을 때 추가적인 작업이 필요하면 DefaultOAuth2UserService를 상속한
		// 클래스의 loadUser 메소드를 처리하면 됨
		http.oauth2Login(oauth2->oauth2.loginPage("/login")
										.defaultSuccessUrl("/loginSuccess", true));
		
		//접근 권한 없음 페이지 처리
		http.exceptionHandling(ex->ex.accessDeniedPage("/accessDenied"));
		
		//로그아웃
		http.logout(logout->logout
							.invalidateHttpSession(true)
							.deleteCookies("JSESSIONID")
							.logoutSuccessUrl("/login"));
		
		http.headers(hr->hr.frameOptions(fo->fo.disable()));
		
		
		return http.build();
	}
	
//	============= 암호화 빈 객체 등록 (방법 1. 추천**) ==============
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	============= 암호화 빈 객체 등록 (방법 2) ==============
//	교재방법 - 암호화 코드 앞에 암화화 로직 정보를 헤더에 추가
//	@Bean
//	PasswordEncoder encoder() {
//	 return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	 }
	
	
//	============== 테스트를 위해 메모리 내에 사용자 정보 저장
//	@Autowired
//	public void authenticate(AuthenticationManagerBuilder auth) throws Exception{
////		auth.inMemoryAuthentication()
////		.withUser("user")
////		.password("{noop}abcd")
////		.roles("MEMBER");
////		
////		auth.inMemoryAuthentication()
////			.withUser("manager")
////			.password("{noop}abcd")
////			.roles("MANAGER");
////		
////		auth.inMemoryAuthentication()
////		.withUser("admin")
////		.password("{noop}abcd")
////		.roles("ADMIN");
//		
//	}
}
