package com.rubypaper;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

//여러 테스트들을 순서에 맞게 실행시키고 싶을때
//@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	private BoardRepository boardRepo;
	
	@DisplayName("입력 테스트")
//	@Test
//	@Order(1)
	public void testInsertBoard() {
//		Board board = new Board();
//		board.setTitle("첫 번째 게시글");
//		board.setWriter("테스터");
//		board.setContent("잘 등록되나요?");
//		board.setCreateDate(new Date());
//		board.setCnt(0L);
//		boardRepo.save(board);	
		
		boardRepo.save(Board.builder()
							.title("제목입니다2")
							.writer("작성자2")
							.content("내용2")
							.createDate(new Date())
							.cnt(0L)
							.build()
				);
		
	}
	
	@DisplayName("조회 테스트")
//	@Test
//	@Order(2)
	public void testGetBoard() {
		Board board = boardRepo.findById(3L).get();
		System.out.println(board.toString());
	}
	
	@DisplayName("수정 테스트")
//	@Test
	public void testUpdateBoarD() {
		System.out.println("==1번 게시글 조회==");
		Board board = boardRepo.findById(1L).get();
		System.out.println("==게시글 제목 수정==");
		board.setTitle("제목수정");
		boardRepo.save(board);
	}
	
	@DisplayName("삭제 테스트")
//	@Test
	public void testDeleteBoard() {
		boardRepo.deleteById(1L);
	}
	

}
