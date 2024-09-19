package com.ruby.java.ch14;

interface MyInterface {
	public void print();
}

class MyClass1 implements MyInterface {

	@Override
	public void print() {
		System.out.println("MyClass1");
	}
}

public class Test001 {
	
	public static void test(MyInterface mi) {
		mi.print();
	}

	public static void main(String[] args) {
		MyClass1 mc1 = new MyClass1();
		test(mc1);		//MyClass1
		mc1.print();
		
		MyInterface mi = new MyInterface() {
			
			@Override
			public void print() {
				System.out.println("익명 클래스");
			}
		};
		mi.print();
		
		(new MyInterface(){
			public void print() {
				System.out.println("선언, 생성, 호출을 한번에 처리");
			}
		}).print();
	}
	
	

}
