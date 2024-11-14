package com.ruby.java.ch13;

public class GenMethodTest {
	
	static <T extends Number, V extends T> boolean isInclude(T num, V[]array) {
		for (int i=0; i<array.length; i++) {
			if(array[i] == num)
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		Integer[] inum = {1,2,3,4,5};
		Double[] dnum = {1.0, 2.0, 3.0, 4.0, 5.0};
		String[] snum = {"one", "two", "three", "four", "five"};
		
		//위의 메소드 static으로 바꾸었을 때, 아래처럼 새로 생성한 후 실행해야함
		//GenMethodTest gt = new GenMethodTest();
		
		boolean b1 = isInclude(3, inum);
		System.out.println("결과 : " + b1);
		
		boolean b2 = isInclude(5.0, dnum);
		System.out.println("결과 : " + b2);
		
		GenMethodTest.<Integer, Integer>isInclude(3, inum);
		GenMethodTest.<Double, Double>isInclude(5.0, dnum);
		//double은 == 으로 비교하기 까다로움 (뒤의 쓰레기 값들 때문에)
		// *10000 해서 정수형으로 비교하거나 소수 아랫점 자리를 지정해주면서 해결가능
		
		//T는 number 상속 받았기 때문에 String이 들어올 수 없음
		//GenMethodTest.<String, String>isInclude("one", snum);
		
	}
}
