package edu;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름: ");
		String name = sc.next();
		
		System.out.print("나이: ");
		int age = sc.nextInt();
		
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("학교 : 부산대학교");
		System.out.println("학과 : 정보컴퓨터공학부");
		System.out.println("입학 : 2015년 ");
		
		sc.close();
		
	}

}
