package com.myspring.test;

public class _02UserDAO {

	private _02User user;
	
	// 생성자 주입 
	public _02UserDAO(_02User user) {
		this.user = user;
	}
	
	public void print() {
		user.print();
	}
	
}
