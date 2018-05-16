package survey.vo;


public class User extends Person{
	private int user_num;								//����� ��ȣ (�⺻Ű)
	private int num;										//������ȣ (�ܷ�Ű)
	private String user_id;								//����� ID
	private String user_pwd;							//����� ��й�ȣ
	private int card;										//��� ����
	
	//private ArrayList<Object> list;					//���������� ������ ����
	
	
	public User() {
		super();
	}


	public User(int user_num, int num, String user_id, String user_pwd, int card) {
		super();
		this.user_num = user_num;
		this.num = num;
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.card = card;
	}


	public int getUser_num() {
		return user_num;
	}


	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUser_pwd() {
		return user_pwd;
	}


	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}


	public int getCard() {
		return card;
	}


	public void setCard(int card) {
		this.card = card;
	}


	@Override
	public String toString() {
		return "User [user_num=" + user_num + ", num=" + num + ", user_id=" + user_id + ", user_pwd=" + user_pwd
				+ ", card=" + card + "]";
	}



	
	
	
}
