package com.ruby.java.ch10;

import java.util.ArrayList;

class Book implements Comparable<Book> {
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

	public String getIsbn() {
		return isbn;
	}

	@Override
	public int compareTo(Book o) {
		return this.title.compareTo(o.title);
	}
}


class Library {
	private ArrayList<Book> books;

	public Library() {
		books = new ArrayList<>();
	}

	public void addBook(Book book) {
		books.add(book);
	}

	public void printBooks(String msg) {
		System.out.println(msg);
		for (int i = 0; i < books.size(); i++) {
			System.out.println("도서숫자=" + (i + 1) + ", " + books.get(i));
		}
	}

	public void sortBooksByTitle() {
		// String의 compareTo() 사용
		 books.sort((b1, b2) -> b1.compareTo(b2));// 9.3.3 Arrays 클래스
	}
	
	public Book searchBookByTitle(String title) {
		Book findBook = null;
		for(int i=0; i<books.size(); i++) {
			if(books.get(i).getTitle().equals(title)) {
				return books.get(i);
			}
		}
		return findBook;
	}
}


public class ExamC2 {

	public static void main(String[] args) {
		Library library = new Library();

		// 5개의 책 객체 초기화
		Book book1 = new Book("자바", "강감찬", 1995, "12"); // 책제목, 저자, 출판년도, 책교유넘버(스트링)
		Book book2 = new Book("파이썬", "이순신", 2008, "9");
		Book book3 = new Book("자바스크립트", "을지문덕", 2008, "8");
		Book book4 = new Book("자료구조", "연개소문", 1994, "45");
		Book book5 = new Book("리액트", "김춘추", 1999, "7");

		// 책 추가
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		library.addBook(book4);
		library.addBook(book5);

		// 도서 목록 출력
		library.printBooks("\n제목정렬전");

		// 도서 목록 정렬 (제목)
		library.sortBooksByTitle();

		// 정렬된 도서 목록 출력
		library.printBooks("\n제목정렬후");

		// 도서 목록 정렬 (제목)
		library.sortBooksByTitle();

		String searchTitle = "자바";
		Book foundBook = library.searchBookByTitle(searchTitle);
		if (foundBook == null)
			System.out.println("\n" + searchTitle + " 책이 없다");
		else
			System.out.println("\nSearch Book By Title by " + searchTitle +"\n"+ foundBook.toString());

		}

	
}
