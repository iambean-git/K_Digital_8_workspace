package dataStructure.chap03;

/*
 * 3장 과제1: 스트링 배열 합병 정렬
 */
import java.util.Arrays;
public class Test04_3_9_0_스트링배열합병 {
    public static void main(String[] args) {
		String[] s1 = {"홍길동", "강감찬", "을지문덕", "계백", "김유신", "최치원" };
		String[] s2 = {"독도", "울릉도", "한산도", "영도", "오륙도", "동백섬"};
		Arrays.sort(s1);
		Arrays.sort(s2);
		
		showList("s1배열 = ", s1);
		showList("s2배열 = ", s2);
	
		String[] s3 = mergeList(s1,s2);//정렬된 s1[], s2[]을 합병하여 다시 정렬된 결과를 만드는 함수 구현
		showList("스트링 배열 s3 = s1 + s2:: ", s3);
    }
    
    static void showList(String msg, String[] arr) {
    	System.out.print(msg);
    	for (String s: arr)
    		System.out.print( s + " ");
    	System.out.println();
    }
    
    static String[] mergeList(String[] arr1, String[] arr2) {
    	String[] merged = new String[arr1.length+arr2.length];
    	
    	for(int i=0; i<arr1.length; i++) {
    		merged[i] = arr1[i];
    	}
    	for(int j=0; j<arr2.length; j++) {
    		merged[j+arr1.length] = arr2[j];
    	}
    	
    	Arrays.sort(merged);
    	
    	return merged;
    }
}
