package chap01_basic;

public class Test07_문자열분리 {

	public static void main(String[] args) {
		String s = "한국,일본,중국,미국,독일,프랑스";

		String[] list = s.split(",");
		String[] list2 = s.split(",", 2);//2개로 분리

		for (String item : list) {
			System.out.print(" " + item);
		}
		System.out.println("\nlist length = "+list.length);
		System.out.println("=====================");
		System.out.println("list2 length = "+list2.length);
		for (String item : list2) {
			System.out.println(item);
		}
		System.out.println("=====================");

		String email = "purum@rubypaper.co.kr";
		int i = email.indexOf("@");
		String id = email.substring(0, i);
		String company = email.substring(i + 1);
		System.out.println(id);
		System.out.println(company);

	}
	
}