package dataStructure.chap01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class 실습1_7_파일데이터_과제 {
/*
 * trim(),split(" ")
 */
    // 파일을 읽어 각 라인을 공백으로 분리하여 정렬하는 함수
    public static String[] readSortFromFile(String filename) {
    	// 저장할 데이터
        String data = "12 1 131 2 23";
        String data2 = " 312 32 8 22 7";
        // 파일에 데이터 쓰기
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
        	// 데이터를 파일에 씀
        	writer.write(data);
        	writer.write(data2);
        	writer.flush();
            
        	writer.close();
        } catch (IOException e) {
            System.out.println("파일 쓰기 중 오류 발생: " + e.getMessage());
        }
        
        StringBuilder sb = new StringBuilder();
        // 라인을 읽어서 StringBuilder에 추가
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        	String str;
        	while((str=br.readLine())!= null) {
        		sb.append(str);
        	}
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 공백으로 구분된 서브스트링을 배열로 변환하고 정렬
        String[] strList = String.valueOf(sb).split(" ");
        Arrays.sort(strList);
     
        // 정렬된 배열 반환
        return strList;
    }

    // 문자열 배열을 정수 배열로 변환하고 정렬하는 함수
    private static int[] convertSortToInt(String[] strL) {
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
        String filename = "C:\\workspace_java\\edu\\src\\dataStructure\\chap01\\data.txt";  // 파일 이름 설정 (실제 파일 경로로 변경)

        // 파일에서 읽어온 문자열 배열을 정렬 후 출력
        String[] sortedStringArray = readSortFromFile(filename);
        System.out.println("Sorted String Array from File:");
        printStringArray(sortedStringArray);
        
        // 문자열 배열을 정수 배열로 변환하고 정렬 후 출력
        int[] sortedIntArray = convertSortToInt(sortedStringArray);
        
        
        System.out.println("Sorted Integer Array:");
        printIntArray(sortedIntArray);
    }
}
