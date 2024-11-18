package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberDTO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	@Autowired
	private MemberService mService;
	
		
	//검색 (Read-select)
	@GetMapping("/members")
	public List<MemberDTO> getAllMember(){
		return mService.getAllMember();
	}
	
	//검색 (Read-select)
	@GetMapping("/member")
	public  MemberDTO getMemberById(Integer id){
		return mService.getMemberById(id);
	}
	
	//입력 (Create - insert)
	@PostMapping("/member")
	public MemberDTO addMember(@RequestBody MemberDTO memberDTO){
		return mService.addMember(memberDTO);
	}
	
	//수정(Update-update)
	@PutMapping("/member")
	public int updateMember(MemberDTO dto){
		return mService.updateMember(dto);
	}
	
	//삭제(Delete)
	@DeleteMapping("/member")
	public int removeMember(Integer id) {
		return mService.removeMember(id);
	}
}


