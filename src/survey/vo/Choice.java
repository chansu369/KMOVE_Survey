package survey.vo;

public class Choice {
	private int answer_num;				//사용자 선택 번호
	private int q_num;						//문항 번호
	private String card;						//기수 정보
	private int choice_num;				//답안 번호
	private String answer_text;			//답안 text
	
	
	public Choice() {
		super();
	}
	public Choice(int answer_num, int q_num, String card, int choice_num, String answer_text) {
		super();
		this.answer_num = answer_num;
		this.q_num = q_num;
		this.card = card;
		this.choice_num = choice_num;
		this.answer_text = answer_text;
	}
	
	
	public int getAnswer_num() {
		return answer_num;
	}
	public void setAnswer_num(int answer_num) {
		this.answer_num = answer_num;
	}
	public int getQ_num() {
		return q_num;
	}
	public void setQ_num(int q_num) {
		this.q_num = q_num;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public int getChoice_num() {
		return choice_num;
	}
	public void setChoice_num(int choice_num) {
		this.choice_num = choice_num;
	}
	public String getAnswer_text() {
		return answer_text;
	}
	public void setAnswer_text(String answer_text) {
		this.answer_text = answer_text;
	}
	
	@Override
	public String toString() {
		return "Choice [answer_num=" + answer_num + ", q_num=" + q_num + ", card=" + card + ", choice_num=" + choice_num
				+ ", answer_text=" + answer_text + "]";
	}
	
	
	
	
}
