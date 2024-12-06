package edu.pnu;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;

//@Component
@RequiredArgsConstructor
public class DataSetup implements ApplicationRunner {

	private final MemberRepository memberRepo; 
	private final BoardRepository boardRepo; 
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Member m1 = Member.builder()
							.username("user")
							.password("abcd")
							.alias("홍길동")
							.enabled(true)
							.build();
		memberRepo.save(m1);
		Member m2 = Member.builder()
							.username("manager")
							.password("abcd")
							.alias("홍이동")
							.enabled(true)
							.build();
		memberRepo.save(m2);
		
		for (int i = 1 ; i <= 10 ; i++) {
			boardRepo.save(Board.builder()
				.title("title" + i)
				.content("content" + i)
				.member((i%2)==1?m1:m2)
				.build()
			);
		}		
	}
}
