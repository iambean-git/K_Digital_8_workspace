package com.rubypaper.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rubypaper.board.domain.Board;
import com.rubypaper.board.domain.Search;
import com.rubypaper.board.security.SecurityUser;
import com.rubypaper.board.service.BoardService;


@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/getBoardList", method = {RequestMethod.GET, RequestMethod.POST})
	public String getBoardList(Model model, Search search) {
		if(search.getSearchCondition() == null)
			search.setSearchCondition("TITLE");
		if(search.getSearchKeyword()==null)
			search.setSearchKeyword("");
		
		Page<Board> boardList = boardService.getBoardList(search);
		model.addAttribute("boardList", boardList);
		return "board/getBoardList";
	}
//	public String getBoardList(Model model, Board board) {
//		Page<Board> boardList = boardService.getBoardList(board);
//		model.addAttribute("boardList", boardList);
//		return "board/getBoardList";
//	}
	
	@GetMapping("/getBoard")
	public String GetBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		return "board/getBoard";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoardView(){
		return "board/insertBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(Board board, @AuthenticationPrincipal SecurityUser principal) {
		board.setMember(principal.getMember());
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
	
}