package kr.board.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Member {
	  private int memIdx; 
	  private String memID;  
	  private String memPassword;
	  private String memName;
	  private int memAge; // <-null, 0
	  private String memGender;
	  private String memEmail;
	  private String memProfile; //사진정보
	  
	  public boolean nullValueCheck() {
		  if(memID == null || memID.equals("") ) return false;
		  if(memName == null || memName.equals("") ) return false;
		  if(memAge  < 1 || memAge > 100 ) return false;
		  if(memGender == null || memGender.equals("") ) return false;
		  if(memEmail == null || memEmail.equals("") ) return false;
		  return true;
	  }
}
