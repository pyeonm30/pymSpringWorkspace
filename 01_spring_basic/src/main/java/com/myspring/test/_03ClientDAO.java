package com.myspring.test;

import java.util.ArrayList;
import java.util.HashMap;

public class _03ClientDAO {
	
	private String schoolName;
	private ArrayList<String> clientList;
	
	private HashMap<String, String> clientMap1;
	private HashMap<String, _03Client> clientMap2;
	
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public ArrayList<String> getClientList() {
		return clientList;
	}
	public void setClientList(ArrayList<String> clientList) {
		this.clientList = clientList;
	}
	public HashMap<String, String> getClientMap1() {
		return clientMap1;
	}
	public void setClientMap1(HashMap<String, String> clientMap1) {
		this.clientMap1 = clientMap1;
	}
	public HashMap<String, _03Client> getClientMap2() {
		return clientMap2;
	}
	public void setClientMap2(HashMap<String, _03Client> clientMap2) {
		this.clientMap2 = clientMap2;
	}
	

}
