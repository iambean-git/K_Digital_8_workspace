package chap3_control;

public class Test22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 12;
		int b = 2;
		char op = '*';
		
		switch(op) {
		case '+':
			System.out.println(a+b); break;
		case '-':
			System.out.println(a-b); break;
		case '*':
			System.out.println(a*b); break;
		case '/':
			System.out.println(a/b); break;
		default :
			System.out.println("올바른 연산자를 입력해주세요");
		}
		
	}
}
