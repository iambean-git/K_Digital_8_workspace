package basicJava.chap6_object_oriented;

class Count {
	public static int totalCount;
	int count;
}

public class CountTest {

	public static void main(String[] args) {
		System.out.println("실행 시작");
		Count c1 = new Count();
		Count c2 = new Count();
		Count c3 = new Count();
		
		c1.count++;
		Count.totalCount++;
		c2.count++;
		Count.totalCount++;
		c3.count++;
		Count.totalCount++;
		
		System.out.println(Count.totalCount + " : " + c1.count);
		System.out.println(Count.totalCount + " : " + c2.count);
		System.out.println(Count.totalCount + " : " + c3.count);
		
		
	}

}
