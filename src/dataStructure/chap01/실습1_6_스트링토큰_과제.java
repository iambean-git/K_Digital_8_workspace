package dataStructure.chap01;

import java.util.StringTokenizer;
import java.util.Arrays;

public class 실습1_6_스트링토큰_과제 {
	/*
	 * StringTokenizer(input), countTokens(), hasMoreTokens(), nextToken()
	 * parseDouble(stringArray[i])
	 */
	// 문자열을 실수로 추출하여 배열에 저장하고 정렬하는 함수
	private static String[] extractSortStrings(String str) {
		StringTokenizer st = new StringTokenizer(str);
		String[] result = new String[st.countTokens()];
		int i = 0;
		while (st.hasMoreTokens()) {
			result[i] = st.nextToken();
			i += 1;
		}
		Arrays.sort(result);
		return result;
	}

	// 문자열 배열을 실수 배열로 변환한 후 정렬하는 함수
	private static double[] convertSortToDouble(String[] strL) {
		double[] result = new double[strL.length];
		for(int i=0; i<strL.length; i++) {
			result[i] = Double.parseDouble(strL[i]);
		}
		Arrays.sort(result);
		return result;
	}

	// 문자열 배열 출력 함수
	private static void printStringArray(String[] strL) {
		for (String s : strL) {
			System.out.print(s + " ");
		}
		System.out.println();
	}

	// 실수 배열 출력 함수
	private static void printDoubleArray(double[] doubleL) {
		for (double d : doubleL) {
			System.out.print(d + " ");
		}
	}

	public static void main(String[] args) {
		String msg = "3.24 3.34156 1141.56 214. 0.0314156 54.12f";

		// 실수를 문자열로 추출하고 정렬 후 출력
		String[] sortedStringArray = extractSortStrings(msg);
		System.out.println("정렬 스트링 배열:");
		printStringArray(sortedStringArray);

		// 문자열 배열을 실수 배열로 변환하고 정렬 후 출력
        double[] sortedDoubleArray = convertSortToDouble(sortedStringArray);
        System.out.println("정렬 실수 배열:");
        printDoubleArray(sortedDoubleArray);
	}
}
