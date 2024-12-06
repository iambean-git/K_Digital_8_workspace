package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.service.BoardService;
import edu.pnu.service.MemberService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class BackEndWorkApplicationTests {

	@Autowired private MemberService memberService;
	@Autowired private BoardService boardService;
	
	@Test @Order(1) @DisplayName("MemberService Test")
	void test01() {
		List<Member> list = memberService.getMembers();
		list.forEach(m->System.out.println("--->" + m));
	}

	@Test @Order(1) @DisplayName("BoardService Test")
	void test02() {
		List<Board> list = boardService.getBoards();
		list.forEach(b->System.out.println("--->" + b));
	}
}
