package chap6_object_oriented;

public class Member {

	private String name;
	private int age;
	
	public Member() {
		this("guest"); //1개짜리 생성자 호출
	
	}
	
	public Member(String name) {
		this(name,0);	// 2개짜리 생성자 호출
	}
	
	
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
		
	}

	public String toString() {
		return name + " : " + age;
	}
	
	public static void main(String[] args) {
		Member m1 = new Member();
		Member m2 = new Member("Amy");
		Member m3 = new Member("Amy",23);
		
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());
		
	}

}
