package com.mysql.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	// get, post, put , delete 모든 값들이 허용가능하다 
	@RequestMapping(value="/member/userMenu" , method = RequestMethod.GET)
	public String userMenu() {
		return "/member/userMenu";
	}
//	@GetMapping("/member/userMenu/")
//	public String list() {
//		return "/member/userMenu";
//	}


}
