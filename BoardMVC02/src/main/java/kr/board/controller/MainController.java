package kr.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String home(Model model , HttpServletRequest request) {
		model.addAttribute("cp", request.getContextPath());
		return "index";  // /WEB-INF/views/ + index +".jsp
	}

}
