package edu.pnu.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import edu.pnu.JDBCconnect;
import edu.pnu.domain.MemberDTO;

@Repository
public class MemberDao extends JDBCconnect {
	
	Map<String, Object> resultMap = new HashMap<String, Object>();
	
	public MemberDao() {
		System.out.println("MemberDao() 생성");
	}
	
	public Map<String, Object> selectAllMember(){
		int result = 0;
		
		//Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("method", "get");
		
		List<MemberDTO> mList = new ArrayList<MemberDTO>();
		
		try {
			String query = "SELECT * FROM member";
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			
			resultMap.put("sqlstring", psmt.toString().split(" ", 2)[1]);
			
			while(rs.next()) {
				result = 1;
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getInt("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
				dto.setRegidate(rs.getDate("regidate"));
				mList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		resultMap.put("success", (result != 0));
		resultMap.put("result", mList);
		return resultMap;
	}
	
	public Map<String, Object> getMemberById(Integer id){
		//Map<String, Object> resultMap = new HashMap<String, Object>();
		MemberDTO dto = new MemberDTO();
		
		String query = "SELECT * FROM member WHERE id=?";
		//resultMap.put("sqlstring", query.replace("?", String.valueOf(id)));
		resultMap.put("method", "get");
		
		try {
			//쿼리 실행
			psmt = con.prepareStatement(query);
			psmt.setString(1, String.valueOf(id));
			rs = psmt.executeQuery();
			
			resultMap.put("sqlstring", psmt.toString().split(" ", 2)[1]);
			//결과 처리
			if(rs.next()) {
				dto.setId(rs.getInt("id"));
				System.out.println(rs.getInt("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
				dto.setRegidate(rs.getDate("regidate"));
				
				resultMap.put("success", true);
				resultMap.put("result", dto);
			} else {
				resultMap.put("success", false);
				resultMap.put("result", null);
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		// 클래스명: 쿼리문 
		return resultMap;
	}
	
	//입력 (Create - insert)
	public Map<String, Object> addMember(MemberDTO dto){
		int result = 0;
		
		//Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("method", "post");
		
		//입력한 id를 가진 멤버가 이미 있는지 없는지 조회
		MemberDTO m = (MemberDTO) getMemberById(dto.getId()).get("result");
		if(m != null) {
			System.out.println(dto.getId() + " 가 이미 존재합니다.");
			resultMap.put("sqlstring", "err: [추가 실패] " + dto.getId() + "번 id를 가진 멤버가 이미 존재합니다.");
			resultMap.put("success", false);
			resultMap.put("result", null);
			return resultMap;
		}
		dto.setRegidate(new Date());
		
		try {
			String query = "INSERT INTO member ( "
					+ " id, pass, name ) "
					+ " VALUES ( "
					+ " ?, ?, ?)";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, String.valueOf(dto.getId()));
			psmt.setString(2, dto.getPass());
			psmt.setString(3, dto.getName());
			result = psmt.executeUpdate();
			resultMap.put("sqlstring", psmt.toString().split(" ", 2)[1]);
			
			
		} catch (Exception e) {
			System.out.println("멤버 insert 중 오류 발생");
			e.printStackTrace();
		}
		
		resultMap.put("success", (result != 0));
		resultMap.put("result", dto);
		
		return resultMap;
	}
	
	//수정(Update-update)
	public Map<String, Object> updateMember(MemberDTO dto){
		//Map<String, Object> resultMap = new HashMap<String, Object>();

		int result = 0;
		resultMap.put("method", "put");
		MemberDTO m = (MemberDTO) getMemberById(dto.getId()).get("result");
		if(m == null) {
			System.out.println(dto.getId() + "번 id를 가진 멤버가 존재하지 않습니다");
			resultMap.put("sqlstring", "err: [수정 실패] " + dto.getId() + "번 id를 가진 멤버가 존재하지 않습니다");
			resultMap.put("success", false);
			resultMap.put("result", result);
			return resultMap;
		}
		
		try {
			//수정 정보
			String newPass = (dto.getPass()==null) ? m.getPass() : dto.getPass();
			String newName = (dto.getName()==null) ? m.getName() : dto.getName();
			
			//쿼리문 템플릿
			String query = "UPDATE member SET "
						+ " pass=?, name=? "
						+ " WHERE id=?";
			
			//쿼리문 완성
			psmt = con.prepareStatement(query);
			psmt.setString(1, newPass);
			psmt.setString(2, newName);
			psmt.setInt(3, m.getId());
			
			//쿼리문 실행
			result = psmt.executeUpdate();
			resultMap.put("sqlstring", psmt.toString().split(" ", 2)[1]);
			
		} catch(Exception e) {
			System.out.println("멤버 update(수정) 중 오류 발생");
			e.printStackTrace();
		}
		
		if (result==1)
			System.out.println("멤버 정보 수정 성공");

		resultMap.put("success", (result != 0));
		resultMap.put("result", result);
		return resultMap;
	}
	
	
	
	
	//삭제(Delete)
	public Map<String, Object> removeMember(Integer id) {
		//Map<String, Object> resultMap = new HashMap<String, Object>();
		int result = 0;
		String query = "DELETE FROM member WHERE id=?";
		resultMap.put("method", "delete");
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			
			result = psmt.executeUpdate();

			resultMap.put("sqlstring", psmt.toString().split(" ", 2)[1]);
			
		} catch(Exception e) {
			System.out.println("게시물 삭제 중 예외 발생");
			e.printStackTrace();
		}
		
		if (result==1) 
			System.out.println("멤버 삭제 성공");
		
		else 
			System.out.println("멤버 삭제 실패");
		
		resultMap.put("success", (result != 0));
		resultMap.put("result", result);
				
		return resultMap;
	}
}
