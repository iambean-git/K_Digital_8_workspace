package edu.pnu.service;

import java.util.List;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberDTO;

public class MemberService {
	private MemberDao memberDao = new MemberDao();
	
	
	public MemberService() {
		System.out.println("===>MemberService 생성");		
	}
	
	//검색 (Read-select)
	public List<MemberDTO> getAllMember(){
		return memberDao.selectAllMember();
	}
	
	//검색 (Read-select)
	public MemberDTO getMemberById(Integer id){
		return memberDao.getMemberById(id);
	}
	
	//입력 (Create - insert)
	public MemberDTO addMember(MemberDTO dto) {
		return memberDao.addMember(dto);
	}
	
	//수정(Update-update)
	public int updateMember(MemberDTO dto){
		return memberDao.updateMember(dto);
	}
	
	//삭제(Delete)
	public int removeMember(Integer id) {
		return memberDao.removeMember(id);
	}
}