package com.mysql.basic.controller;

import java.net.http.HttpRequest;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysql.basic.entity.Member;
import com.mysql.basic.repository.MemberDAO;

@Controller
public class MemberController {
	
	@Autowired
	MemberDAO memberDAO;
	
	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
	
	@RequestMapping(value="/member/userMenu" , method = RequestMethod.GET)
	public String userMenu() {
		return "/member/userMenu";
	}
	
	@GetMapping("/member/list")
	public String list(Model model ) {
		ArrayList<Member> memberList = memberDAO.getMemberList();
		
		model.addAttribute("memberList", memberList);
		return "/member/list";
	}


}
