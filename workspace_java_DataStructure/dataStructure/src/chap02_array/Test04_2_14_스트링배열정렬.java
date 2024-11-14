package chap02_array;

/*
 * 2장 실습과제4 - 스트링 배열 정렬
 * 정렬된 배열에 insert하면 중간에 끼워 넣으면 큰 값들은 이동해야 하고 크기를 1 증가 처리가 필요 
 */

public class Test04_2_14_스트링배열정렬 {
	public static void main(String[] args) {
		String []data = {"apple","grape","persimmon", "pear","blueberry", "strawberry", "melon", "oriental melon"};

		showData("정렬전", data);
		sortData(data);
		showData("정렬후", data);
		String[] newData = insertString(data, "banana");
		showData("삽입후 크기가 증가된 정렬 배열", newData);
		
	}
	static void showData(String msg, String[] arr) {//확장된 for 문으로 출력 
		System.out.println(msg);
		for(String s:arr) {
			System.out.print(s+" ");
		}
		System.out.println();
	}

	static void swap(String[] arr, int i, int j) {//스트링의 맞교환 함수로 sortData()에서 호출됨
		String s = arr[i];
		arr[i] = arr[j];
		arr[j] = s;
	}
	
	static void sortData(String[] arr) {//올림차순으로 정렬 - for 문을 사용하여 직접 구현한다 
		int len = arr.length;
		for(int i=0; i<len-1; i++) {
			for(int j=len-1; j>i; j--) {
				if(arr[j-1].compareTo(arr[j])>0)   
					swap(arr, j-1, j);
			}
		}
	}
	static String[] insertString(String[] arr, String str){//배열의 사이즈를 1개 증가시킨후 insert되는 스트링 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 스트링 배열을 리턴
		String[] newArr = new String[arr.length+1];
		
		int i =0;
		while(arr[i].compareTo(str) < 0 ) {
			newArr[i] = arr[i];
			i++;
		}
		newArr[i] = str;
		for(int j=i+1; j<newArr.length; j++) {
			newArr[j] = arr[j-1];
		}
		

		return newArr;
	}
}
