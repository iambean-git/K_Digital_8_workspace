package com.rubypaper.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubypaper.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	
	List<Board> findByTitle(String searchKeyword);
	List<Board> findByContentContaining(String searchKeyword);
	List<Board> findByTitleContaining(String searchKeyword);
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	List<Board> findByTitleContainingOrContentLike(String title, String content);
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
}
