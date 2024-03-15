package kr.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.board.entity.Member;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String home(Model model , HttpServletRequest request) {
		model.addAttribute("cp", request.getContextPath());
		return "index";  // /WEB-INF/views/ + index +".jsp
	}
	
	@GetMapping("/boardMain.do")
	public String main() {
		return "board/main"; 
	}
	
	
	
	// @ResponseBody 뷰리졸버가 실행하지 않고 순수 response 바디를 넘겨준다 
	@GetMapping("/test")
	public @ResponseBody String test() {
		return "<h1>test</h1>"; 
	}
	@GetMapping("/test2")
	public String test2() {
		return "test2";
	}
	
	
	//  @ResponseBody 리턴값이 자바 object 면 Jackson API 자동으로 JSON 형식으로 변환 
	// object -> databind -> json(브라우저가 인식할 수 있는 객체 데이터)  
	@GetMapping("/test3")
	public @ResponseBody Member test3() {
		Member m = new Member();
		m.setMemAge(10);
		return m; 
	}

}
