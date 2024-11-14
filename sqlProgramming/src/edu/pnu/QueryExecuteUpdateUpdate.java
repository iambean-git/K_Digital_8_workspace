package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class QueryExecuteUpdateUpdate {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstm = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			String url = "jdbc:mysql://localhost:3306/myfirstdb";
			con = DriverManager.getConnection(url, "root", "tiger");
			
			System.out.print("수정하실 데이터의 id를 입력하세요 :: ");
			int idNum = sc.nextInt();
			System.out.print("home 번호를 입력하세요 :: ");
			String home = sc.next();
			
			String sql = "update phonebook set home=? where id=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, home);
			pstm.setInt(2, idNum);
			pstm.executeUpdate();
			
			System.out.println("수정 완료");
			
			
		} catch(Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		} finally {
			try {
				// close문을 finally로 굳이 빼놓은 이유?
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (Exception e) {

			}
		}
	}
}
