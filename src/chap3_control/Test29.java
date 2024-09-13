package chap3_control;

public class Test29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			if(i%2==0) continue;
		System.out.println(i);
		}
		
		System.out.println("-----------------");
		
		for(int i=0; i<10; i++) {
			if(i%2==1) continue;
		System.out.println(i);
		}
	}

}
