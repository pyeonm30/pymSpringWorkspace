package kr.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BoardController{	
	
	@RequestMapping("/boardMain.do")
	public String main() {
		return "board/main"; 
	}
	
}
