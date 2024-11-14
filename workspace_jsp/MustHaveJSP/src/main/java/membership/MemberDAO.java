package membership;

import common.JDBCconect;
public class MemberDAO extends JDBCconect {
	
	//dao작동 확인 테스트
//	public static void main(String[] args) {
//		System.out.println("test");
//		MemberDAO dao = new MemberDAO(
//				"com.mysql.cj.jdbc.Driver", 
//				"jdbc:mysql://localhost:3306/musthave",
//				"musthave",
//				"Tiger12#$");
//		
//		MemberDTO dto = dao.getMemberDTO("musthave", "1234");
//		System.out.println(dto);
//	}
	
	//명시한 데이터베이스로의 연결이 완료된 MemberDAO 객체를 생성
	public MemberDAO(String drv, String url, String id, String pw) {
		super(drv, url, id, pw);
	}
	
	//명시한 아이디/패스워드와 일치하는 회원 정보를 반환
	public MemberDTO getMemberDTO(String uid, String upass) {
		MemberDTO dto = new MemberDTO();
		String query = "SELECT * FROM member WHERE id=? AND pass=?";
		
		try {
			//쿼리 실행
			psmt = con.prepareStatement(query);
			psmt.setString(1, uid);
			psmt.setString(2, upass);
			rs = psmt.executeQuery();
			
			//결과 처리
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	} 

}
