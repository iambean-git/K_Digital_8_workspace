package chap01_basic;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class 실습1_8_버퍼리더파일_과제 {
    // 파일을 읽어 각 라인을 공백으로 분리하여 정렬하는 함수
    public static String[] readSortFromFile(String filename) {
    	// 저장할 데이터
        String data = "12 1 131 2 23\n";
        String data2 = " 312 32 8 22 7\n";
        String data3 =  "11 111 9 91 911 23 24 222\n";
        // 파일에 데이터 쓰기
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
        	writer.write(data);
        	writer.write(data2);
        	writer.write(data3);
        	writer.flush();
        	
        	writer.close();
        } catch (IOException e) {
            System.out.println("파일 쓰기 중 오류 발생: " + e.getMessage());
            return new String[0];  // 오류 발생 시 빈 배열 반환
        }
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(filename));
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
             
            byte[] buf = new byte[1024];
            int len;
        	
            // 파일의 내용을 ByteArrayOutputStream에 읽기
            //len이 -1을 반환하면 문서의 끝(EOF)을 의미
            while((len=in.read(buf)) !=-1) {
            	out.write(buf, 0 , len);
            }

            // ByteArrayOutputStream의 내용을 문자열로 변환
            String fileContent = out.toString("UTF-8");
            // 공백으로 구분된 서브스트링을 배열로 변환하고 정렬
            // 공백문자(\\s+) 는 공백,탭,개행문자 등을 포함
            String[] strList = fileContent.split("\\s+");
            Arrays.sort(strList);
            return strList;
           
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];  // 오류 발생 시 빈 배열 반환
        }
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
			s=s.trim();
			System.out.print(s.trim() + " ");
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
        String filename = "C:\\workspace_java\\edu\\src\\dataStructure\\chap01\\data2.txt";  // 파일 이름 설정 (실제 파일 경로로 변경)

        // 파일에서 읽어온 문자열 배열을 정렬 후 출력
        String[] sortedStringArray = readSortFromFile(filename);
        System.out.println("파일에서 읽은 스트링의 정렬:");
        printStringArray(sortedStringArray);
        
        // 문자열 배열을 정수 배열로 변환하고 정렬 후 출력
        int[] sortedIntArray = convertSortToInt(sortedStringArray);
        System.out.println("정렬된 정수 배열:");
        printIntArray(sortedIntArray);
    }
}
