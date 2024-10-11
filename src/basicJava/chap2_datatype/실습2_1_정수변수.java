package basicJava.chap2_datatype;

import java.util.Scanner;

public class 실습2_1_정수변수 {

	public static void main(String[] args) {
	        // 정수형에서 실수형으로 변환 (묵시적 형 변환)
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		double dnum;
		dnum = (double)num;
		
	    /*
	    * 정수형 변수를 화면에서 입력받아 double 변수로 변환하여 출력하는 코드를 작성한다.
	    * 출력은 "정수변수값 = **, 실수변수값 = **"
	    */
		
		System.out.println("정수 변수값 : "+ num + ", 실수 변수값 : " + dnum); 


	        // 실수형에서 정수형으로 변환 (명시적 형 변환)

	    /*
	    * 실수형 변수 값을 화면에서 입력받아 정수로 변환하는 코드를 작성한다.
	    * 출력은 "실수변수값 = **, 정수변수값 = **
	    */
		
		System.out.print("실수 입력 : ");
		double dnum2 = sc.nextDouble();
		int num2;
		num2 = (int)dnum2;
		
		System.out.println("실수 변수값 : " + dnum2 + ", 정수 변수값 : " + num2);
		sc.close();

	    }
	

}
