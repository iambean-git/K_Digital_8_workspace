package com.rubypaper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rubypaper.board.domain.Board;
import com.rubypaper.board.domain.Member;
import com.rubypaper.board.domain.Role;
import com.rubypaper.board.persistence.BoardRepository;
import com.rubypaper.board.persistence.MemberRepository;

@SpringBootTest
public class BoardRepositoryTest {
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Test
	public void testInsert() {
		Member member1 = Member.builder()
								.id("member")
								.password(encoder.encode("member123"))
								.name("둘리")
								.role(Role.ROLE_MEMBER)
								.enabled(true)
								.build();
		
		Member member2 = Member.builder()
				.id("admin")
				.password(encoder.encode("admin123"))
				.name("도우너")
				.role(Role.ROLE_ADMIN)
				.enabled(true)
				.build();
		
		memberRepo.save(member1);
		memberRepo.save(member2);
		
		for(int i=1; i<=13; i++) {
			boardRepo.save(Board.builder()
								.member(member1)
								.title(member1.getName()+ "가 등록한 게시글 "+i)
								.content(member1.getName()+"가 등록한 게시글 내용 " + i)
								.build());
		}
		for(int i=1; i<=13; i++) {
			boardRepo.save(Board.builder()
					.member(member2)
					.title(member2.getName()+ "가 등록한 게시글 "+i)
					.content(member2.getName()+"가 등록한 게시글 내용 " + i)
					.build());
		}
	}
	
//	@Test
	public void testGetBoarD() {
		Board board = boardRepo.findById(1L).get();
		
		System.out.println(board.toString());
	}
	
//	@Test
	public void testGetBoardList() {
		Member member = memberRepo.findById("member").get();
		System.out.println("[ "+ member.getName() + "가 등록한 게시글 ]");
		for(Board board : member.getBoardList()) {
			System.out.println("---> " + board.toString());
		}
	}
}
