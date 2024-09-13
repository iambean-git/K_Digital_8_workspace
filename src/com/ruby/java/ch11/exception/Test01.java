package com.ruby.java.ch11.exception;

public class Test01 {
	
	public static void test01() throws Exception {
		test02();
	}
	public static void test02() throws Exception  {
		test03();
	}
	
	public static void test03() throws Exception {
		test04();
	}
	
	public static void test04() throws Exception {
		int arr[] = new int[3];
		arr[3] = 30;	
	}
	
	public static void main(String[] args) {
			try {
				test01();
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println(e.getMessage());
			}
			System.out.println("OK");
	}

}
