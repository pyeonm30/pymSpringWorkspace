package kr.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;
//@Controller --> 리턴을 뷰리졸버로 넘김 
@RequestMapping("/api")
@RestController    // 리턴값을 @ResponseBody 넘겨줌 
public class BoardController {

	@Autowired
	BoardMapper boardMapper;
	
	@GetMapping("/boards")
	public List<Board> boardList(){
		List<Board> list = boardMapper.getLists();
		return list;
	}
	
	                           // json 요청을 줄때는 @RequestBody 넣어야함!! 
	@PostMapping("/boards")   //  Board 객체 --> @ModelAttribute(기본으로 적용되기때문에 )
	public String addBoard(@RequestBody Board board) {
		String msg =board.toString();
		int result = boardMapper.boardInsert(board);
		
		return (result == 1 ? "게시글 추가 완료" : "게시글 추가 실패" ) + msg;
	}
	
}
