package chap6_object_oriented;

class Student2 {
	// 필드
	private String name;
	private int age;
	private static int count;	//과목수
	private String[] subjects;
	private int[] scores;
	private int[] passFail;
	
	//numberStudents를 정적 필드로 선언
	static int numberStudents;		//학생수
	
	// 생성자
	/*name, age, subjects[], scores[], passFail[], count를 매개변수로 전달받는 생성자 정의
	 * 
	 */

	public Student2(String name, int age, String[] subjects, int[] scores, int[] passFail ,int count) {
		this.name = name;
		this.age = age;
		this.subjects = subjects;
		this.scores = scores;
		this.passFail=passFail;
		
		numberStudents++;
	}
	// 학생 수를 반환하는 정적 메소드getNumberStudents()
	
	static int getNumberStudents() {
		return numberStudents;
	}
	
	public int getCount() {
		return count;
	}
	
	//과목 게터
	public String[] getSubjects() {
		return subjects;
	}
	
	// 학생 정보를 출력하는 메소드 (예시용)
	public void printStudent() {
		
    	System.out.println("\n이름 = " + this.name + ", 나이 = " + this.age);
    	for(int i=0; i<this.subjects.length; i++) {
    		System.out.println("과목" + (i+1) + " = " + subjects[i] + ", 점수" + (i+1) + " = " + scores[i]);
    		count++;	
    	}
    }

	// 학생 정보를 출력하는 메소드 (예시용)
	public void printStudentInfo() {
		/*
		 * 이름 = **, 나이 = **
		 * 과목1 = **, 점수1 = **, 통과여부=pass
		 * 과목2 = **, 점수2 = **, 통과여부=fail
		 * ... 등으로 출력
		 */
		
		count = 0;
		System.out.println("\n이름 = " + this.name + ", 나이 = " + this.age);
    	for(int i=0; i<this.subjects.length; i++) {
    		String temp = (scores[i]>=passFail[i])? "pass":"fail";
    		System.out.println("과목" + (i+1) + " = " + this.subjects[i] + ", 점수" + (i+1) + " = " + this.scores[i]
    				+ ", 통과여부 = " + temp);
    		count++;
    	}

    	System.out.println("전체과목 통과 여부 = " + (this.isPassed()? "pass" : "fail"));
	}

	// 통과 여부 (모든 과목을 통과했는지 확인)
	public boolean isPassed() {
		//주어진 학생이 모든 과목 통여 여부를 반환 
		for (int i=0; i<scores.length; i++) {
			if (scores[i]<passFail[i])	return false;
		}
		return true;
	}

	// 6.2.2 각 학생의 성적 테이블을 출력하는 정적 메소드
	public static void printAllStudents(Student2[] students) {
		//학생 이름 + 과목명, 과목 점수 .... + 전과목통과여부:pass or fail
		System.out.print("\n이름\t ");
		for(int i=0; i<count; i++) {
			System.out.print(students[0].subjects[i] + "\t ");
		}
		System.out.println("통과");
		System.out.println("-".repeat(60));
		for(int i=0; i<numberStudents; i++) {
			System.out.print(students[i].name + "\t ");
			for (int j=0; j<students[i].scores.length; j++) {
				System.out.print(students[i].scores[j] + "\t ");
			}
			String temp = students[i].isPassed()? "pass" : "fail";
			System.out.print(temp + "\t ");
			System.out.println();
		}
	}

	// 6.2.2 과목별 최대/최소 점수 및 해당 학생을 출력하는 정적 메소드
	public static void printSubjectStats(Student2[] students) {
		System.out.println("\n>>과목별 최대/최소 점수 및 해당 학생 이름 출력 ");
		System.out.println("===============================================");
		System.out.println("과목\t 최고점\t 최저점\t최고점학생\t 최저점학생");
		System.out.println("-----------------------------------------------");
		
		int maxScores[] = new int[count];
		String maxStu[] = new String[count];
		int minScores[] = new int[count];;
		for (int i=0; i<minScores.length; i++) {
			minScores[i] = 101;
		}
		
		String minStu[] = new String[count];
		
		for (int i=0; i<numberStudents; i++) {
			for (int j=0; j<students[i].scores.length; j++) {
				if (students[i].scores[j] > maxScores[j]) {
					maxScores[j] = students[i].scores[j];
					maxStu[j]= students[i].name;
				}
				
				if (students[i].scores[j] < minScores[j]) {
					minScores[j] = students[i].scores[j];
					minStu[j]= students[i].name;
				}
			}
		}
		
		for(int i=0; i<maxStu.length; i++) {
			System.out.print(students[0].subjects[i]+ "\t " + 
			maxScores[i] + "\t " + minScores[i] + "\t" + 
			maxStu[i] + "\t "+ minStu[i] );
			System.out.println();
		}
		
	}
}


public class 실습6_3정적메소드 {
	
	public static void showStudents(Student2[] students) {
		for(int i=0; i<students.length; i++) {
			students[i].printStudentInfo();
		}
	}
	
	public static void main(String[] args) {
		String[] subjects = {"수학", "국어", "영어", "과학", "역사"};
		int []passFails = {40,70,60,55,80};
		Student2[] students = { 
				//생성자 이용해 생성
				new Student2("홍길동", 21, subjects, new int[]{20, 90, 78, 88, 92},passFails, -1),
				new Student2("김유신", 22, subjects, new int[]{75, 80, 85, 90, 95}, passFails,-1),
				new Student2("계백", 23, subjects, new int[]{65, 70, 75, 80, 85}, passFails,-1),
				new Student2("강감찬", 24, subjects, new int[]{95, 92, 88, 84, 91}, passFails,-1),
				new Student2("을지문덕", 25, subjects, new int[]{88, 76, 85, 79, 90}, passFails,-1)	
		};
		
		// 학생 수를 정적 메소드 호출로 처리

		// 학생 정보 출력 (예시)
		showStudents(students);
		
		// 각 학생의 성적 테이블 출력
		Student2.printAllStudents(students);

		// 과목별 최대/최소 점수 및 해당 학생 출력
		Student2.printSubjectStats(students);
		}
}

