package com.ruby.java.ch11.exception;

public class NegativeNumberException extends Exception {
	public NegativeNumberException() {
		super("음수는 허용되지 않습니다");
	}
}
