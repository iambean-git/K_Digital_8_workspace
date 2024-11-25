package com.rubypaper;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.Member;
import com.rubypaper.persistence.BoardRepository;
import com.rubypaper.persistence.MemberRepository;


@SpringBootTest
public class RelationMappingTest {
	
	@Autowired
	private BoardRepository boardRepo;
	@Autowired
	private MemberRepository memberRepo;
	
//	@Test
	public void testManyToOneInsert() {
		
		Member member1 = Member.builder()
								.id("member1")
								.password("member111")
								.name("둘리")
								.role("User")
								.build();
		Member member2 = Member.builder()
								.id("member2")
								.password("member222")
								.name("도우너")
								.role("Admin")
								.build();
		
		memberRepo.save(member1);
		memberRepo.save(member2);
		
		for(int i=1; i<=3; i++) {
			boardRepo.save(Board.builder()
								.title("둘리가 등록한 게시글 " + i)
								.content("둘리가 등록한 게시글 내용 " + i)
								.createDate(new Date())
								.cnt(0L)
								.member(member1)
								.build()
			);
		}
		
		for(int i=1; i<=3; i++) {
			boardRepo.save(Board.builder()
								.title("도우너가 등록한 게시글 " + i)
								.content("둘리가 등록한 게시글 내용 " + i)
								.createDate(new Date())
								.cnt(0L)
								.member(member2)
								.build()
			);
		}
		
	}
	
//	@Test
	public void testTwoWayMapping() {
		Member member = memberRepo.findById("member1").get();
		System.out.println("===========================");
		System.out.println(member.getName()+"가(이) 저장한 게시글 목록");
		System.out.println("===========================");
		List<Board> list = member.getBoardList();
		
		for(Board board : list) {
			System.out.println(board.toString());
		}
	}
	
	@Test
	public void testMantToOneInsert() {
		Member member1 = Member.builder()
								.id("member1")
								.password("member111")
								.name("둘리")
								.role("User")
								.build();
		Member member2 = Member.builder()
								.id("member2")
								.password("member222")
								.name("도우너")
								.role("Admin")
								.build();
		
		for(int i=1; i<=3; i++) {
			Board board = new Board();
			board.setMember(member1);
			board.setTitle("둘리가 등록한 게시글 " + i);
			board.setContent("둘리가 등록한 게시글 내용 " + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
		}
		memberRepo.save(member1);
		
		for(int i=1; i<=3; i++) {
			Board board = new Board();
			board.setMember(member2);
			board.setTitle("도우너가 등록한 게시글 " + i);
			board.setContent("도우너가 등록한 게시글 내용 " + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
		}
		
		memberRepo.save(member2);
	}
}
