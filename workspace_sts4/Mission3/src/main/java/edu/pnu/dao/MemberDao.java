package edu.pnu.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.JDBCconnect;
import edu.pnu.domain.MemberDTO;

public class MemberDao extends JDBCconnect {
	
	public List<MemberDTO> selectAllMember(){
		List<MemberDTO> mList = new ArrayList<MemberDTO>();
		
		String query = "SELECT * FROM member";
		try {
			
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
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
		return mList;
	}
	
	public MemberDTO getMemberById(Integer id){
		MemberDTO dto = new MemberDTO();
		
		String query = "SELECT * FROM member WHERE id=?";
		try {
			//쿼리 실행
			psmt = con.prepareStatement(query);
			psmt.setString(1, String.valueOf(id));
			rs = psmt.executeQuery();
			
			//결과 처리
			if(rs.next()) {
				dto.setId(rs.getInt("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
				dto.setRegidate(rs.getDate("regidate"));
				return dto;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//입력 (Create - insert)
	public MemberDTO addMember(MemberDTO dto){
		if(getMemberById(dto.getId()) != null) {
			System.out.println(dto.getId() + " 가 이미 존재합니다.");
			return null;
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
			psmt.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("멤버 insert 중 오류 발생");
			e.printStackTrace();
		}
		
		return dto;
	}
	
	//수정(Update-update)
	public int updateMember(MemberDTO dto){
		int result = 0;
		MemberDTO m = getMemberById(dto.getId());
		if(m == null) {
			System.out.println(dto.getId() + "번 id를 가진 멤버가 존재하지 않습니다");
			return 0;
		}
		try {
			//쿼리문 템플릿
			String query = "UPDATE member SET "
						+ " pass=?, name=? "
						+ " WHERE id=?";
			
			//쿼리문 완성
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getPass());
			psmt.setString(2, dto.getName());
			psmt.setInt(3, m.getId());
			
			//쿼리문 실행
			result = psmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("멤버 update(수정) 중 오류 발생");
			e.printStackTrace();
		}
		
		if (result==1)
			System.out.println("멤버 정보 수정 성공");

		return result;
	}
	
	//삭제(Delete)
	public int removeMember(Integer id) {
		int result = 0;
		
		try {
			String query = "DELETE FROM member WHERE id=?";
			
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			
			result = psmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("게시물 삭제 중 예외 발생");
			e.printStackTrace();
		}
		
		if (result==1)
			System.out.println("멤버 삭제 성공");
		else
			System.out.println("멤버 삭제 실패");
		
		return result;
	}
}
