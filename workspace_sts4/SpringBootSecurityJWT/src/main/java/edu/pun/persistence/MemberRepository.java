package edu.pun.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pun.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

}
