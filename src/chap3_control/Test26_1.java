package chap3_control;

public class Test26_1 {

	public static void main(String[] args) {
		int i = 0;
		while(true) {
			System.out.println(i);
			i++;
			if (i>=10) break;
		}
		System.out.println("OK");
	}
}
