package chap02_array;

/*
 * 2장 제출 과제 
 * Comparable 인터페이스의 구현 
 * 5번 실습 - 2장 실습 2-10를 수정하여 객체 배열의 정렬 구현
 */
import java.util.Arrays;

class PhyscData implements Comparable<PhyscData>{
	String name;
	int height=0;
	double vision=0;
	
	//생성자
	public PhyscData(String name, int height, double vision) {
		super();
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	
	public PhyscData(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {//Object 클래스 상속
		return name+ " [ 키:"+ this.height + ", 시력: " + vision + " ]" ;
	}

	@Override
	public int compareTo(PhyscData p) {
		//객체 배열을 이름 순서로 정렬, 이름이 같으면 키 값을 정렬, 키 값이 같으면 시력으로
		//1. 이름 비교
		if (this.name.compareTo(p.name) > 0) return 1;
		else if (this.name.compareTo(p.name) < 0) return -1;
		else {
			//2. 키 비교
			if (this.height>p.height)	return 1;
			else if (this.height<p.height) 	return -1;
			else {
				//3.시력 비교
				if(this.vision>p.vision)	return 1;
				else	return -1;
			}
		}
	}
	public boolean equals(Object ob) {//Object 클래스 상속
		PhyscData p = (PhyscData) ob;
		if (this.name.equals(p.name))	return true;
		else	return false;
	}
}
public class Hw02_2_14_객체배열정렬 {
	public static void main(String[] args) {
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("이기자", 164, 1.3),
				new PhyscData("나가자", 162, 0.7),
				new PhyscData("사이다", 172, 0.3),
				new PhyscData("신정신", 182, 0.6),
				new PhyscData("원더풀", 167, 0.2),
				new PhyscData("다정해", 169, 0.5),
		};
		showData("정렬전",data);
		//sortData(data);
		Arrays.sort(data);
		showData("정렬후", data);
		Arrays.sort(data);
		//int resultIndex = binarySearch(data, "사이다");
		int resultIndex = Arrays.binarySearch(data, "사이다" );
		System.out.println("사이다의 index : " + resultIndex);
		PhyscData[] newData= insertObject(data, new PhyscData("소주다", 179, 1.5));//배열의 사이즈를 1개 증가시킨후 insert되는 객체 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 객체 배열을 리턴
		showData("삽입후", newData);	
	}
	
	static void swap(PhyscData[] arr, int idx1, int idx2) {
		PhyscData tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}
	
	static void sortData(PhyscData[] arr) {
		//객체 배열을 이름 순서로 정렬, 이름이 같으면 키 값을 정렬, 키 값이 같으면 시력으로
		//compareTo()를 사용하여 구현
		for(int i=0; i<arr.length-1; i++) {
			for(int j=arr.length-1; j>i; j--) {
				if(arr[j-1].compareTo(arr[j])>0)	swap(arr, j-1,j);
			}
		}
	}
	
	static int binarySearch(PhyscData[] arr, String name) {
		//if (data[i].equals(key)) ***으로 구현
		//equals()를 사용하여 구현
		PhyscData tmp = new PhyscData(name);
		int pl = 0;
		int pr = arr.length-1;
		do {
			int pc = (pl+pr) / 2;
			if(arr[pc].equals(tmp))	
				return pc;
			else if(arr[pc].compareTo(tmp) < 0)	
				pl = pc+1;
			else 
				pr = pc-1;
		} while(pl<=pr);
		return -1;
	} 
	
	static void showData(String msg, PhyscData[] arr) {
		System.out.println(msg);
		for(PhyscData p:arr) {
			System.out.println(p.toString());
		}
	}
	
	//배열의 사이즈를 1개 증가시킨후 insert 되는 스트링 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 스트링 배열을 리턴
	static PhyscData[] insertObject(PhyscData[] arr, PhyscData p){
		PhyscData[] result = new PhyscData[arr.length+1];
		
		int i=0;
		while(arr[i].compareTo(p)<0) {
			result[i] = arr[i];
			i++;
		} 
		result[i] = p;
		for(int j=i+1; j<result.length; j++) 
			result[j] = arr[j-1];
		
		return result;
	}
}