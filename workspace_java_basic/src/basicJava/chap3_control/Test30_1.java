package basicJava.chap3_control;
public class Test30_1 {

	public static void main(String[] args) {
		int count = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0 && i % 3 == 0) {
				System.out.println(i + "은 2와 3의 공배수입니다.");
				count++;
			}
		}
		System.out.println("총 " + count + "개 입니다.");
	}
}
