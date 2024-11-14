package com.ruby.java.ch08.polymorphism;

interface GPI {
	void test();
}

class GP implements GPI{
	public void test() {
		System.out.println("GP - test 1");
	}
}

class PP extends GP {
	public void test() {
		System.out.println("PP - test 2");
	}
	
	public void test1() {
		System.out.println("PP - test1 3");
	}
}

class CD extends PP {
	public void test() {
		System.out.println("CD - test 4");
	}
	public void test1() {
		System.out.println("CD - test1 5");
	}
	public void test2() {
		System.out.println("CD - test2 6");
	}
}

public class Test {

	public static void main(String[] args) {
		CD obj = new CD();
		obj.test();
		obj.test1();
		obj.test2();
		
		System.out.println("-".repeat(20));
		
		PP c = new CD();
		c.test();
		c.test1();
		//c.test2();
	
	}

}
