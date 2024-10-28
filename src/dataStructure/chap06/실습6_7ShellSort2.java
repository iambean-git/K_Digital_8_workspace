package Chap6_Sorting;

/*
 * 그림 6-18: shell 정렬이 그룹이 섞이지 않는 문제: 4그룹 > 2그룹
 * 해결: h가 서로 배수가 안되게 해야
 * 셸정렬(버전 2 : h = …, 40, 13, 4, 1) - shell 정렬을 이해하기 위한 코드임 
 * [8 1 4 2 7 6 3 5] 정렬 실습 코드 
 */

import java.util.Scanner;

class 실습6_7ShellSort2 {
 //--- 셸 정렬 ---//
 static void shellSort(int[] a, int n) {
     int h;
     for (h = 1; h < n; h = h * 3 + 1)//h 초기 값을 구한다
         ;
     System.out.println("h = " + h);
     for ( ; h > 0; h /= 3)
         for (int i = h; i < n; i++) {//1회차 13<8이므로 skip한 후에 2회차에 실행
             System.out.println("h1 = " + h);
             int j;
             int tmp = a[i];
             for (j = i - h; j >= 0 && a[j] > tmp; j -= h) //i,j 값의 변화를 따라가기가 어렵다 - 디버거를 사용한 추적이 빠르다 
                 a[j + h] = a[j];
             System.out.println("h2 = " + h + ", tmp = " + tmp + ", a[j+h] = " + a[j+h]);
             a[j + h] = tmp;
             for (int na: a)
            	 System.out.print(" " + na);
             System.out.println();
         }
 }
 static void showData(int[] d) {
     for (int i = 0; i < d.length; i++)
         System.out.print(d[i] + " ");
 }
 public static void main(String[] args) {
     Scanner stdIn = new Scanner(System.in);

    // System.out.println("셸 정렬(버전 2)");
    // System.out.print("요솟수: ");
    // int nx = stdIn.nextInt();
    // int[] x = new int[nx];
     int nx = 8;
     //int[] x = new int[nx];
     int []x = {8,1,4,2,7,6,3,5};

     for (int na: x)
    	 System.out.print(" " + na);
     System.out.println();
     shellSort(x, nx);            // 배열 x를 셸정렬

     System.out.println("오름차순으로 정렬했습니다.");
     for (int i = 0; i < nx; i++)
         System.out.print(" " + x[i]);
 }
}
