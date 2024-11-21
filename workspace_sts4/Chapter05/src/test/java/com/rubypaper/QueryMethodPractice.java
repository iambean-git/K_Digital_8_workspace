package com.rubypaper;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@SpringBootTest
public class QueryMethodPractice {
	
	@Autowired
	private BoardRepository boardRepo;
	
//	@BeforeEach
	public void dataPrepare() {
		for(int i=1; i<=100; i++) {
			Random rnd = new Random();
			Long cnt = rnd.nextLong(101L);
			boardRepo.save(Board.builder()
								.title("테스트 제목 " + i)
								.writer("테스트 작성자 " + i)
								.content("테스트 내용 " + i)
								.createDate(new Date())
								.cnt(cnt)
								.build()
								);
		}
	}
	
	@Test
	public void practice02(){
		//title에 “1” 이 포함되는 데이터 출력
		List<Board> boardList = boardRepo.findByTitleContaining("10");
		
		System.out.println("[결과 출력] title에 “1” 이 포함되는 데이터 출력");
		for(Board board : boardList) {
			System.out.println("--->"+ board.toString());
		}
	}
}
