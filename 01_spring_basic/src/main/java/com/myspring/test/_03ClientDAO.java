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
	

}
