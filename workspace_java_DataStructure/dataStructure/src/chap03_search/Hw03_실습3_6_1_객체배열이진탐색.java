package chap03_search;

/*
 * 3장 3번 실습과제 - 객체 배열의 정렬과 이진검색 - Comparable 구현
 * 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
 * 함수(메소드) 전체를 작성하는 훈련 
 */
import java.util.Arrays;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData2 implements Comparable<PhyscData2>{
	String name;
	int height;
	double vision;
	
	public PhyscData2(String name, int height, double vision) {
		super();
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	
	@Override
	public String toString() {//[홍길동,162,0.3] 형태로 리턴한다 
		return name+ " [ 키:"+ this.height + ", 시력: " + vision + " ]" ;
	}
	
	@Override
	public int compareTo(PhyscData2 p) {
		// name 비교 버젼
		if (this.name.compareTo(p.name) > 0) return 1;
		else if (this.name.compareTo(p.name) < 0) return -1;
		else {
			// height 비교 버젼
			if (this.height>p.height)	return 1;
			else if (this.height<p.height) 	return -1;
			else {
				//3.시력 비교
				if(this.vision>p.vision)	return 1;
				else if(this.vision<p.vision)	return -1;
				else return 0;
			}
		}
	}
}

public class Hw03_실습3_6_1_객체배열이진탐색 {
	public static void main(String[] args) {
		PhyscData2[] data = {
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("나동", 164, 1.3),
				new PhyscData2("최길", 152, 0.7),
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("박동", 182, 0.6),
				new PhyscData2("박동", 167, 0.2),
				new PhyscData2("길동", 167, 0.5),
		};
		showData("정렬전", data);
		sortData(data);//6장 06-4 단순 삽입 정렬 InsertionSort() 함수로 구현
		showData("정렬후", data);
		reverse(data);
		showData("역순 재배치후", data);
		Arrays.sort(data);//사용된다 그 이유는? 이해가 되어야 한다 - compareTo() 구현을 변경하여 실행결과를 확인
		showData("Arrays.sort() 정렬후", data);
		
		PhyscData2 key = new PhyscData2("길동", 167, 0.5);
		int resultIndex = linearSearch(data, key);//compareTo()를 사용하여 구현
		System.out.println("\nlinearSearch(<길동,167,0.5>): result index = " + resultIndex);
		
		key = new PhyscData2("박동", 167, 0.6);
		/*
		 * 교재 109~113
		 */
		resultIndex = binarySearch(data, key);//compareTo()를 사용하여 구현
		System.out.println("\nbinarySearch(<박동,167,0.6>): result index = " + resultIndex);
		key = new PhyscData2("나동", 164, 0.6);
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		resultIndex = Arrays.binarySearch(data, key);//compareTo()를 사용되는지를 확인-이해할 수 있어야 한다 
		System.out.println("\nArrays.binarySearch(<나동,164,0.6>): result index = " + resultIndex);
	}
	
	static int linearSearch(PhyscData2[] arr, PhyscData2 key) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i].compareTo(key)==0)	return i;
		}
		return -1;
	}
	
	static int binarySearch(PhyscData2[] arr, PhyscData2 key) {
		
		int pl =0;
		int pr=arr.length-1;
		
		do {
			int pc = (pl+pr) / 2;
			if(arr[pc].compareTo(key)==0)
				return pc;
			else if(arr[pc].compareTo(key)<0)
				pl = pc + 1;
			else
				pr = pc - 1;
		} while(pl<=pr);
		return -1;
	}
	
	static void showData(String msg, PhyscData2[] arr) {
		System.out.println(msg);
		for(PhyscData2 p:arr) {
			System.out.println(p.toString());
		}
	}
	
	//6장 06-4 단순 삽입 정렬 InsertionSort() 함수로 구현
	static void sortData(PhyscData2[] arr) {
		for(int i=1; i<arr.length; i++) {
			int j=i;
			PhyscData2 tmp = arr[i];
			while(j>0 && arr[j-1].compareTo(tmp)>0) {
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = tmp;
		}
	}
	
	private static void reverse(PhyscData2[] arr) {
		for(int i=0; i<arr.length/2; i++) {
			swap(arr, i, arr.length-1-i);
		}
	}
	
	static void swap(PhyscData2[] arr, int idx1, int idx2) {
		PhyscData2 tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}
	
	

}

