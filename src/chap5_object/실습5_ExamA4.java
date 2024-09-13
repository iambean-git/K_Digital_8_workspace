package chap5_object;

class Student {
	private String name;
	String[] subjects ;
	private int[] criteria;
	private int[] scores;
	int sum;
	int avg;
	
	//name 메소드
	public Student(String name, String[] sub1, int[]criteria, int[] scores){
		this.name = name;
		this.subjects = sub1;
		this.criteria = criteria;
		this.scores = scores;
	}

    
    public void sumScore() {
    	for(int i=0; i<scores.length; i++) {
    		sum+=scores[i];
    	}
    }
    
    
    public void avarage() {
    	sumScore();
    	avg = sum / scores.length;
    }
    
    
    public void isPassed() {
    	
    }
    
    
    
}

public class 실습5_ExamA4 {
	static String[] subjects1 = {"수학", "국어", "영어", "과학", "역사"};
	static int[] criteria = {50,60,70,80,90};
	
	public static void main(String[] args) {
		Student[] students = {
				new Student("홍길동", subjects1,criteria, 
							new int[] {85,90,78,88,92}),
				new Student("홍길동", subjects1,criteria, 
						new int[] {85,90,78,88,92})
		};
		
		System.out.println(">>>각 학생의 성적 테이블 출력");
    	System.out.println("==============================================");
    	System.out.println("이름\t 총점\t 평균\t 수학\t 국어\t 영어\t 과학\t 역사\t");
    	
	}

}
