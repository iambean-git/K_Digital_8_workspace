package com.rubypaper;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@SpringBootTest
public class QueryMethodTest {

	@Autowired
	private BoardRepository boardRepo;
	
	//@BeforeEach
	public void datePrepare() {
		for(int i=1; i<=200; i++) {
			boardRepo.save(Board.builder()
								.title("테스트 제목 " + i)
								.writer("테스터 작성자 " + i )
								.content("테스트 내용 " + i)
								.createDate(new Date())
								.cnt(0L)
								.build());
		}
	}
	
	//@Test
	public void testFindByTitle() {
		List<Board> boardList = boardRepo.findByTitle("테스트 제목 10");
		
		System.out.println("검색 결과");
		for(Board board : boardList) {
			System.out.println("--->"+ board.toString());
		}
	}
	
//	@Test
	public void testByContentContaining() {
		List<Board> boardList = boardRepo.findByContentContaining("17");
		
		System.out.println("검색 결과");
		for(Board board : boardList) {
			System.out.println("--->"+ board.toString());
		}
	}
	
//	@Test
	public void testFindByTitleContainingOrContentContaining() {
		List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("수정","수정");
		
		System.out.println("검색 결과");
		for(Board board : boardList) {
			System.out.println("--->"+ board.toString());
		}
	}
	
//	@Test
	public void testFindByTitleContainingOrContentLikeContaining() {
		List<Board> boardList = boardRepo.findByTitleContainingOrContentLike("150","%17");
		
		System.out.println("검색 결과");
		for(Board board : boardList) {
			System.out.println("--->"+ board.toString());
		}
	}
	
//	@Test
	public void testFindByTitleContainingOrderBySeqDesc() {
		List<Board> boardList = boardRepo.findByTitleContainingOrderBySeqDesc("17");
		
		System.out.println("검색 결과");
		for(Board board : boardList) {
			System.out.println("--->"+ board.toString());
		}
	}
}
