package kr.board.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //- Lombok API
@AllArgsConstructor
@NoArgsConstructor
public class Board {
//  public Board(int idx, String title, String content, String writer, String indate, int count) {
//		super();
//		this.idx = idx;
//		this.title = title;
//		this.content = content;
//		this.writer = writer;
//		this.indate = indate;
//		this.count = count;
//	}
private int idx; //
  private String title; // 
  private String content; // 
  private String writer; // 
  private String indate; // 
  private int count; 
  // setter , getter

  
  
}
