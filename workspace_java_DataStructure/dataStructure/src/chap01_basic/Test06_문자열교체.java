package chap01_basic;

public class Test06_문자열교체 {

	public static void main(String[] args) {
		String s = "자바 코딩, 파이썬 코딩, C 코딩, C# 코딩";

		String s2 = s.concat(" 스킬이 중요하다");

		System.out.println(s2);

		String s3 = s2.replaceAll("코딩", "프로그래밍");

		System.out.println(s3);
	}

	
}