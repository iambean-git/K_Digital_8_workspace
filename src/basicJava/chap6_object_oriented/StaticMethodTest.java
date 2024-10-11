package basicJava.chap6_object_oriented;

public class StaticMethodTest {
	int num = 123;
	public static void main(String[] args) {
		StaticMethodTest.print1();
		StaticMethodTest smt = new StaticMethodTest();
		smt.print2("!");
	}
	
	public static void print1() {
		//int num2 = num; //오류!
		System.out.println("hello");
		
	}
	
	public void print2(String value) {
		int num3 = num;
		System.out.println("java" + value);
	}
}
