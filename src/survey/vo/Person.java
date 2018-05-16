package survey.vo;

public class Person {
	private int num;					//고유 번호(기본키)
	private String name;			//이름
	private int age;					//나이
	private String phone;			//전화번호
	private String address;			//주소
	
	
	public Person() {
		super();
	}


	public Person(int num, String name, int age, String phone, String address) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}

	
	

	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Person [num=" + num + ", name=" + name + ", age=" + age + ", phone=" + phone + ", address=" + address
				+ "]";
	}
	
	
	
	
	
	
	
	
	
}
