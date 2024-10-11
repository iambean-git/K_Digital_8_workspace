package dataStructure.chap01;

public class Test08_문자열로변환 {

	public static void main(String[] args) {
		String s1 = String.valueOf(true);
		String s2 = String.valueOf('A');
		String s3 = String.valueOf(3.14);
		String s4 = String.valueOf(123);
		//String s5 = String.valueOf(new MyObject(123));

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		//System.out.println(s5);
	}
}