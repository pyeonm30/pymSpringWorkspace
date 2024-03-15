package kr.board.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kr.board.entity.Member;
import kr.board.entity.MemberUser;
import kr.board.mapper.MemberMapper;

//login.do 실행하면 오는 값 

public class MemberUserDetailsService implements UserDetailsService{

	@Autowired
	private MemberMapper memberMapper;
	
	// 로그인 처리를 시큐리티가 해줌 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member mvo = memberMapper.memLogin(username);
		if(mvo != null) {
			return new MemberUser(mvo);
		}else {
			throw new UsernameNotFoundException("유저 정보 : " + username +" 존재 안함");
		}
	}

}
