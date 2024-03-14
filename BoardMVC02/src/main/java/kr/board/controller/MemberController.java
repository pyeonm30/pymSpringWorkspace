package kr.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.board.entity.Member;
import kr.board.mapper.MemberMapper;

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
	
	@GetMapping("/memLoginForm.do")
	public String loginForm() {
		return "member/memLoginForm";
	}
	
	// model 객체는 request 객체를 forward 할때만 값을 전달해준다 
	// RedirectAttributes => redirect: 할때 값을 들고 가고 새로고침하면 값이 사라진다 
	@PostMapping("/memLogin.do")
	public String memLogin( @ModelAttribute Member m , RedirectAttributes rttr , HttpSession session){
		
		System.out.println("memLogin m = " + m );
		if(m.getMemID() == null || m.getMemID().equals("")||
				m.getMemPassword() == null || m.getMemPassword().equals("")  ) {
			
			rttr.addFlashAttribute("msgType" ," 로그인 실패");
			rttr.addFlashAttribute("msg" ,"모든 값을 넣어주세요 ");
			
			return "redirect:/member/memLoginForm.do";
		}
		
		Member mvo = memberMapper.memLogin(m);
		if(mvo == null) {
			rttr.addFlashAttribute("msgType" ," 로그인 실패");
			rttr.addFlashAttribute("msg" ,"로그인 정보가 없습니다 ");
			
			return "redirect:/member/memLoginForm.do";
		}
		// 로그인 성공 
		session.setAttribute("mvo", mvo);
		rttr.addFlashAttribute("msgType" ,"성공 메세지");
		rttr.addFlashAttribute("msg" ,"로그인 성공 했습니다  ");
		
		return "redirect:/";
	}
	@GetMapping("/memLogout.do")
	public String logout(HttpSession session, RedirectAttributes rttr) {
		rttr.addFlashAttribute("msgType" ,"성공 메세지");
		rttr.addFlashAttribute("msg" ,"로그아웃 되었습니다  ");
		session.invalidate();
		return "redirect:/";
	
	}
	
	@GetMapping("/memJoin.do")
	public String memberJoin() {
		return "member/join";
	}
	
	@PostMapping("/memRegister.do") //@ModelAttribute        // @RequestParam(value="memPassword1")
	public String registerMember( Member m , String memPassword1 , String memPassword2, 
			RedirectAttributes rttr , HttpSession session 
			) {
		System.out.println("m = " + m );
		System.out.println(" === memRegister ===  ");
		if(!m.nullValueCheck()) {
			rttr.addFlashAttribute("msgType" ,"실패 메세지");
			rttr.addFlashAttribute("msg" ,"모든 값을 넣어주세요 ");
			return "redirect:/member/memJoin.do";
		}
		if(!memPassword1.equals(memPassword2)) {
			rttr.addFlashAttribute("msgType" ,"실패 메세지");
			rttr.addFlashAttribute("msg" ,"패스워드 값이 서로 다릅니다 ");
			return "redirect:/member/memJoin.do";
		}
		
		m.setMemPassword(memPassword1);
		m.setMemProfile(""); // 사진이 없다는 의미 
		
		int result = memberMapper.register(m);
		if(result == 1) {
			rttr.addFlashAttribute("msgType" ,"성공 메세지");
			rttr.addFlashAttribute("msg" ,"회원가입 성공했습니다 ");
			session.setAttribute("mvo", m);
			return "redirect:/";
		}else {
			rttr.addFlashAttribute("msgType" ,"실패 메세지");
			rttr.addFlashAttribute("msg" ," 회원가입 실패 다시시도해주세요 ");
			return "redirect:/member/memJoin.do";
		}

	}
	
	
	@GetMapping("/memRegisterCheck.do")
	public @ResponseBody int memRegisterCheck( String memID ) {
		System.out.println("memRegisterCheck memId = " + memID );
		Member member = memberMapper.registerCheck(memID);
		
		return member == null ? 1 : 0;
	}
	

}
