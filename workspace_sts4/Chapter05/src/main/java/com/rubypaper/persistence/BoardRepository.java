package com.rubypaper.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rubypaper.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	
	List<Board> findByTitle(String searchKeyword);
	List<Board> findByContentContaining(String searchKeyword);
	List<Board> findByTitleContaining(String searchKeyword);
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	List<Board> findByTitleContainingOrContentLike(String title, String content);
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	List<Board> findByTitleContainingAndCntGreaterThan(String title, Long num);
	List<Board> findByCntGreaterThanEqualAndCntLessThanEqualOrderBySeq(Long num1, Long num2);
	List<Board> findByTitleContainingOrContentContainingOrderBySeqDesc(String title, String content);
	
	Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	
//	@Query("SELECT b FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
//	List<Board> queryAnnotationTest1(String searchkeyword);
	
	@Query("SELECT b FROM Board b WHERE b.title like %:searchKeyword% ORDER BY b.seq desc")
	List<Board> queryAnnotationTest1(String searchKeyword);
	
	@Query("select b.seq, b.title, b.writer, b.createDate "
			+ "from Board b "
			+ "where b.title like %?1% "
			+ "order by b.seq desc")
	List<Object[]> queryAnnotationTest2(String searchKeyword);
}
