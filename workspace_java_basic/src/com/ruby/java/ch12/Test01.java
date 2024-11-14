package com.ruby.java.ch12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test01 {
	
	public static void main(String[] args) {
		
		File file = new File("b.txt");
		if(file.exists()) {
			try (Scanner sc = new Scanner(System.in)){
				while(true) {
					System.out.print("이미 존재하는 파일입니다. ");
					System.out.println("덮어 쓰시겠습니까? [Y/N]");
					String ans = sc.next();
					if(ans.equalsIgnoreCase("Y"))	break;
					else if (ans.equalsIgnoreCase("N"))	return;
				}
			}
		}
		try(FileInputStream fi = new FileInputStream("a.txt");
				FileOutputStream fo = new FileOutputStream("b.txt");) {
			int c=0;
			while((c=fi.read()) != -1) {
				fo.write(c);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
