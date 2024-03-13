package kr.board.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.board.entity.Member;
import kr.board.mapper.MemberMapper;

// mvc2
@RequestMapping("/member")
@Controller
public class MemberController {
    
	@Autowired
	MemberMapper memberMapper;
	
	@ModelAttribute("cp")
	public String getContextPath(Model model , HttpServletRequest request) {		
		model.addAttribute("cp", request.getContextPath());	
		return request.getContextPath();
	}
	
	@GetMapping("/memJoin.do")
	public String memJoin() {
		return "member/join";  // join.jsp
	}
	
	@RequestMapping("/memRegisterCheck.do")
	public @ResponseBody int memRegisterCheck(@RequestParam("memID") String memID) {
		Member m=memberMapper.registerCheck(memID);
		if(m!=null || memID.equals("")) {
			return 0; //이미 존재하는 회원, 입력불가
		}
		return 1; //사용가능한 아이디
	}
	// 회원가입 처리
		@RequestMapping("/memRegister.do")
		public String memRegister(Member m, String memPassword1, String memPassword2,
				                  RedirectAttributes rttr, HttpSession session) {
			System.out.println("==== memRegister.do ====");
			if(m.nullValueCheck())
			 {
			   // 누락메세지를 가지고 가기? =>객체바인딩(Model, HttpServletRequest, HttpSession)
			   rttr.addFlashAttribute("msgType", "실패 메세지");
			   rttr.addFlashAttribute("msg", "모든 내용을 입력하세요.");
			   return "redirect:/member/memJoin.do";  // ${msgType} , ${msg}
			}
			if(!memPassword1.equals(memPassword2)) {
			   rttr.addFlashAttribute("msgType", "실패 메세지");
			   rttr.addFlashAttribute("msg", "비밀번호가 서로 다릅니다.");
			   return "redirect:/member/memJoin.do";  // ${msgType} , ${msg}
			}		
			m.setMemProfile(""); // 사진이미는 없다는 의미 ""
			// 회원을 테이블에 저장하기
			int result=memberMapper.register(m);
			if(result==1) { // 회원가입 성공 메세지
			   rttr.addFlashAttribute("msgType", "성공 메세지");
			   rttr.addFlashAttribute("msg", "회원가입에 성공했습니다.");
			   // 회원가입이 성공하면=>로그인처리하기
			   session.setAttribute("mvo", m); // ${!empty mvo}
			   return "redirect:/";
			}else {
			   rttr.addFlashAttribute("msgType", "실패 메세지");
			   rttr.addFlashAttribute("msg", "이미 존재하는 회원입니다.");
			   return "redirect:/member/memJoin.do";
			}		
		}
		// 로그아웃 처리
		@RequestMapping("/memLogout.do")
		public String memLogout(HttpSession session) {
			session.invalidate();
			return "redirect:/";
		}
		// 로그인 화면으로 이동
		@RequestMapping("/memLoginForm.do")
		public String memLoginForm() {
			return "member/memLoginForm"; // memLoginForm.jsp
		}
		// 로그인 기능 구현
		@RequestMapping("/memLogin.do")
		public String memLogin(Member m, RedirectAttributes rttr, HttpSession session) {
			if(m.getMemID()==null || m.getMemID().equals("") ||
			   m.getMemPassword()==null || m.getMemPassword().equals("")) {
			   rttr.addFlashAttribute("msgType", "실패 메세지");
			   rttr.addFlashAttribute("msg", "모든 내용을 입력해주세요.");
			   return "redirect:/memLoginForm.do";			
			}
			Member mvo=memberMapper.memLogin(m);
			if(mvo!=null) { // 로그인에 성공
			   rttr.addFlashAttribute("msgType", "성공 메세지");
			   rttr.addFlashAttribute("msg", "로그인에 성공했습니다.");
			   session.setAttribute("mvo", mvo); // ${!empty mvo}
			   return "redirect:/";	 // 메인		
			}else { // 로그인에 실패
			   rttr.addFlashAttribute("msgType", "실패 메세지");
			   rttr.addFlashAttribute("msg", "다시 로그인 해주세요.");
			   return "redirect:/member/memLoginForm.do";
			}		
		}
		// 회원정보수정화면
		@RequestMapping("/memUpdateForm.do")
		public String memUpdateForm() {
			return "member/memUpdateForm";
		}

		// 회원정보수정
		@RequestMapping("/memUpdate.do")
		public String memUpdate(Member m, RedirectAttributes rttr,
				String memPassword1, String memPassword2, HttpSession session) {
				// 실습 
			   return "redirect:/";
			
		}
}
