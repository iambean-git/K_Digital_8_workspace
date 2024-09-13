package chap3_control;

import java.util.Scanner;

public class Test19_1 {
	public static void main(String[] args) {
		int score;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("점수 입력 : ");
		score = sc.nextInt();
		
		
		System.out.println((score>=60)? "합격":"불합격");
		sc.close();
	}
}
