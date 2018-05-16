package survey.ui;

import java.util.Scanner;

import survey.dao.SurveyDAO;
import survey.vo.Admin;
import survey.vo.Person;
import survey.vo.User;

public class SurveyUI {

	private SurveyDAO dao = new SurveyDAO(); 
	private Scanner scan = new Scanner(System.in);
	private UserUI uui;
	boolean mainflag =false;
	
	public static User user;


	//�޴�
	public void printMenu() {
		int code = 0;

		while(true) {
			printLoginMenu();

			code = getNextInt();

			switch(code) {
			case 1:
				insertMenu();
				break;
			case 2:
				loginMenu();
				if(mainflag) {
					return;
				}else {
					mainflag = false;
				}
				break;
			case 9:
				System.exit(0);
				break;
			default:
				System.out.println(" [����] �߸��Է��߽��ϴ�.");
				break;
			}
		}
	}
	
	
	//����ȭ�� �� �α��θ޴�
	//�ϼ�
	public void printLoginMenu() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("��K-MOVE Survey						 ��");
		System.out.println("����������������������������������������������������������������");
		System.out.println("����������������������������������������������������������������");
		System.out.println("��1.ȸ������                                                         ��");	
		System.out.println("��2.�α���	                                                            ��");	
		System.out.println("��9.���α׷� ����                                                  ��");	
		System.out.println("����������������������������������������������������������������");
		System.out.print(" �޴� ��ȣ�� �����ϼ���=> ");	
	}




	//ȸ������ ȭ��
	//��������׼� �Է� -> DB�� ����
	//�ϼ�
	public void insertMenu() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("�� 	����� ȸ������				 ��");
		System.out.println("����������������������������������������������������������������");
		System.out.println("=====================================");

		Person p = new Person();
		User u = new User();



		System.out.print("[ �̸� ] : ");
		String name = scan.next();
		System.out.print("[ ���� ] : ");
		int age = getNextInt();
		System.out.print("[ ��ȭ��ȣ ] : ");
		String phone = scan.next();
		System.out.print("[ �ּ� ] : ");
		String address = scan.next();


		p.setName(name);
		p.setAge(age);
		p.setPhone(phone);
		p.setAddress(address);
		dao.insertPerson(p);

		scan.nextLine();
		System.out.print("[ ID ] : ");
		String user_id = scan.next();
		System.out.print("[ ��й�ȣ ] : ");
		String user_pwd = scan.next();
		System.out.print("[ ��� ] (33 or 34): ");
		int card = getNextInt();

		u.setNum(p.getNum());
		u.setUser_id(user_id);
		u.setUser_pwd(user_pwd);
		u.setCard(card);

		boolean flag = dao.insertUser(u);


		if(flag) {
			System.out.println(" [�˸�] �Է� ����");
		}else {
			System.out.println(" [�˸�] �Է� ����");
		}

	}



	//�α��� ȭ��
	//�ϼ�
	public void loginMenu() {
		int code =0;

		System.out.println("����������������������������������������������������������������");
		System.out.println("�� 	�α���										 ��");
		System.out.println("����������������������������������������������������������������");
		System.out.println("����������������������������������������������������������������");
		System.out.println("��1.������	                                                         ��");	
		System.out.println("��2.�����			                                                   ��");	
		System.out.println("��9.�����޴�			                                                   ��");	
		System.out.println("����������������������������������������������������������������");
		System.out.print(" �޴� ��ȣ�� �����ϼ���=> ");	

		scan.nextLine();

		code = getNextInt();

		switch(code) {
		//������ �α���
		case 1:

			Admin find_ad = new Admin();
			System.out.print("[ ID �Է� ] : ");
			String admin_id = scan.next();
			System.out.print("[ ��й�ȣ �Է�] : ");
			String admin_pwd = scan.next(); 

			find_ad.setAdmin_id(admin_id);
			find_ad.setAdmin_pwd(admin_pwd);

			//select ���� ���� -> Admin���̺��� ���̵�� ��й�ȣ�� �޾ƿ´�
			find_ad = dao.loginAdmin(find_ad);

			if(find_ad == null) {
				System.out.println("[�˸�] ��ϵ� ������ ������ �����ϴ�.");
				mainflag = false;
			}else {
				System.out.println("[�˸�] �α��� ����");
				MultiThread mt1 = new MultiThread(" [�˸�] ������ thread ����");
				Thread tr1 = new Thread(mt1);
				tr1.start();
				mainflag = true;
			}
			break;

			//����� �α���
		case 2:
			User find_u = new User();
			System.out.print("[ ID �Է� ] : ");
			String user_id = scan.next();
			System.out.print("[ ��й�ȣ �Է� ] : ");
			String user_pwd = scan.next();

			find_u.setUser_id(user_id);
			find_u.setUser_pwd(user_pwd);

			//select ���� ���� -> userinfo���̺��� ���̵�� ��й�ȣ�� �޾ƿ´�
			user = new User();
			user = dao.loginUser(find_u);

			if(user == null) {
				System.out.println("[�˸�] ��ϵ� ����� ������ �����ϴ�.");
			}else {
				System.out.println("[�˸�] �α��� ����");
				//find_u�� user_num�� �Լ��� �̿��Ͽ� UserUI�� �Ѱܾ��ؿ�
				uui = new UserUI();
				uui.printMenu();
				return;
			}
			break;

			//�����޴�
		case 9:
			return;
		default:
			System.out.println("[�˸�] �߸��Է��߽��ϴ�.");
			break;

		}
	}


	public User getUser() {
		return SurveyUI.user;
	}



	//���� �Է±�
	public int getNextInt() {
		int option = 0;

		do {
			try {
				option = scan.nextInt();
			} catch (Exception e) {
				System.out.println("[����] �߸� �Է��Ͽ����ϴ�");
				scan.nextLine();
			}
		} while(option == 0);

		return option;
	}




}
