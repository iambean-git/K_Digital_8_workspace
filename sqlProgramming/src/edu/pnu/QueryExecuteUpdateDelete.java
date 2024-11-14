package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class QueryExecuteUpdateDelete {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/myfirstdb";
			con = DriverManager.getConnection(url, "root", "tiger");
			
			String sql = "delete from phonebook where id =?";
			int idNum = 4;
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, idNum);
			pstm.executeUpdate();
			System.out.println(idNum + "번 데이터가 삭제 되었습니다.");
			
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		} finally {
			try {
				// close문을 finally로 굳이 빼놓은 이유?
				if (pstm != null)	pstm.close();
				if (con != null)	con.close();
			} catch (Exception e) {

			}
			
		}
	}

}
