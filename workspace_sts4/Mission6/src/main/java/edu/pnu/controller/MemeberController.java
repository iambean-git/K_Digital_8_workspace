package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;

@RestController
public class MemeberController {
	
	@Autowired
	MemberService memberSerivce;
	
	@GetMapping("/members")
	public List<Member> getAllMembers(){
		return memberSerivce.getAllMembers();
	} 
	
	@GetMapping("/member/{id}")
	public Member getMemberByID(@PathVariable Integer id){
		return memberSerivce.getMemberByID(id);
	}
	
	@PostMapping("/member")
	public Member postMember(Member mem) {
		return memberSerivce.postMember(mem);
	}
	
	@PutMapping("/member")
	public Member putMember(Member mem) {
		return memberSerivce.putMember(mem);
	}
	
	@DeleteMapping("/member/{id}")
	public Member deleteMember(@PathVariable Integer id) {
		return memberSerivce.deleteMember(id);
	}
}
