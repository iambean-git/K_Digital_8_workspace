package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class QueryExecuteUpdateInsert {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pstm = null;

		try {
			String url = "jdbc:mysql://localhost:3306/myfirstdb";
			con = DriverManager.getConnection(url, "root", "tiger");

			String sql = "insert into phonebook(name, mobile) values(?, ?)";
			pstm = con.prepareStatement(sql);

			for (int i = 0; i < 100; i++) {
				pstm.setString(1, "홍길동이" + (i + 1));
				pstm.setString(2, "010-1111-1234");

				pstm.executeUpdate();
			}

		} catch (Exception e) {
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
