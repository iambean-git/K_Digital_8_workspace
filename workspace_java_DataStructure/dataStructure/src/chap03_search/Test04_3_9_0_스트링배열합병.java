package chap03_search;

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
    		if(s!=null)
    			System.out.print( s + " ");
    	System.out.println();
    }
    
    static String[] mergeList(String[] arr1, String[] arr2) {
    	String[] merged = new String[arr1.length+arr2.length];
    	
    	int i = 0, j = 0, k=0;
    	while(i<arr1.length && j<arr2.length) {
    		if(arr1[i].equals(arr2[j])) {
    			merged[k] = arr1[i];
    			i++;	j++;	k++;
    		} else if (arr1[i].compareTo(arr2[j])<0) {
    			merged[k] = arr1[i];
    			k++; i++;
    		} else {
    			merged[k] = arr2[j];
    			k++; j++;
    		}
    	}
    	
    	while (i < arr1.length) {
            merged[k++] = arr1[i++];
        }
        
        while (j < arr2.length) {
            merged[k++] = arr2[j++];
        }
    	
    	return merged;
    }
}
