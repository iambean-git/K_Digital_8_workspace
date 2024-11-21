package com.rubypaper.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	private final BoardRepository boardRepo;
	
	@GetMapping("/board")
	public List<Board> getBoards(){
		return boardRepo.findAll();
	}
	
	@GetMapping("/board/{seq}")
	public Board getBoard(@PathVariable Long seq) {
			return boardRepo.findById(seq).orElse(null);
	}
	
	@PostMapping("/board")
	public Board postBoard(Board board) {
		board.setCnt(0L);
		board.setCreateDate(new Date());
		return boardRepo.save(board);
	}
	
	@PutMapping("/board")
	public Board putBoard(Board board) {
		try {
			Board before = boardRepo.findById(board.getSeq()).get();
			
			if(board.getTitle() != null)
				before.setTitle(board.getTitle());
			if(board.getContent() != null)
				before.setContent(board.getContent());
			
			return boardRepo.save(before);
			
		} catch (Exception e) {
			System.out.println("[수정] 해당 id는 존재하지 않습니다");
			return null;
		}
	}
	
	@DeleteMapping("board/{seq}")
	public Board deleteBoard(@PathVariable Long seq) {
		try {
			Board deleted = boardRepo.findById(seq).get();
			boardRepo.deleteById(seq);
			return deleted;
		} catch (Exception e) {
			System.out.println("[삭제] 해당 id는 존재하지 않습니다");
			return null;
		}
	}
}
