package com.ruby.java.ch12과제;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String author;
	private int publicationYear;
	private String isbn;

	public Book(String title, String author, int publicationYear, String isbn) {
		super();
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "도서명=" + title + ", 저자=" + author + ", 출판연도=" + publicationYear + ", isbn=" + isbn;
	}

	public String getTitle() {
		return title;
	}
}

class Library implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final int CAPACITY = 5; // 기본 용량을 5로 설정
	private Book[] books;
	private int top;

	public Library() {
		books = new Book[CAPACITY];
		top = 0;
	}

	void addBook(Book bk) {
		books[top] = bk;
		top++;
	}

	public void printBooks(String msg) {
		System.out.println(msg + " 도서숫자 = " + top);
		for(int i=0; i<top; i++) {
			System.out.println(books[i].toString());
		}
		
	}
	
	public void sortBooksByTitle() {
		Arrays.sort(books, 0, top, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
	}
}

public class 실습12_1_입출력_과제 {

	private static void saveLibrary(Library library, String filename) {
		try(ObjectOutputStream out =
				new ObjectOutputStream(new FileOutputStream(filename))){
			out.writeObject(library);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private static Library loadLibrary(String string) {
		Library lib1 = new Library();
		try(ObjectInputStream in =
				new ObjectInputStream(new FileInputStream(string))){
			lib1 = (Library) in.readObject();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return lib1;
	}

	public static void main(String[] args) throws IOException {

		Library library = new Library();

		// 5개의 Book 객체 배열 저장
		library.addBook(new Book("자바", "강감찬", 1995, "12"));
		library.addBook(new Book("파이썬", "이순신", 2008, "9"));
		library.addBook(new Book("자바스크립트", "을지문덕", 2008, "8"));
		library.addBook(new Book("자료구조", "연개소문", 1994, "45"));
		library.addBook(new Book("리액트", "김춘추", 1999, "7"));

		// 현재 도서 목록 출력
		library.printBooks("현재 도서 목록:");

		// 라이브러리 저장
		saveLibrary(library, "library.dat");

		System.out.println("-".repeat(80));

		Library lib = loadLibrary("library.dat");

		// 최종 도서 목록 출력
		lib.printBooks("최종 도서 목록:");
	}
}
