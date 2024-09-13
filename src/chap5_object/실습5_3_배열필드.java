package chap5_object;

class Person2 {
    // 필드 (private)
	/*
	 * name은 String, age는 int, weight는 float로 필드들을 private 선언
	 * subjects을 교육과목 private 배열
     * years을 수강 연도 private 배열
     * count 필드를 사용하여 수강 과목 증가시마다 ++count
	 */
    private String name;
    private int age;
    private float weight;
    private String[] subjects;
    private int[] years;
    int count = -1;
	
    // 메소드
    
    // name 메소드: setter, getter 함수, 교재 p199
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
    	return name;
    }
    
    // age 메소드:setter, getter 함수 구현, 교재 p199
    public void setAge(int value) {
    	age = value;
    }
    
    public int getAge() {
    	return age;
    }
    
    // weight 메소드: setter, getter 함수 구현, 교재 p199
    public void setWeight(float value) {
    	weight = value;
    }
    
    public float getWeight() {
    	return weight;
    }
    
    // subjects 메소드
    public void setSubjects(int size) {
    	subjects = new String[size];
    	
    }
    
    public String[] getSubjects() {
    	return subjects;
    }
    
    //years 메소드
    public void setYears(int size) {
    	years = new int[size];
    }
    
    public int[] getYears() {
    	return years;
    }
    
    
    void show() {
        // 기본 정보 출력::name=**, age=**, weight=**로 출력
    	System.out.println("이름:" + name + ", 나이:" + age +", 몸무게:" + weight);
        // 교육과목 및 수강 연도 출력
    	/*
    	 * while 문을 사용하여 교육과목과 수강연도를 출력
    	 */
    	int i = 0;
    	while (i<subjects.length) {
    		System.out.println("수강과목: " + subjects[i] + ", 수강년도: " + years[i]);
    		i++;
    	}

		System.out.println("총 "+(count+1) + "과목을 수강하셨습니다.");
    	System.out.println();
    }
    
  //과목, 수강연도를 매개변수로 전달받아 배열에 추가
    void addSubjectYear(String subject, int year){
    	count += 1;
    	subjects[count] = subject;
    	years[count] = year;
    	
    }
}

public class 실습5_3_배열필드 {
    public static void main(String[] args) {
        // 첫 번째 객체 생성 및 초기화
        Person2 p1 = new Person2();
        int sizeSub = 3;
        String[] sub1 = {"Mathematics", "Science", "History"};
        int[] year1 = {2020, 2021, 2022};
        //다음 코드를 setter, addSubjectYear를 사용하여 수정
        p1.setName("홍길동");
        p1.setAge(25);
        p1.setWeight(60.56f);
        p1.setSubjects(sizeSub);
        p1.setYears(sizeSub);
        //System.out.println("sub[0]: " + sub1[0]);
        
        for (int i=0; i<sizeSub; i++) {
        	p1.addSubjectYear(sub1[i], year1[i]);	
        }
        // 메소드 호출
        p1.show();
        
	        
        // 두 번째 객체 생성 및 초기화
        Person2 p2 = new Person2();
        int sizeSub1 = 3;
        String[] sub2 = {"Literature", "Philosophy", "Physics"};
        int[] year2 = {2018, 2019, 2020};
        
        p2.setName("강감찬");
        p2.setAge(55);
        p2.setWeight(62.34f);
        p2.setSubjects(sizeSub1);
        p2.setYears(sizeSub1);
        
        for (int i=0; i<sizeSub; i++) {
        	p2.addSubjectYear(sub2[i], year2[i]);	
        }
        //p2.name = "강감찬";
//        p2.age = 55;
//        p2.weight = 62.34f;
        //p2.subjects = new String[] {"Literature", "Philosophy", "Physics"};
        //p2.years = new int[] {2018, 2019, 2020};

        // 메소드 호출
        p2.show();
    }
}
