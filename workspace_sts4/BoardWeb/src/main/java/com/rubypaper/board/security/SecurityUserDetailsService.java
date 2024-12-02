package com.rubypaper.board.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rubypaper.board.domain.Member;
import com.rubypaper.board.persistence.MemberRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberRepository memRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Member member = memRepo.findById(username).orElseThrow(()->new UsernameNotFoundException("Not Found"));
		//멤버 정보 확인
		System.out.println(member);
		
		return new SecurityUser(member);
	}
}
