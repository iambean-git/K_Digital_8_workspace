package chap4_array;

public class 실습4_배열_ExamA3 {

	public static void main(String[] args) {
		String[] names= {"홍길동","김유신","계백","강감찬","을지문덕"};
		String[] subs = {"수학","국어","영어","과학","역사"};
		int[] criteria = {50,60,70,80,80};
		
		int[][] scores = {
				{85,90,78,88,92},
				{75,80,85,90,95},
				{65,70,75,80,85},
				{95,92,88,84,91},
				{88,76,86,79,90}
		};
		System.out.println(">>>학생별, 과목별 점수, 통과여부 출력");
		System.out.println("======================================");
		for (int i=0; i<names.length; i++) {
			int sum_p = 0; //개인 총점
			double avg_p = 0; //개인 평균
			System.out.println("[" + names[i] +"]");
			for(int j=0; j<subs.length; j++) {
				String pass = (scores[i][j]<criteria[j]) ? "과락" :"통과";
				System.out.println(subs[j]+ " : " + scores[i][j] + " => " + pass);
				sum_p += scores[i][j];
			}
			avg_p = sum_p / subs.length;
			System.out.println("총점 : " + sum_p);
			System.out.println("평균 : " + avg_p);
			System.out.println("\n");
		}
		
		
		//---------------------------------------------------------------------
		
		
		System.out.println("\n>>>과목 총점 및 평균 점수를 테이블로 출력");
		System.out.println("===========================================");
		System.out.print("이름\t");
		
		for (int i=0; i<subs.length; i++) {
			System.out.print(subs[i]+"\t");
		}
		System.out.println("\n---------------------------------------------");
		for(int i=0; i<scores.length; i++) {
			System.out.print(names[i] + "\t");
			for (int j=0; j<scores[i].length; j++) {
				System.out.print(scores[i][j]+"\t");
			}
			System.out.println();
		}
		
		
		//-------------arrSum/maxSum 구하기-----------------------
		int arrSum[] = new int[5];
		int maxScore[] = new int[5];
		String maxName[] = new String[5];
		
		for (int i=0; i<scores.length; i++) {
			for (int j=0; j<scores[i].length; j++) {
				
				arrSum[j] += scores[i][j];
				if (scores[i][j]>maxScore[j]) {
					
					maxScore[j]=scores[i][j];
					maxName[j]=names[i];
				}
			}
			//System.out.print(sum + "\t");
		}
		
		
		//-------------과목별 평균 출력 -----------------------
		System.out.print("총점\t");
		for (int i=0; i<arrSum.length;i++) {
			System.out.print(arrSum[i] + "\t");
		}
				
		//-------------과목별 평균 출력 -----------------------
		System.out.print("\n평균\t");
		double avg = 0;
		for (int i=0; i<arrSum.length;i++) {
			avg = (double)arrSum[i]/scores.length; 
			System.out.print(avg + "\t");
		}
		
		
		//---------------------------------------------------------------------
		System.out.println("\n\n\n===========================================");
		System.out.println(">>>과목별 최대, 최소 점수를 구하고, 해당 점수의 학생 이름을 테이블로 출력");
		System.out.println("===========================================");
		System.out.println("과목\t점수\t이름\t");
		System.out.println("---------------------");
		
		for (int i=0; i<maxScore.length;i++) {
			System.out.println(subs[i]+ "\t" + maxScore[i] + "\t" + maxName[i]);
		}
		
	}

}
