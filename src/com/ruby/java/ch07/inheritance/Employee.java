package com.ruby.java.ch07.inheritance;

public class Employee extends Person {
	private String dept;
	
	public Employee() {
		super();
		System.out.println("Employee 생성자 실행!");
	}
	
	public Employee(String name, int age, String dept) {
		super(name, age);
		this.dept =dept;
		System.out.println("Employee(name, age, dept) 생성자 실행!");
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String toString() {
		// return this.getName() + " : " + getAge() + " : " + dept;
		return super.toString() + " : " + dept;
	}

}
