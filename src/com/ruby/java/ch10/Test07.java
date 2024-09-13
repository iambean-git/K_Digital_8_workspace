package com.ruby.java.ch10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test07 {

	public static void main(String[] args) {
		HashMap<String, String> dic = new HashMap<String, String>();
		
		dic.put("고진감래", "고생 끝에");
		dic.put("분골쇄신", "몸이 부서질정도로");
		dic.put("권토중래", "실패를 발판삼아");
		dic.put("교학상자", "가르치고 배우면서");
		dic.put(null, null);
		
		//방법1
		Iterator<String> keys = dic.keySet().iterator();
		while(keys.hasNext()){
			String key = keys.next();
			System.out.println(String.format("%s : %s", key, dic.get(key)));	
		}
		
		//방법2
		for(Map.Entry<String, String> elem : dic.entrySet()) {
			System.out.println(String.format("%s : %s", elem.getKey(), elem.getValue()));
		}
		
		//방법3
		for(String key : dic.keySet()) {
			System.out.println(String.format("%s : %s", key, dic.get(key)));
		}
		
		//방법3-1
		Set<String> keys1 = dic.keySet();
		for(String key : keys1) {
			System.out.println(String.format("%s : %s", key, dic.get(key)));
		}
	}
}


