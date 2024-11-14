package edu.pnu;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCconnect {
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public JDBCconnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/bootmission";
			String id = "musthave";
			String pwd = "Tiger12#$";
			con = DriverManager.getConnection(url, id, pwd);
			
			System.out.println("DB 연결 성공 (기본 생성자)");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//연결해제
	public void close() {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (psmt != null) psmt.close();
			if (con != null) con.close();
			
			System.out.println("JDBC 자원 해제");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
