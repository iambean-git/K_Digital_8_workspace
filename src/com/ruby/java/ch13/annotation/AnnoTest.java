package com.ruby.java.ch13.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Check{
	String name();
	int val();
	int repeat() default 5;
}

public class AnnoTest {
	@Check(name = "first", val = 123, repeat = 10)
	public static void test() {
		AnnoTest obj = new AnnoTest();
		try {
			Class<?> c = obj.getClass();
			Method m = c.getMethod("test");
			
			Check check = m.getAnnotation(Check.class);
			
			for(int i =0; i<check.repeat(); i++) {
				System.out.println(check.name() + " : " + check.val());
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public static void main(String[] args) {
		test();
	}

}
