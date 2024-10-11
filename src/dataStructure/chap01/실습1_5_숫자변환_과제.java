package dataStructure.chap01;

import java.util.Arrays;

public class 실습1_5_숫자변환_과제 {
/*
 * split(" ")
 * parseInt(stringArray[i])
 */
    // 문자열을 공백으로 분리하여 배열에 저장하고 정렬하는 함수
	private static String[] splitSortString(String str) {
		String[] listS = str.split(" ");
		String[] sortedList = new String[listS.length];
		
		for(int i=0; i<listS.length; i++) {
			sortedList[i] = listS[i].trim();
		}
		Arrays.sort(sortedList);
		return sortedList;
	}
   

    // 문자열 배열을 정수 배열로 변환한 후 정렬하는 함수
	private static int[] convertSortToIntArray(String[] strL) {
		int[] listInt = new int[strL.length];
		for (int i=0; i<strL.length; i++) {
			listInt[i] = Integer.parseInt(strL[i]);
		}
		Arrays.sort(listInt);
		return listInt;
	}
    

    // 문자열 배열 출력 함수
	private static void printStringArray(String[] strL) {
    	for (String s : strL) {
    		System.out.print(s + " ");
    	}
    	System.out.println();
    }
    
    // 정수 배열 출력 함수
	private static void printIntArray(int[] intL) {
		for(int i:intL) {
			System.out.print(i + " ");
		}
	}
    

    public static void main(String[] args) {
        String input = "12 111 911 921 94 23 214 222";
        
        // 문자열 배열 정렬 및 출력
        String[] sortedStringArray = splitSortString(input);
        System.out.println("Sorted String Array:");
        printStringArray(sortedStringArray);
        
        // 문자열 배열을 정수 배열로 변환 및 정렬 후 출력
        int[] sortedIntArray = convertSortToIntArray(sortedStringArray);
        System.out.println("Sorted Integer Array:");
        printIntArray(sortedIntArray);
    }

}
