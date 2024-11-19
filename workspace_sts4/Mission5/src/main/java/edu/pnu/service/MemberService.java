

package edu.pnu.service;

import edu.pnu.dao.LogDao;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberDTO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private LogDao logDao;
	
	public MemberService() {
		System.out.println("===>MemberService 생성");		
	}
	
	//검색 (Read-select)
	public List<MemberDTO> getAllMember(){
		Map<String, Object> resultMap = memberDao.selectAllMember();
		logDao.addLog(resultMap);
		return (List<MemberDTO>) resultMap.get("result");
	}
	
	//검색 (Read-select)
	public MemberDTO getMemberById(Integer id){
		Map<String, Object> resultMap = memberDao.getMemberById(id);
		logDao.addLog(resultMap);
		
		return (MemberDTO) resultMap.get("result");
	}
	
	//입력 (Create - insert)
	public MemberDTO addMember(MemberDTO dto) {
		Map<String, Object> resultMap = memberDao.addMember(dto);
		logDao.addLog(resultMap);
		return (MemberDTO) resultMap.get("result");
	}
	
	//수정(Update-update)
	public int updateMember(MemberDTO dto){
		Map<String, Object> resultMap = memberDao.updateMember(dto);
		logDao.addLog(resultMap);
		return (int) resultMap.get("result");
	}
	
	//삭제(Delete)
	public int removeMember(Integer id) {
		Map<String, Object> resultMap = memberDao.removeMember(id);
		logDao.addLog(resultMap);
		return (int) resultMap.get("result");
	}

}
