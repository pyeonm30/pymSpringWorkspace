package kr.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class MainController {
	@GetMapping("/")
	public String index(Model model , HttpServletRequest request) {
		model.addAttribute("cp", request.getContextPath());	
		return "index";
	}
	@GetMapping("/home")
	public String home() {
		return "common/template";
	}
	@GetMapping("/boardMain.do")
	public String main() {
		return "board/main"; 
	}
	
	
}







