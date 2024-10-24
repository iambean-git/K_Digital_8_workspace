package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryByStatment {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/world";
			con = DriverManager.getConnection(url, "root", "tiger");	//db 연결
			st = con.createStatement();									//질의 객체 생성
			rs = st.executeQuery("select id, name, countrycode, "
								+ "district, population from city");	//select 실행하는 메서드
			// 이때 커서는 시작 빈행을 가리키고 있는 상태
			// rs.next() 를 호출해서 다음 row의 데이터를 서버에서 읽어 옴 
			// (return값이 false가 될때까지)
			while(rs.next()) {
				System.out.print(rs.getInt("id") + ",");
				System.out.print(rs.getString("name") + ",");
				System.out.print(rs.getString("countrycode") + ",");
				System.out.print(rs.getString("district") + ",");
				System.out.print(rs.getInt("population") + "\n");
			}
		} catch(Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		} finally {
			try {
				//close문을 finally로 굳이 빼놓은 이유?
				//rs/st/con/rs.next 등 어디서 오류가 나든 이미 열린애들을 close 해주어야함!
				if(rs != null) rs.close();
				if(st != null) st.close();
				if(con != null) con.close();
			} catch (Exception e) {

			}
		}
	}

}
