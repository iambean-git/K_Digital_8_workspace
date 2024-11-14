package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class MemberController {
	
	private List<MemberVO> memberList = new ArrayList<MemberVO>();
	
	public MemberController() {
		System.out.println("===>MemberController 생성");
// ============= 방법1. 게터 세터 사용 ===================
//		for(int i=1; i<=10; i++) {
//			MemberVO member = new MemberVO();
//			member.setId(i);
//			member.setName("홍길동" + i);
//			member.setPass("pass" + i);
//			member.setRegidate(new Date());
//			memberList.add(member);
//		}

// ============= 방법2. 빌더 사용 ===================
		for(int i=1; i<=10; i++) {
			memberList.add(MemberVO.builder()
					.id(i)
					.name("홍길동" + i)
					.pass("pass" + i)
					.regidate(new Date()).build());
		}
	}
	
	//검색 (Read-select)
	@GetMapping("/members")
	public List<MemberVO> getAllMember(){
		return memberList;
	}
	
	//검색 (Read-select)
	@GetMapping("/member")
	public MemberVO getMemberById(Integer id){
		for(MemberVO mem : memberList) {
			if(mem.getId()==id) {
				return mem;
			}
		}
		return null;
	}
	
	//입력 (Create - insert)
	@PostMapping("/member")
	public MemberVO addMember(@RequestBody MemberVO memberVO){
		if(getMemberById(memberVO.getId()) != null) {
			System.out.println(memberVO.getId() + " 가 이미 존재합니다.");
			return null;
		}
		memberVO.setRegidate(new Date());
		memberList.add(memberVO);
		return memberVO;
	}
	
	//수정(Update-update)
	@PutMapping("/member")
	public int updateMember(@RequestBody MemberVO memberVO){
		MemberVO m = getMemberById(memberVO.getId());
		if(m==null)	return 0;
		m.setName(memberVO.getName());
		m.setPass(memberVO.getPass());
		return 1;
	}
	
	@DeleteMapping("/member")
	public int removeMember(@RequestBody Integer id) {
		try {
			memberList.remove(getMemberById(id));
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

}
