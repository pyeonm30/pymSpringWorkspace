package com.mysql.basic.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.basic.entity.Member;

@Repository
public class MemberDAO {
	
	@Autowired
	DataSource dataSource;
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void finallyClose() {
		try {
			if (pstmt != null) { pstmt.close();}
			if (conn != null) { conn.close(); }
			if (rs != null) { rs.close(); }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//ctrl + shfit	+ o => 자동 import 여러개 
	
	public ArrayList<Member> getMemberList(){
		ArrayList<Member> memberList = new ArrayList<Member>();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT * FROM member ORDER BY num ASC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member member = new Member();
				member.setNum(rs.getInt(1));
				member.setId(rs.getString(2));
				member.setPw(rs.getString(3));
				member.setEmail(rs.getString(4));
				
				memberList.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyClose();
		}
		
		return memberList;
	}
	
	
	public void joinMember(Member member) {
		try {
			conn = dataSource.getConnection();
			
			String sql = "INSERT INTO member (id, pw, email) VALUES(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getEmail());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyClose();
		}
	}
	
	public int checkMember(Member member) {
		int check = -1;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT * FROM member WHERE id=? AND pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			finallyClose();			
		}
		
		return check;
	}

	public Member getOneMember(String id) {
		Member member = new Member();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT * FROM member WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setNum(rs.getInt(1));
				member.setId(rs.getString(2));
				member.setPw(rs.getString(3));
				member.setEmail(rs.getString(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			finallyClose();			
		}
		
		return member;
	}
	
}
