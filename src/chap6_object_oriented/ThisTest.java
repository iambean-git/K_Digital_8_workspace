package chap6_object_oriented;

public class ThisTest {

	int i= 1;
	
	public int first() {
		int i = 2;
		int j = 3;
		this.i = i + j;
		
		return second(4);
	}
	
	public int second(int i) {
		int j = 5;
		this.i = i + j ;
		
		return this.i;
	}
	
	public static void main(String[] args) {
		ThisTest exam = new ThisTest();
		System.out.println(exam.first());
	}

}
