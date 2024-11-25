package edu.pnu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Log;
import edu.pnu.domain.Member;
import edu.pnu.persistence.LogRepository;
import edu.pnu.persistence.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	MemberRepository memberRepo;
	
	@Autowired
	LogRepository logRepo;
	
	public List<Member> getAllMembers() {
		List<Member> memberList = memberRepo.findAll();
		logRepo.save(Log.builder()
						.method("get")
						.sqlQuery("findAll")
						.regidate(new Date())
						.success((memberList==null)? false : true)
						.build());
		
		return memberList;
	}
	
	public Member getMemberByID(Integer id) {
		Member mem = memberRepo.findById(id).orElse(null);
		logRepo.save(Log.builder()
				.method("get")
				.sqlQuery("findById:"+id)
				.regidate(new Date())
				.success((mem==null)? false : true)
				.build());
		return mem;
	}

	public Member postMember(Member mem) {
		mem.setRegiDate(new Date());
		Member newMem = memberRepo.save(mem);
		logRepo.save(Log.builder()
						.method("post")
						.sqlQuery("save")
						.regidate(new Date())
						.success((newMem==null)? false : true)
						.build()
				);
		return newMem;
	}
	
	public Member putMember(Member mem) {
		Member before = null;
		
		//id를 입력하지 않아 오류 발생할 경우
		if(mem.getId()==null) {
			System.out.println("[수정] id값이 없습니다(null)");
			
			logRepo.save(Log.builder()
					.method("put")
					.sqlQuery("save[수정] : id is null")
					.regidate(new Date())
					.success(false)
					.build()
			);
			
			return null;
		}
		
		before = memberRepo.findById(mem.getId()).orElse(null);
		if(before!=null) {
			if(mem.getName() != null)
				before.setName(mem.getName());
			if(mem.getPass() != null)
				before.setPass(mem.getPass());
		} else {
			System.out.println("[수정] 해당 id는 존재하지 않습니다");
			
		}
		
		logRepo.save(Log.builder()
				.method("put")
				.sqlQuery("save[수정]")
				.regidate(new Date())
				.success((before==null)? false : true)
				.build()
		);
		return before;
	}
	
	public Member deleteMember(Integer id) {
		Member deleted = memberRepo.findById(id).orElse(null);
		if(deleted!=null) {
			memberRepo.deleteById(id);
		} else {
			System.out.println("[삭제] 해당 id는 존재하지 않습니다");
		}
		
		logRepo.save(Log.builder()
				.method("delete")
				.sqlQuery("delete : " + id)
				.regidate(new Date())
				.success((deleted==null)? false : true)
				.build()
		);
		return deleted;
	}
}
