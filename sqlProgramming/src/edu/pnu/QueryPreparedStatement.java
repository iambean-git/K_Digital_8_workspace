package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class QueryPreparedStatement {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Connection con = null;
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");	//생략가능
			String url = "jdbc:mysql://localhost:3306/world";
			con = DriverManager.getConnection(url, "root", "tiger");
				
				while(true) {
					System.out.println();
					System.out.print("문제 번호를 입력하세요(1~7) / 종료 (0) :: ");
					
					int numQ = sc.nextInt();
					
					if (numQ ==0)	break;
					
					switch(numQ) {
					case 1 :	question1(con); break;
					case 2 :	question2(con); break;
					case 3 :	question3(con);	break;
					case 4 :	question4(con);	break;
					case 5 :	question5(con);	break;
					case 6 :	question6(con);	break;
					case 7 :	question7(con);	break;
					}
				}
				
			} catch(Exception e) {
				System.out.println("연결 실패 : " + e.getMessage());
			} finally {
				try {
					if(con != null) con.close();
				} catch (Exception e) {

				}
			}
		}
	

	// 인구 수를 입력받아서 그보다 많은 인구를 가진 도시를 검색해서 출력하세요
	public static void question1(Connection con) {
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			System.out.println("Q1 : 입력하신 인구수보다 많은 인구를 가진 도시를 출력합니다. ");
			System.out.print(">>> 기준 인구수를 입력하세요 : ");
			int val = sc.nextInt();

			pstm = con.prepareStatement("select * from city where population > ?");
			pstm.setInt(1, val);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				System.out.print(rs.getInt("id") + ",");
				System.out.print(rs.getString("name") + ",");
				System.out.print(rs.getString("countrycode") + ",");
				System.out.print(rs.getString("district") + ",");
				System.out.print(rs.getInt("population") + "\n");

			}
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());

		} finally {
			try {
				if(pstm != null) 	pstm.close();
				if (rs != null) 	rs.close();
			} catch (Exception e) {

			}
		}
	}

	// 국가 명의 일부 또는 국가코드를 입력받아서 해당국가의 도시의 이름과 인구를 검색해서 출력
	public static void question2(Connection con) {
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			System.out.println("Q2 : 국가 명의 일부 또는 국가코드를 입력시 해당 국가의 도시의 이름과 인구를 출력합니다. ");
			System.out.print(">>> 국가명의 일부 또는 국가 코드를 입력하세요 : ");
			String val = sc.next();

			//rs = st.executeQuery("select distinct city.name, city.population, country.name from city, country where  (city.countrycode = '"+val+"' or country.name like '%"+val+"%') and city.CountryCode=country.Code;");
			
			pstm = con.prepareStatement("select distinct city.name, city.population, country.name from city, country where"
					+ " (city.countrycode = ? or country.name like ? ) and city.CountryCode=country.Code;");
			pstm.setString(1, val);
			pstm.setString(2, "%"+val+"%");
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				System.out.print(rs.getString("city.name") + ", ");
				System.out.print(rs.getInt("population") + ", ");
				System.out.print(rs.getString("country.name") + "\n");
			}

		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		} finally {
			try {
				if(pstm != null) 	pstm.close();
				if (rs != null) 	rs.close();
			} catch (Exception e) {

			}
		}
	}

	// 대륙을 입력 받아 해당 대륙에 위치한 국가를 검색해 출력 (Continent)
	public static void question3(Connection con) {
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			System.out.println("Q3 : 대륙을 입력하면 해당 대륙에 위치한 국가를 출력합니다. ");
			System.out.println("예) Europe / Asia / South America / North America / Africa / Oceania / Antarctica");
			System.out.print(">>> 대륙을 입력하세요 : ");
			String val = sc.next();
			
			pstm = con.prepareStatement("select name from country where continent = ?");
			pstm.setString(1, val);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				System.out.print(rs.getString("name") + "\n");
			}
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		} finally {
			try {
				if(pstm != null) 	pstm.close();
				if (rs != null) 	rs.close();
			} catch (Exception e) {

			}
		}

	}

	// 넓이(10,0002 km)를 입력 받아서 입력 값보다 작은 면적을 가진 국가의 이름과 면적을 면적을 오름차순으로
	public static void question4(Connection con) {
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			System.out.println("Q4 : 입력한 넓이보다 작은 면적을 가진 국가의 이름과 면적을 출력합니다. ");
			System.out.print(">>> 넓이를 입력하세요 : ");
			Float val = sc.nextFloat();

			pstm = con.prepareStatement("select name, surfacearea from country where surfacearea < ? order by surfacearea asc");
			pstm.setFloat(1, val);
			rs = pstm.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getString("name") + ", ");
				System.out.print(rs.getFloat("surfacearea") + "\n");
			}

		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {

			}
		}

	}

	// 대한민국의 District를 입력 받아서 해당 지역에 있는 모든 도시를 검색해서 출력 (예:‘Kyonggi’)
	public static void question5(Connection con) {
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			System.out.println("Q5 : 대한민국의 시/도 입력시 해당 지역의 모든 도시를 출력합니다 ");
			System.out.println("예) Seoul / Pusan / Inchon / Taegu / Taejon / Kwangju / Kyonggi / Kang-won/ Chollanam / Chollabuk / Chungchongbuk / Chungchongnam / Kyongsangnam / Kyongsangbuk / Cheju");
			System.out.print(">>> 입력하세요 : ");
			String val = sc.next();

			pstm = con.prepareStatement("select name from city where Countrycode ='kor' and District = ? ");
			pstm.setString(1, val);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				System.out.print(rs.getString("name") + "\n");

			}

		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		} finally {
			try {
				if(pstm != null) 	pstm.close();
				if (rs != null) 	rs.close();
			} catch (Exception e) {

			}
		}
	}

	// 언어를 입력받아서 해당 언어가 국가 공식 언어인 국가를 검색해서 출력 (예:'Spanish’)
	public static void question6(Connection con) {
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			System.out.println("Q6 : 언어를 입력시 해당 언어가 국가 공식 언어인 국가를 출력합니다 ");
			System.out.print(">>> 언어를 입력하세요 (예, Spanish) : ");
			String val = sc.next();
			
			pstm = con.prepareStatement("select name from country, countrylanguage where country.Code=countrylanguage.CountryCode and IsOfficial='T' and Language=? ");
			pstm.setString(1, val);
			rs = pstm.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getString("name") + "\n");
			}
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		} finally {
			try {
				if(pstm != null) 	pstm.close();
				if (rs != null) 	rs.close();
			} catch (Exception e) {

			}
		}
	}

	// CountryLanguage에서 사용자가 입력 비율 이상인 언어의 국가 코드와 비율을 검색해서 출력
	public static void question7(Connection con) {
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			System.out.println("Q7 : 비율 입력시, 해당 비율 이상인 언어의 국가 코드와 비율을 출력합니다 ");
			System.out.print(">>> 비율을 (예, 50) : ");
			Float val = sc.nextFloat();
			
			pstm = con.prepareStatement("select countrycode, percentage from countrylanguage where Percentage > ? ");
			pstm.setFloat(1, val);
			rs = pstm.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getString("countrycode") + ", ");
				System.out.print(rs.getFloat("Percentage") + "\n");
			}

		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		} finally {
			try {
				if(pstm != null) 	pstm.close();
				if (rs != null) 	rs.close();
			} catch (Exception e) {

			}
		}

	}
	
	public static void question8(Connection con) {
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			System.out.println("Q8. 입력한 기대 수명 보다 더 높은 기대 수명을 가진 나라를 출력합니다");
			System.out.print(">>> 기대수명 입력 : ");
		} catch(Exception e) {
			
		} finally {
			try {
				if(psmt != null) 	psmt.close();
				if (rs != null) 	rs.close();
			} catch (Exception e) {

			}
		}
		
	}
}
