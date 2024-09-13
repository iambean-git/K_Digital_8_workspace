package chap2_datatype;

import java.util.Scanner;

public class 실습2_4_조건문논리연산 {

	public static void main(String[] args) {
		
		 /*
		    * 부산에 사는 청년 여부를 참 거짓으로 판별하는 코드를 만든다.
		    * 정수 나이ㅡ 도시 이름 부산를 화면에서 입력받는다
		    * 
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
	    int age = sc.nextInt(); //정수일 때
	    System.out.print("도시이름을 입력하세요 : ");
	    String city = sc.next(); //문자열일 때 


		         // 불리언 변수 선언 및 초기화
		    /*
		      * 부산청년 여부를 표현하는 불리언 변수를 false로 선언한다
		    */

	    boolean busanMan = false;
	    
		        // 논리 연산 사용
		    /*
		      * 부산 청년의 정의는 20 < age < 30
		      * 부산 청년 여부를 표현하는 불리언 조건식은 나이조건과 도시 조건을 모두 만족해야 한다
		    */

	    busanMan = age>20 && age<30 && city.equals("부산");
	    String sbool = busanMan ? "참" : "거짓" ;

		        // 논리 결과 출력
		    /*
		      * 출력 형태는 다음과 같이 1줄에 출력한다. 부산 청년 여부는 삼항연산자를 사용하여 "참", "거짓"으로 출력한다.
		      * "나이 = **, 도시 = **, 부산청년여부 = **"
		      */
	    System.out.println("나이 = "+age+", 도시=" + city+ ", 부산청년여부 = "+ sbool);
	    sc.close();

	}

}
