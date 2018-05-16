package survey.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import survey.dao.SurveyDAO;
import survey.vo.Answer;
import survey.vo.Choice;
import survey.vo.Q_sheet;
import survey.vo.User;

public class UserUI {

	private Scanner scan = new Scanner(System.in);
	private SurveyDAO dao = new SurveyDAO();
	private SurveyUI sui;
	private AdminSV asv = new AdminSV();

	public void printMenu(){

		int code = 0;

		while(true) {
			//����� �޴�
			userMain();



			code = getNextInt();

			switch(code) {
			//���� ����
			case 1:
				startSurvey();
				break;
				//���� ��ȸ
			case 2:
				selectSurvey();
				break;
				//���� ����
			case 3:
				updateSurvey();
				break;
				//�Խ��� ����
			case 4:
				new BoardUI();
				break;
				//ȸ������ ��ȸ
			case 5:
				selectUser();
				break;
				//ȸ������ ����
			case 6:
				updateUser();
				break;
				//ȸ��Ż��
			case 7:
				deleteUser();
				return;
			case 9:
				sui = new SurveyUI();
				sui.printMenu();
				break;
			default:
				System.out.println(" [����] �߸��Է��߽��ϴ�.");
				break;
			}



		}
	}

	//����� �޴�
	public void userMain() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("�� 	����� Menu						 ��");
		System.out.println("����������������������������������������������������������������");
		System.out.println("����������������������������������������������������������������");
		System.out.println("��1. ���� ����                                                        ��");	
		System.out.println("��2. ���� ��ȸ                                                        ��");	
		System.out.println("��3. ���� ����                                                        ��");	
		System.out.println("��4. �Խ��� ����                                                     ��");	
		System.out.println("��5. ȸ�� ���� ��ȸ                                                     ��");	
		System.out.println("��6. ȸ�� ���� ����                                                    ��");	
		System.out.println("��7. ȸ�� Ż��                                                    ��");	
		System.out.println("��9. �α� �ƿ�                                                     ��");	
		System.out.println("����������������������������������������������������������������");
		System.out.print(" �޴� ��ȣ�� �����ϼ���=> ");


	}


	//���� ����
	public void startSurvey() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("�� 	Survey							 ��");
		System.out.println("����������������������������������������������������������������");

		int count1,count2,count3;
		//����� ���� �޾ƿ���
		User l_user = new User();
		l_user = SurveyUI.user;

		//����� ������ �ٸ��� ���
		if(l_user.getCard() == 34) {
			System.out.println("����������������������������������������������������������������");
			System.out.println("�� 	34�� ������							 ��");
			System.out.println("����������������������������������������������������������������");


			ArrayList<Q_sheet> list = dao.selectQsheet();
			ArrayList<Choice> chlist = dao.selectChoice();

			count1 = 1;
			for(Q_sheet q : list) {
				System.out.println(+ q.getQ_num()+"��. " + q.getQ_text());

				for(Choice c : chlist) {
					if(c.getQ_num() == count1) {
						System.out.println(c.getChoice_num()+". " + c.getAnswer_text());
					}
				}
				System.out.print(" [��� �Է�] :  ");
				int an = getNextInt();
				System.out.println("\t");

				//��� ���
				Answer answer = new Answer();
				answer.setQ_code(count1);
				answer.setAnswer_num(an);
				answer.setUser_num(l_user.getUser_num());

				boolean flag = dao.insertAnswer(answer);

				if(flag) {
					count1++;
				}else {
					System.out.println(" [�˸�] ��ȵ�Ͻ���");
					return;
				}
				scan.nextLine();
			}

			//33��
		}else if (l_user.getCard() == 33) {
			System.out.println("����������������������������������������������������������������");
			System.out.println("�� 	33�� ������							 ��");
			System.out.println("����������������������������������������������������������������");

			ArrayList<Q_sheet> list = dao.selectQsheets();
			ArrayList<Choice> chlist = dao.selectChoices();

			count2 = 31;
			count3 = 100;
			for(Q_sheet q : list) {
				System.out.println(+ q.getQ_num()+"��. " + q.getQ_text());

				for(Choice c : chlist) {
					if(c.getQ_num() == count3) {
						System.out.println(c.getChoice_num()+". " + c.getAnswer_text());
					}
				}
				System.out.print(" [��� �Է�] :  ");
				int an = getNextInt();
				Answer answer = new Answer();
				answer.setQ_code(count2);
				answer.setAnswer_num(an);
				answer.setUser_num(l_user.getUser_num());

				boolean flag = dao.insertAnswer(answer);

				if(flag) {
					count2++;
					count3++;
				}else {
					System.out.println(" [�˸�] ��ȵ�Ͻ���");
					return;
				}
				scan.nextLine();
			}
			System.out.println(" [�˸�] ��ȵ�ϼ���");
		}else {
			System.out.println(" [�˸�] ������� �߸� �Է�");
			return;
		}
		
		System.out.println(" [�˸�] ��ȵ�ϼ���");

	}



	//���� ��ȸ

	public void selectSurvey() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("�� 	���� ��ȸ							 ��");
		System.out.println("����������������������������������������������������������������");

		//�α��� ����� ��ü �޾ƿ���
		User l_user = new User();
		l_user = SurveyUI.user;

		Answer answer = new Answer();
		answer.setUser_num(l_user.getUser_num());

		HashMap<String,Object> map = new HashMap<>();
		map.put("user_num", answer.getUser_num());
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		list.add(map);
		list = dao.getChoice(map);

		for(HashMap<String,Object> map2 : list) {
			System.out.println(map2);

		}

	}


	//���� ����
	public void updateSurvey() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("�� 	���� ����							 ��");
		System.out.println("����������������������������������������������������������������");

		Answer an = new Answer();
		//������ȸ
		asv.selectSurvey();

		System.out.println("===============================================\t");

		//����ڹ�ȣ�� ������ȣ �ʿ�
		System.out.print("������ ������ ���� ��ȣ �Է� (34�� : 1 ~ 99 // 33�� : 100 ~ 200) : ");
		int q_num = getNextInt();

		System.out.print("������ �����ȣ �Է� : ");
		int answer_num = getNextInt();

		an.setQ_code(q_num);
		an.setAnswer_num(answer_num);
		an.setUser_num(SurveyUI.user.getUser_num());

		boolean flag = dao.updateAnswer(an);

		if(flag) {
			System.out.println(" [�˸�] ���� ���� ����");
		}else {
			System.out.println(" [�˸�] ���� ���� ����");
		}
	}


	//ȸ������ ��ȸ
	//�ϼ�
	public void selectUser() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("�� 	ȸ������ ��ȸ							 ��");
		System.out.println("����������������������������������������������������������������");


		int col = 0;					//�˻�����
		String text = null;		//�˻���


		try {
			System.out.print("* �˻� ��� : 1.�̸� 2.����� ID  > ");
			col = scan.nextInt();
			System.out.print("* �˻��� > ");
			scan.nextLine();
			text = scan.nextLine();
		}catch(Exception e) {
			System.out.println(" [����] �߸� �Է��ϼ̽��ϴ�.");
			scan.nextLine();
			return;
		}

		HashMap<String, Object> map = new HashMap<>();
		map.put("col", col);
		map.put("text", text);

		ArrayList<User> list = dao.selectUser(map);

		if(list == null || list.size() == 0) {
			System.out.println(" [�˸�] �˻��� ���� �����ϴ�.");
		}

		for(User u : list) {
			System.out.println("���� ȸ�� ��ȣ : "+ u.getNum());
			System.out.println("����� ��ȣ : "+ u.getUser_num());
			System.out.println("�̸� : "+ u.getName());
			System.out.println("���� : "+ u.getAge());
			System.out.println("��ȭ ��ȣ : "+ u.getPhone());
			System.out.println("�ּ� : "+ u.getAddress());
			System.out.println("����� ID : "+ u.getUser_id());
			System.out.println("��� ���� : "+ u.getCard());
		}	
	}

	//ȸ����������
	//�ϼ�
	public void updateUser() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("�� 	ȸ������ ����							 ��");
		System.out.println("����������������������������������������������������������������");

		User update_u = new User();
		System.out.print("[ ���� ȸ�� ��ȣ �Է� ] : ");
		int num = getNextInt();

		scan.nextLine();
		System.out.print("[ ������ ID ] : ");
		String user_id = scan.next();
		System.out.print("[ ������ ��й�ȣ ] : ");
		String user_pwd = scan.next();
		System.out.print("[ ��� ] (33 or 34): ");
		int card = getNextInt();


		update_u.setNum(num);
		update_u.setUser_id(user_id);
		update_u.setUser_pwd(user_pwd);
		update_u.setCard(card);


		boolean flag = dao.updateUser(update_u);

		if(flag) {
			System.out.println(" [�˸�] ������Ʈ ����");
		}else {
			System.out.println(" [�˸�] ������Ʈ ����");
		}



	}


	//ȸ��Ż��
	//�ϼ�

	public void deleteUser() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("�� 	ȸ��Ż��							 ��");
		System.out.println("����������������������������������������������������������������");


		int num = SurveyUI.user.getNum();

		System.out.print(" [�˸�] ���� Ż���Ͻðڽ��ϱ�? (y/n)  : ");
		String delete_answer = scan.nextLine();
		
		if(delete_answer.toLowerCase().equals("y")) { 

			boolean flag = dao.deleteUser(num);

			if(flag) {
				System.out.println(" [�˸�] Ż�� �Ϸ�Ǿ����ϴ�.");
			}else {
				System.out.println(" [�˸�] Ż�� �����߽��ϴ�.");
			}

		}else if(delete_answer.toLowerCase().equals("n")) {
			return;
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
