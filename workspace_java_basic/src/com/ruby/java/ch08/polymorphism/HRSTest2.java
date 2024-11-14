package com.ruby.java.ch08.polymorphism;

public class HRSTest2 {
	
	public static void calcTax(Employee e) {
		//System.out.println("소득세를 계산합니다.");
		if (e instanceof Salesman) {
			Salesman s = (Salesman) e;
			s.annual_sales = 650000;
			System.out.println("Salesmane 입니다. " + s.annual_sales);
		}
		else if (e instanceof Manager) {
			Manager m = (Manager) e;
			m.num_team = 5;
			System.out.println("Manager 입니다. "  + m.num_team);
		}
		else if (e instanceof Consultant) {
			Consultant c = (Consultant) e;
			c.num_project = 35;
			System.out.println("Consultant 입니다." + c.num_project);
		}
		
	}
	
	public static void main(String[] args) {
		Salesman s = new Salesman();
		Manager m = new Manager();
		Consultant c = new Consultant();
		
		calcTax(s);
		calcTax(m);
		calcTax(c);
	}
}
