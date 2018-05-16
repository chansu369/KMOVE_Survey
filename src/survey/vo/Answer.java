package survey.vo;

import java.io.Serializable;

public class Answer implements Serializable {
	private int reply_number;				//������ ��ȣ
	private int q_code;						//������ �ڵ�
	private int answer_num;				//����� ���� ��ȣ
	private int user_num;					//����� ��ȣ
	
	
	
	public Answer() {
		super();
	}
	public Answer(int reply_number, int q_code, int answer_num, int user_num) {
		super();
		this.reply_number = reply_number;
		this.q_code = q_code;
		this.answer_num = answer_num;
		this.user_num = user_num;
	}
	public int getReply_number() {
		return reply_number;
	}
	public void setReply_number(int reply_number) {
		this.reply_number = reply_number;
	}
	public int getQ_code() {
		return q_code;
	}
	public void setQ_code(int q_code) {
		this.q_code = q_code;
	}
	public int getAnswer_num() {
		return answer_num;
	}
	public void setAnswer_num(int answer_num) {
		this.answer_num = answer_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	
	@Override
	public String toString() {
		return "Answer [reply_number=" + reply_number + ", q_code=" + q_code + ", answer_num=" + answer_num
				+ ", user_num=" + user_num + "]";
	}
	
	
	
	
	
	
	
}
