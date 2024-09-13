package chap3_control;

public class Test31_2 {

	public static void main(String[] args) {
		
		int col = 6;
		
		for (int i=2; i<=9; i+=col) {
			for (int j=1; j<=9; j++) {
				for (int k=0; k<col ;k++) {
					System.out.print( (i+k) + "*" + j + "=" + (i+k)*j );
					System.out.print("\t");
					if ((i+k)>=9) break;
				}
				System.out.println();
				
			}
			System.out.println();			
		}
		
		/*
		int col=5;
		int stand = 8/col;
		if (8%col != 0)	stand+=1;
		
		int start = 2;
		
		for (int i=1; i<=stand; i++) {
			for (int j=1; j<=9; j++) {
				for(int z=start; z<=9; z++) {
					System.out.print(z + "*" + j + "=" + (j*z) + "\t");	
					if (z>start+col-1) break;
				}
				System.out.println();
			}
			start +=col;
			System.out.println();
		}
		*/
		
		
	
	}
	
}
