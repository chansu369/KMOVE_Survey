package survey.vo;

public class Admin extends Person{
	private int admin_num;				//관리자번호 (기본키)
	private int num;							//고유번호 (외래키)
	private String admin_id;				//관리자 ID
	private String admin_pwd;			//관리자 비밀번호
	
	
	
	public Admin() {
		super();
	}



	public Admin(int admin_num, int num, String admin_id, String admin_pwd) {
		super();
		this.admin_num = admin_num;
		this.num = num;
		this.admin_id = admin_id;
		this.admin_pwd = admin_pwd;
	}



	public int getAdmin_num() {
		return admin_num;
	}



	public void setAdmin_num(int admin_num) {
		this.admin_num = admin_num;
	}



	public int getNum() {
		return num;
	}



	public void setNum(int num) {
		this.num = num;
	}



	public String getAdmin_id() {
		return admin_id;
	}



	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}



	public String getAdmin_pwd() {
		return admin_pwd;
	}



	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}



	@Override
	public String toString() {
		return "Admin [admin_num=" + admin_num + ", num=" + num + ", admin_id=" + admin_id + ", admin_pwd=" + admin_pwd
				+ "]";
	}


	
}
