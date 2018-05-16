package survey.vo;

public class Board {
	private int board_num;					//글 번호
	private String board_title;					//글 제목
	private String board_content;			//글 내용
	private String board_name;				//작성자
	private String board_date;				//작성일
	private int board_hit;						//조회수
	
	
	
	public Board() {
		super();
	}



	public Board(int board_num, String board_title, String board_content, String board_name, String board_date,
			int board_hit) {
		super();
		this.board_num = board_num;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_name = board_name;
		this.board_date = board_date;
		this.board_hit = board_hit;
	}



	public int getBoard_num() {
		return board_num;
	}



	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}



	public String getBoard_title() {
		return board_title;
	}



	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}



	public String getBoard_content() {
		return board_content;
	}



	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}



	public String getBoard_name() {
		return board_name;
	}



	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}



	public String getBoard_date() {
		return board_date;
	}



	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}



	public int getBoard_hit() {
		return board_hit;
	}



	public void setBoard_hit(int board_hit) {
		this.board_hit = board_hit;
	}



	@Override
	public String toString() {
		return "Board [board_num=" + board_num + ", board_title=" + board_title + ", board_content=" + board_content
				+ ", board_name=" + board_name + ", board_date=" + board_date + ", board_hit=" + board_hit + "]";
	}
	
	
}
