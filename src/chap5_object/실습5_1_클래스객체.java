package chap5_object;

class Person {
    // 필드
	/*
	 * name은 String, age는 int, weight는 float로 필드 선언
	 */
	String name;
	int age;
	float weight;
	
	
    // 메소드
    void show() {
    	/*
    	 * name=**, age = **, weight = ** 형태로 출력
    	 */
    	System.out.println("name=" + name + ", age=" + age + ", weight=" + weight);	
    }
}

public class 실습5_1_클래스객체 {
    public static void main(String[] args) {
        // 객체 생성
        Person p = new Person();
        p.name = "홍길동";
        p.age = 25;
        p.weight = 60.56f;

        // 메소드 호출
        p.show();
        
        /*
         * [강감찬, 55, 62.34] 객체를 만들어
         * name=**, age = **, weight = ** 형태로 출력
         */
        
        Person p2 = new Person();
        p2.name = "강감찬";
        p2.age = 55;
        p2.weight = 62.34f;
        
        p2.show();
    }
}
