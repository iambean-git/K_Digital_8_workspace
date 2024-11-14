package chap01_basic;

//화면에서 "12,4,123,11,54,5,234" 입력받아 정렬하여 특정 숫자를 찾는 알고리즘 구현 
//자바 교재 P415-422 9.2.2 String 클래스
public class Test05_문자열검색 {
	 public static void main(String[] args) {
		 String address[] = { "경기도 남양주 별내동", "서울시 영등포구 당산동", "충남 천안시 서북구", "서울시 양천구 목동", "서울시 송파구 석촌동", "전북 부안군 부안읍" };
		 	
			System.out.println("1");
			for (String element : address) {
				if (element.indexOf("서울시") != -1) {
					//System.out.println(element.indexOf("서울시"));
					System.out.println(element);
				}
			}
			System.out.println("2");
			for (String element : address) {
				if (element.lastIndexOf("별내동") != -1) {
					System.out.println(element.lastIndexOf("별내동"));
					System.out.println(element);
				}
			}
			System.out.println("3");
			for (String element : address) {
				if (element.startsWith("서울시")) {
					System.out.println(element);
				}
			}
			System.out.println("4");
			for (String element : address) {
				if (element.endsWith("별내동")) {
					System.out.println(element);
				}
			}
	}

	 
}
