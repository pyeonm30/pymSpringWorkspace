package kr.board.entity;

import lombok.Data;

//@Data //- Lombok API
public class Board {
  private int idx; //
  private String title; // 
  private String content; // 
  private String writer; // 
  private String indate; // 
  private int count; 
  // setter , getter
public int getIdx() {
	return idx;
}
public void setIdx(int idx) {
	this.idx = idx;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getWriter() {
	return writer;
}
public void setWriter(String writer) {
	this.writer = writer;
}
public String getIndate() {
	return indate;
}
public void setIndate(String indate) {
	this.indate = indate;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
  
  
}
