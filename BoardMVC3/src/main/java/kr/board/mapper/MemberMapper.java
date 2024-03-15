package kr.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.board.entity.Member;

@Mapper
public interface MemberMapper {

	public Member memLogin(Member member);
	public Member registerCheck(String memID);
	public int register(Member member);
	public int memUpdate(Member member);
	public Member getMember(String memID);
	public int memProfileUpdate(Member member);
	
	
}
