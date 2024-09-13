package com.ruby.java.ch09.api;

import java.util.StringTokenizer;

public class Test14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String msg1 = "hello";
		System.out.println(msg1.compareTo("hello"));

		String msg = "Although the world is full of suffering, it is full also of the overcoming of it.";
		
		StringTokenizer st1 = new StringTokenizer(msg);
		System.out.println("단어 수 : " + st1.countTokens());
		
		System.out.println("====================");
		String s = "id=guest&name=Amy&pwd=1004";
		
		StringTokenizer st2 = new StringTokenizer(s,"&");
		
		while(st2.hasMoreTokens()) {
			System.out.println("남아있는 토큰 수 : " + st2.countTokens());
			System.out.println(st2.nextToken());
		}
		
		System.out.println("====================");
		StringTokenizer st3 = new StringTokenizer(s,"=&");
		
		while(st3.hasMoreTokens()) {
			System.out.println("남아있는 토큰 수 : " + st3.countTokens());
			System.out.println(st3.nextToken());
		}
	}

}
