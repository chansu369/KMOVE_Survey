package survey.ui;

import java.util.Scanner;

import survey.dao.SVManager;
import survey.dao.SurveyDAO;
import survey.vo.Admin;
import survey.vo.Person;

public class AdminUI {
	private SurveyDAO dao = new SurveyDAO(); 
	private Scanner scan = new Scanner(System.in);
	private AdminSV asv;
	private SurveyUI sui;
	private SVManager svm;

	synchronized void printMenu() {
		int code = 0;
		while(true) {

			//�����ڸ޴�
			adminMain();

			

			code = getNextInt();

			switch(code) {
				//�����޴�
			case 1:
				asv = new AdminSV();
				asv.printMenu();
				return;
				//�Խ�������
			case 2:
				new BoardUI();
				break;
				//�������
			case 3:
				outFile();
				break;
				//������ ȸ������
			case 4:
				insertAdmin();
				break;
				//�����޴�
			case 9:
				sui = new SurveyUI();
				sui.printMenu();
				return;
			default:
				System.out.println(" [����] �߸��Է��߽��ϴ�.");
				break;
			}



		}


	}


	//������ �޴�
	//�ϼ�
	
	synchronized void adminMain() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("�� 	������ Menu							 ��");
		System.out.println("����������������������������������������������������������������");
		System.out.println("����������������������������������������������������������������");
		System.out.println("��1. ���� �޴� ����                                                     ��");	
		System.out.println("��2. �Խ��� ����                                                     ��");	
		System.out.println("��3. ���䳻�� �������                                           ��");	
		System.out.println("��4. ������ ȸ������                                                        ��");	
		System.out.println("��9. ���� �޴�                                                        ��");	
		System.out.println("����������������������������������������������������������������");
		System.out.print(" �޴� ��ȣ�� �����ϼ���=> ");


	}


	

	//���䳻�� �������
	synchronized void outFile() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("�� 	���䳻�� �������				 ��");
		System.out.println("����������������������������������������������������������������");

		//���Ͽ� ����� �÷� �޾ƿ���
		System.out.print("���Ϸ� ����� ����� ��ȣ �Է� : ");
		int user_num = getNextInt();
		svm = new SVManager();
		svm.list = dao.selectFile(user_num);
		
		//���� ���
		try {
			svm.setFile();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(" [����] ���� ��� ����");
		}
		System.out.println(" [�˸�] ���� ��� ����");
	}

	
	//������ ȸ������
	//�ϼ�
	synchronized void insertAdmin() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("�� 	������ ȸ������				 ��");
		System.out.println("����������������������������������������������������������������");
		System.out.println("=====================================");
		
		Person p = new Person();
		Admin ad = new Admin();
		
		
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
		String admin_id = scan.next();
		System.out.print("[ ��й�ȣ ] : ");
		String admin_pwd = scan.next();
		
		ad.setNum(p.getNum());
		ad.setAdmin_id(admin_id);
		ad.setAdmin_pwd(admin_pwd);
		
		boolean flag = dao.insertAdmin(ad);
		
		
		if(flag) {
			System.out.println("�Է� ����");
		}else {
			System.out.println("�Է� ����");
		}
		
		
		
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
