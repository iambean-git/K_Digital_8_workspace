package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PhoneBookDao {
	private static Scanner sc = new Scanner(System.in);
	private static String url = "jdbc:mysql://localhost:3306/myfirstdb";
	private static String user = "root";
	private static String pw = "tiger";
	
	public static void main(String[] args) {
	
		try(Connection con = DriverManager.getConnection(url, user, pw)) {
			boolean flag = true;
			while(flag) {
				System.out.println();
				System.out.print("[I]nsert/[U]pdate/[D]elete/[S]elect/[N]ative/[Q]uit >> ");
				char c = sc.next().toUpperCase().charAt(0);
				
				switch(c) {
				case 'I' : insertPhonebook(con);	break;
				case 'U' : updatePhonebook(con);	break;
				case 'D' : deletePhonebook(con);	break;
				case 'S' : selectPhonebook(con);	break;
				case 'N' : NativeQuery(con);		break;
				case 'Q' : flag = false;			break;
				
				}
			}
			System.out.println("프로그램을 종료합니다");
			if(con!=null)	con.close();
			
		} catch (SQLException e) {
			System.out.println("Con 연결 실패 : " + e.getMessage());
		} 
		
	}

	

	private static void NativeQuery(Connection con) {
		System.out.print("실행하실 쿼리문을 입력하세요 >> ");
		
		String sql1 = sc.next();
		String sql2 = sc.nextLine();
		String sql = sql1 + sql2;
		
		try(PreparedStatement psmt=con.prepareStatement(sql)){
			if(sql1.equals("select")) {
				ResultSet rs = psmt.executeQuery();
				while(rs.next()) {
					System.out.print(rs.getInt("id") + ", ");
					System.out.print(rs.getString("name") + ", ");
					System.out.print(rs.getString("mobile") + ", ");
					System.out.print(rs.getString("home") + ", ");
					System.out.print(rs.getString("company") + ", ");
					System.out.print(rs.getString("email") + "\n");
				}
				
			} else {
				psmt.executeUpdate();
				System.out.println("실행 완료");
			}
			
		} catch (SQLException e) {
			System.out.println("Psmt 연결 실패 : " + e.getMessage());
		} 

	}



	private static void insertPhonebook(Connection con) {

		System.out.println("insert를 수행합니다");
		
		System.out.print("이름을 입력하세요 >> ");
		String name = sc.next();
		System.out.print("휴대폰 번호를 입력하세요 >> ");
		String mobile = sc.next();
		System.out.print("집 전화번호를 입력하세요 >> ");
		String home = sc.next();
		System.out.print("회사 번호를 입력하세요 >> ");
		String company = sc.next();
		System.out.print("이메일을 입력하세요 >> ");
		String email = sc.next();
		
		
		String sql = "insert into phonebook(name, mobile, home, company, email) values (?,?,?,?,?)" ;
		
		try (PreparedStatement psmt=con.prepareStatement(sql)){
			
			psmt.setString(1, name);
			psmt.setString(2, mobile);
			psmt.setString(3, home);
			psmt.setString(4, company);
			psmt.setString(5, email);
			psmt.executeUpdate();
			
			System.out.println("해당 정보를 추가했습니다.");
			
		} catch (SQLException e) {
			System.out.println("Psmt 연결 실패 : " + e.getMessage());
		} 
	}

	private static void updatePhonebook(Connection con) {

		System.out.print("수정하실 데이터의 id를 입력하세요 >> ");
		int id = sc.nextInt();
		System.out.print("무엇을 수정할까요? (1)이름 (2)연락처 (3)집전화번호 (4)회사번호 (5)이메일 (6)수정 종료");
		int typeS = sc.nextInt();
		
		String sqlType = null;
		
		switch (typeS) {
		case 1 :	sqlType = "name";		break;
		case 2 :	sqlType = "mobile";		break;
		case 3 :	sqlType = "home";		break;
		case 4 :	sqlType = "company";	break;
		case 5 :	sqlType = "email";		break;			
		}
		
		if(sqlType == null)	{
			System.out.println("번호를 잘못 입력했습니다.");
			return;
		}
		
		System.out.print("새로운 "+ sqlType + "을 입력하세요 >> ");
		String sqlData = sc.next();
		
		String sql = "update phonebook set "+sqlType+"=? where id=?";

		try (PreparedStatement psmt=con.prepareStatement(sql)) {

			psmt.setString(1, sqlData);
			psmt.setInt(2, id);
			
			psmt.executeUpdate();
			
			System.out.println(id + "번 data의 "+sqlType+" 정보를 수정했습니다.");
			
		} catch (SQLException e) {
			System.out.println("Psmt 연결 실패 : " + e.getMessage());
		}
		
	}
	
	private static void deletePhonebook(Connection con) {
		System.out.print("삭제하실 데이터의 id 번호를 입력하세요 >> ");
		int id = sc.nextInt();
		
		String sql = "delete from phonebook where id =?";
		
		try (PreparedStatement psmt=con.prepareStatement(sql)) {
			psmt.setInt(1, id);
			psmt.executeUpdate();
			
			System.out.println(id + "번 data를 삭제했습니다.");
			
		} catch (SQLException e) {
			System.out.println("Psmt 연결 실패 : " + e.getMessage());
		}
	}
	
	private static void selectPhonebook(Connection con) {
		
		System.out.print("찾으시는 분의 이름을 입력하세요 >> ");
		String name = sc.next();
		
		String sql = "select * from phonebook where name = ?";
		
		try (PreparedStatement psmt=con.prepareStatement(sql)) {
			psmt.setString(1, name);
			
			ResultSet rs = psmt.executeQuery();
			
			boolean check = false;
		
			while(rs.next()) {
				check = true;
				System.out.print(rs.getInt("id") + ", ");
				System.out.print(rs.getString("name") + ", ");
				System.out.print(rs.getString("mobile") + ", ");
				System.out.print(rs.getString("home") + ", ");
				System.out.print(rs.getString("company") + ", ");
				System.out.print(rs.getString("email") + "\n");
			}
			
			if(!check)
				System.out.println("해당 정보는 없습니다.");
			
		} catch (SQLException e) {
			System.out.println("Psmt 연결 실패 : " + e.getMessage());
		}
		
	}
	
}
