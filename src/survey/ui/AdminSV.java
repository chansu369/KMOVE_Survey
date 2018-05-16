package survey.ui;

import java.util.ArrayList;
import java.util.Scanner;

import survey.dao.SurveyDAO;
import survey.vo.Choice;
import survey.vo.Q_sheet;

public class AdminSV {
	private Scanner scan = new Scanner(System.in);
	private AdminUI aui;
	private SurveyDAO dao = new SurveyDAO();

	synchronized  void printMenu() {
		while(true) {

			int code = 0;


			System.out.println("����������������������������������������������������������������");
			System.out.println("�� 	������ ���� Menu							 ��");
			System.out.println("����������������������������������������������������������������");
			System.out.println("��1. ���� �߰�                                                        ��");	
			System.out.println("��2. ���� ��ȸ                                                        ��");	
			System.out.println("��3. ���� ����                                                        ��");	
			System.out.println("��4. ���� ����                                                        ��");	
			System.out.println("��9. ���� �޴�                                                        ��");	
			System.out.println("����������������������������������������������������������������");
			System.out.print(" �޴� ��ȣ�� �����ϼ���=> ");

			code = getNextInt();

			switch(code) {

			case 1:
				addSurvey();
				break;
				//������ȸ
			case 2:
				selectSurvey();
				break;
				//��������
			case 3:
				updateSurvey();
				break;
				//��������
			case 4:
				deleteSurvey();
				break;
			case 9:
				aui = new AdminUI();
				aui.printMenu();
				return;
			default:
				System.out.println(" [����] �߸��Է��߽��ϴ�.");
				break;	

			}

		}



	}



	//���� �߰�
	synchronized void addSurvey() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("�� 	���� �߰�							 ��");
		System.out.println("����������������������������������������������������������������");

		Q_sheet sheet = new Q_sheet();
		Choice choice = new Choice();

		System.out.println("===������ ���� �Է�===");
		System.out.print("[������ Ÿ��] (33�� or 34��) : ");
		String q_type = scan.nextLine();
		System.out.print("[���� ��ȣ] (34�� : 1 ~ 99 // 33�� : 100 ~ 200) : ");
		int q_num = getNextInt();
		System.out.print("[����] : ");
		String q_text = scan.nextLine();
		System.out.print("[�������] (2,3,4,5,,,) : ");
		int a_type = getNextInt();

		sheet.setQ_type(q_type);
		sheet.setQ_num(q_num);
		sheet.setQ_text(q_text);
		sheet.setA_type(a_type);

		boolean flag1 =dao.insertQsheet(sheet);

		scan.nextLine();

		boolean flag2 = false;

		for(int i = 1;i<=a_type;i++) {
			System.out.println("===����� ���� �Է�===");
			System.out.print("[��� ����] (33�� or 34��): ");
			String card = scan.nextLine();
			System.out.print("[��� �ؽ�Ʈ] : ");
			String answer_text = scan.nextLine();

			choice.setQ_num(sheet.getQ_num());
			choice.setCard(card);
			choice.setChoice_num(i);
			choice.setAnswer_text(answer_text);

			flag2 = dao.insertChoice(choice);
		}
		
		if(flag1 == true) {
			System.out.println(" [�˸�] ������ϼ���");
		}else {
			System.out.println(" [�˸�] ������Ͻ��� (���� ��ȣ �ߺ�)");
		}
		
		if(flag2 == true) {
			System.out.println(" [�˸�] ��ȵ�ϼ���");
		}else {
			System.out.println(" [�˸�] ��ȵ�Ͻ��� (��� ��ȣ �ߺ�)");
		}
		
	}


	//���� ��ȸ
	synchronized void selectSurvey() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("�� 	���� ��ȸ							 ��");
		System.out.println("����������������������������������������������������������������");

		ArrayList<Q_sheet> list34 = dao.selectQsheet();
		ArrayList<Choice> chlist34 = dao.selectChoice();

		ArrayList<Q_sheet> list33 = dao.selectQsheets();
		ArrayList<Choice> chlist33 = dao.selectChoices();

		int count = 1;
		int count2 = 100;

		//34�� ������ȸ
		System.out.println("����������������������������������������������������������������");
		System.out.println("�� 	34�� ������ȸ							 ��");
		System.out.println("����������������������������������������������������������������");

		for(Q_sheet qs34 : list34) {
			System.out.println(+ qs34.getQ_num()+"��. " + qs34.getQ_text());

			for(Choice c34 : chlist34) {
				if(c34.getQ_num() == count) {
					System.out.println(c34.getChoice_num()+". " + c34.getAnswer_text());
				}
			}	
			count++;
		}
		
		//33�� ������ȸ
		System.out.println("����������������������������������������������������������������");
		System.out.println("�� 33�� ������ȸ							 ��");
		System.out.println("����������������������������������������������������������������");

		for(Q_sheet qs33 : list33) {
			System.out.println(+ qs33.getQ_num()+"��. " + qs33.getQ_text());

			for(Choice c33 : chlist33) {
				if(c33.getQ_num() == count2) {
					System.out.println(c33.getChoice_num()+". " + c33.getAnswer_text());
				}
			}	
			count2++;
		}



	}

	//���� ����
	synchronized void updateSurvey() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("�� 	���� ����							 ��");
		System.out.println("����������������������������������������������������������������");

		scan.nextLine();
		
		Q_sheet sheet = new Q_sheet();
		System.out.println("===������ ����===");
		System.out.print("[������ ���� ��ȣ] : ");
		int q_num = getNextInt();
		sheet.setQ_num(q_num);

		scan.nextLine();
		System.out.print("[������ Ÿ��] : ");
		String q_type = scan.nextLine();
		System.out.print("[����] : ");
		String q_text = scan.nextLine();
		System.out.print("[�������] (2,3,4,5,,,) : ");
		int a_type = getNextInt();

		sheet.setQ_type(q_type);
		sheet.setQ_text(q_text);
		sheet.setA_type(a_type);

		boolean flag1 =dao.updateQsheet(sheet);
		
		if(flag1) {
			System.out.println(" [�˸�] ���� ���� ����");
		}else {
			System.out.println(" [�˸�] ���� ���� ����");
		}
	}


	//���� ����
	synchronized void deleteSurvey() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("�� 	���� ����								 ��");
		System.out.println("����������������������������������������������������������������");

		System.out.print("[������ ���� ��ȣ] : ");
		int q_num = getNextInt();
		
		boolean flag1 = dao.deleteQsheet(q_num);
		boolean flag2 = dao.deleteChoice(q_num);

		
		if(flag1 == true && flag2 == true) {
			System.out.println(" [�˸�] ���� ���� ����");
		}else {
			System.out.println(" [�˸�] ���� ���� ����");
		}
		scan.nextLine();
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
