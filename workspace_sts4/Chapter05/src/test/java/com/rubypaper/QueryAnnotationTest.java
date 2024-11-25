package com.rubypaper;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@SpringBootTest
public class QueryAnnotationTest {
	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void testQueryAnnotation1() {
		List<Board> boardList = boardRepo.queryAnnotationTest1("테스트 제목 10");
		
		System.out.println("검색 결과");
		for(Board board : boardList) {
			System.out.println("--->"+ board.toString());
		}
	}
	
	@Test
	public void testQueryAnnotation2() {
//		List<Object[]> boardList = boardRepo.queryAnnotationTest2("테스트 제목 10");
//		
//		System.out.println("검색 결과");
//
//		for(Object[] o : boardList) {
//			System.out.println("--->["+ o[0] + "번] 제목:" + o[1] + ", 작성자: " + o[2] + ", 작성일: "+o[3]);
////			System.out.println(Arrays.toString(o));
//		}
	}
}
