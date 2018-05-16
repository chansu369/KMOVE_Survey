package survey.vo;

public class Reply {
	private int reply_num;				//���� ��ȣ (�⺻Ű)
	private int board_num;			//�Խ��� ��ȣ (�ܷ�Ű)
	private String reply_name;		//���� ����
	private String reply_text;			//���� ����
	
	
	public Reply() {
		super();
	}


	public Reply(int reply_num, int board_num, String reply_name, String reply_text) {
		super();
		this.reply_num = reply_num;
		this.board_num = board_num;
		this.reply_name = reply_name;
		this.reply_text = reply_text;
	}


	public int getReply_num() {
		return reply_num;
	}


	public void setReply_num(int reply_num) {
		this.reply_num = reply_num;
	}
	
	public int getBoard_num() {
		return board_num;
	}


	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}



	public String getReply_name() {
		return reply_name;
	}


	public void setReply_name(String reply_name) {
		this.reply_name = reply_name;
	}


	public String getReply_text() {
		return reply_text;
	}


	public void setReply_text(String reply_text) {
		this.reply_text = reply_text;
	}


	@Override
	public String toString() {
		return "Reply [reply_num=" + reply_num + ", board_num=" + board_num + ", reply_name=" + reply_name
				+ ", reply_text=" + reply_text + "]";
	}
	
	
}
