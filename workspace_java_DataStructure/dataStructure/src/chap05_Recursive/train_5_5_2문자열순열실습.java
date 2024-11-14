package chap05_Recursive;

public class train_5_5_2문자열순열실습 {

    // 주어진 문자 배열의 순열을 생성하는 함수
    public static void permutate(char[] arr, int index) {
    	
    	if(index==arr.length-1)	{
    		System.out.println(new String(arr));
    	}
    	
        for(int i=index; i<arr.length; i++) {
        	swap(arr,index,i);  
            permutate(arr, index+1);      	
        	swap(arr,index,i);        	
        }
    }

    // 두 요소를 교환하는 함수
    public static void swap(char[] arr, int i, int j) {
    	char tmp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = tmp;
    }

    public static void main(String[] args) {
        // 문자열을 문자 배열로 변환
        String l = "abcd";
        char[] arr = l.toCharArray();
        

        // 순열 생성 및 출력
        permutate(arr, 0);
    }
}
