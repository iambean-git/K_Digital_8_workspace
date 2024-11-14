package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	MemberService mService = new MemberService();
	
	//검색 (Read-select)
	@GetMapping("/members")
	public List<MemberVO> getAllMember(){
		return mService.getAllMember();
	}
	
	//검색 (Read-select)
	@GetMapping("/member")
	public MemberVO getMemberById(Integer id){
		return mService.getMemberById(id);
	}
	
	//입력 (Create - insert)
	@PostMapping("/member")
	public MemberVO addMember(@RequestBody MemberVO memberVO){
		return mService.addMember(memberVO);
	}	
	
	//수정(Update-update)
	@PutMapping("/member")
	public int updateMember(@RequestBody MemberVO memberVO){
		return mService.updateMember(memberVO);
	}
	
	//삭제(Delete)
	@DeleteMapping("/member")
	public int removeMember(@RequestBody Integer id) {
		return mService.removeMember(id);
	}
}
