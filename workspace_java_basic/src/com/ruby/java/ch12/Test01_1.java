package com.ruby.java.ch12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test01_1 {
	public static void main(String[] args) {
		
		if(args.length !=2) {
			System.out.println("This program needs tow arguments like 'java Test01_1 file01 file02'");
		} else {
			
			
			long start = System.currentTimeMillis();
			copyFile(args[0], args[1]);
			System.out.println("copfyFile : " + (System.currentTimeMillis()-start));
			
			start = System.currentTimeMillis();
			copyFile1(args[0], args[1]);
			System.out.println("copfyFile : " + (System.currentTimeMillis()-start));
		}
	}

	
	
	//버퍼 스트림 사용 (빠름)
	private static void copyFile1(String string, String string2) {
		try(
				BufferedInputStream fi = new BufferedInputStream(new FileInputStream(string));
				BufferedOutputStream fo = new BufferedOutputStream(new FileOutputStream(string2));) {
			int c=0;
			while((c=fi.read()) != -1) {
				fo.write(c);
			}
			System.out.println("file copy1 success!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	//한바이트씩(한글자씩) 하기때문에 느림
	private static void copyFile(String string, String string2) {
		try(FileInputStream fi = new FileInputStream(string);
				FileOutputStream fo = new FileOutputStream(string2);) {
			int c=0;
			while((c=fi.read()) != -1) {
				fo.write(c);
			}
			System.out.println("file copy success!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
