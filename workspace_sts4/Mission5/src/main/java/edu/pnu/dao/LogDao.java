package edu.pnu.dao;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.stereotype.Repository;

import edu.pnu.JDBCconnect;

@Repository
public class LogDao extends JDBCconnect{
	public LogDao() {
		// TODO Auto-generated constructor stub
		System.out.println("LogDao() 생성");
	}
	public void addLog( Map<String, Object> map ) {
		String method = (String) map.get("method");
		String sqlstring = (String) map.get("sqlstring");
		boolean success = (boolean) map.get("success");
		
		System.out.println("Log를 추가합니다");
		
		int result = 0;
		String query = "INSERT INTO dblog ( "
				+ " method, sqlstring, success ) "
				+ " VALUES ( "
				+ " ?, ?, ?)";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, method);
			psmt.setString(2, sqlstring);
			psmt.setBoolean(3, success);
			
			result = psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Log를 추가시 예외 발생");
			e.printStackTrace();
		}
		
		finally {
			if(result==1) {
				System.out.println("로그 추가 성공");
			} else 
				System.out.println("로그 추가 실패");
		}
	}
}
