package dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class In_OutDTO {


	private int seq;
	private String writer;
	private String contents;
	private Timestamp write_date;
	
	public In_OutDTO() {
		super();
	}
	public In_OutDTO(int seq, String writer, String contents, Timestamp write_date) {
		this.seq = seq;
		this.writer = writer;
		this.contents = contents;
		this.write_date = write_date;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
	public String getFormedDate() {
		
		long writeTime = this.write_date.getTime();
		long currentTime = System.currentTimeMillis();
		
		long timeGap = (currentTime - writeTime)/1000;
		
		// 단위는 초
		if(timeGap < 60) {
			return "1분 이내";
		}else if(timeGap < 300) {
			return "5분 이내";
		}else if(timeGap < 3600) {
			return "1시간 이내";
		}else if(timeGap < 86400) {
			return "24시간 이내";
		}else {
			SimpleDateFormat sdf = new SimpleDateFormat("MM월dd일 hh시mm분");
			return sdf.format(write_date);
		}
		
		
		
		
	}
	
	
	
}
