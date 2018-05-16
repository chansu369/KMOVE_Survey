package survey.vo;

public class Q_sheet {
	private int q_code;						//설문지 코드
	private String q_type;					//설문지 타입(33기or34기)
	private int q_num;						//문항 번호
	private String q_text;					//문항
	private int a_type;						//답안 형식 (2,3,4,5,, 지 선다)
	
	
	
	public Q_sheet() {
		super();
	}
	public Q_sheet(int q_code, String q_type, int q_num, String q_text, int a_type) {
		super();
		this.q_code = q_code;
		this.q_type = q_type;
		this.q_num = q_num;
		this.q_text = q_text;
		this.a_type = a_type;
	}
	public int getQ_code() {
		return q_code;
	}
	public void setQ_code(int q_code) {
		this.q_code = q_code;
	}
	public String getQ_type() {
		return q_type;
	}
	public void setQ_type(String q_type) {
		this.q_type = q_type;
	}
	public int getQ_num() {
		return q_num;
	}
	public void setQ_num(int q_num) {
		this.q_num = q_num;
	}
	public String getQ_text() {
		return q_text;
	}
	public void setQ_text(String q_text) {
		this.q_text = q_text;
	}
	public int getA_type() {
		return a_type;
	}
	public void setA_type(int a_type) {
		this.a_type = a_type;
	}
	
	
	@Override
	public String toString() {
		return "Q_sheet [q_code=" + q_code + ", q_type=" + q_type + ", q_num=" + q_num + ", q_text=" + q_text
				+ ", a_type=" + a_type + "]";
	}
	
	

	
}
