package survey.ui;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import survey.dao.SurveyDAO;

import survey.vo.Board;
import survey.vo.Reply;


public class BoardUI {
	private Scanner scan = new Scanner(System.in);
	private SurveyDAO dao = new SurveyDAO();

	public BoardUI() {
		//���θ޴� ��� �Լ� ȣ��
		while(true) {
			printMainMenu();

			
			//�޴���ȣ�� �Է¹޴´�.
			int no = 0;
			try {
				no = scan.nextInt();
			}catch(Exception e) {
				System.out.println(" [����] ���ڸ� �Է��� �ּ���.");
				scan.nextLine();
			}
			//�Է¹��� �޴���ȣ�� ���� ó��
			switch(no) {
			//�۾���
			case 1:
				//����Լ� ȣ��
				insertBoard();
				break;
			case 2:
				//��ü����Լ� ȣ��
				selectAll();
				break;
			case 3:
				selectNum();
				break;
			case 4:
				//�� �����Լ� ȣ��
				deleteBoard();
				break;
			case 5:
				selectSearch();
				break;
			case 6:
				selectTop();
			case 9:
				System.out.println(" [�˸�] �Խ����� �����ϴ�.");
				return;
			default :
				System.out.println(" [����] ��ȣ�� �ٽ� �����ϼ���.");
				break;
			}
		}

	}


	public void printMainMenu() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("�� 	�Խ��� ����										 ��");
		System.out.println("����������������������������������������������������������������");
		System.out.println("����������������������������������������������������������������");
		System.out.println("��1. �� ����                                                        ��");	
		System.out.println("��2. �� ��ü ���                                                        ��");	
		System.out.println("��3. �� �б�                                                        ��");	
		System.out.println("��4. �� ����                                                        ��");	
		System.out.println("��5. �� �˻�                                                     ��");	
		System.out.println("��6. ���� ��ȸ�� �� ���                                           ��");	
		System.out.println("��9. ���� �޴�                                                        ��");	
		System.out.println("����������������������������������������������������������������");
		System.out.print(" �޴� ��ȣ�� �����ϼ���=> ");
		
	}

	//��� �Լ�
	public void insertBoard() {
		//����, ����, �ۼ���
		String title,content,name;
		Board board;


		System.out.println(" [ �۾��� ]");
		scan.nextLine();
		System.out.print("�̸� : ");
		name = scan.nextLine();
		System.out.print("���� : ");
		title = scan.nextLine();
		System.out.print("���� : ");
		content = scan.nextLine();

		board = new Board();
		board.setBoard_name(name);
		board.setBoard_title(title);
		board.setBoard_content(content);

		boolean flag = dao.insertBoard(board);

		if(flag) {
			System.out.println(" [�˸�] ��� �Ϸ�");
		}else {
			System.out.println(" [�˸�] ��� ����");
		}


	}

	//��ü ���
	public void selectAll() {
		System.out.println("[ �� ��� ]");
		ArrayList<Board> list = dao.selectAll();

		if(list == null || list.size() == 0) {
			System.out.println(" [�˸�] ��ϵ� ���� �����ϴ�.");
		}

		for(Board b : list) {
			System.out.print("��ȣ :" +b.getBoard_num()+"\t");
			System.out.print("���� :" +b.getBoard_title()+"\t");
			System.out.print("�ۼ��� :" +b.getBoard_name()+"\t");
			System.out.println("�ۼ��� :" +b.getBoard_date()+"\t");
		}
		
		
	}
	
	//���� ��ȸ���� �������� �������� ���
	public void selectTop() {
		System.out.println("[ ���� ��ȸ�� ��� ]");
		ArrayList<Board> list = dao.selectAll();

		if(list == null || list.size() == 0) {
			System.out.println(" [�˸�] ��ϵ� ���� �����ϴ�.");
		}

		for(Board b : list) {
			System.out.print("��ȣ :" +b.getBoard_num()+"\t");
			System.out.print("���� :" +b.getBoard_title()+"\t");
			System.out.print("�ۼ��� :" +b.getBoard_name()+"\t");
			System.out.println("��ȸ�� :" +b.getBoard_hit()+"\t");
		}
	}
	

	//�� ����
	public void deleteBoard() {
		int no = 0;
		System.out.print("������ ���� ��ȣ �Է� > ");
		try {
			no = scan.nextInt();
		}catch(Exception e) {
			System.out.println(" [����] ���ڸ� �Է��ϼ���.");
			scan.nextLine();
		}

		boolean flag = dao.deleteBoard(no);

		if(flag) {
			System.out.println(" [�˸�] ���� �Ϸ�");
		}else {
			System.out.println(" [�˸�] ���� ����");
		}

	}

	//���� ��ȣ�� �� ���� ���
	public void selectNum() {
		int no = 0;

		System.out.println("[ �� �б� ]");
		System.out.print("* ���� ���� ��ȣ > ");
		try {
			no = scan.nextInt();
		}catch(Exception e) {
			System.out.println(" [����] ���ڷ� �Է��ϼ���.");
			scan.nextLine();
		}
		Board b = dao.selectNum(no);

		if(b == null) {
			System.out.println("�ش� ��ȣ�� ���� �����ϴ�.");
			return;
		}else {
			System.out.print("��ȣ :" +b.getBoard_num()+"\t");
			System.out.print("���� :" +b.getBoard_title()+"\t");
			System.out.print("���� :" +b.getBoard_content()+"\t");
			System.out.print("�ۼ��� :" +b.getBoard_name()+"\t");
			System.out.print("�ۼ��� :" +b.getBoard_date()+"\t");
			System.out.println("��ȸ�� :" +b.getBoard_hit()+"\t");

			//�ش� ���� ���� ���
			System.out.println();

			//�ش� ���� ���� ��� �޴�
			System.out.print("1. ���� �ޱ�  0.���θ޴��� >");
			int num = 0;

			try {
				num = scan.nextInt();
			}catch(Exception e) {
				scan.nextLine();
			}

			if(num != 1) {
				return;
			}

			//���� �ޱ� �Լ� ȣ��
			insertReply(no);
		}
	}



	//�� �˻�
	public void selectSearch() {
		int col = 0;					//�˻�����
		String text = null;		//�˻���


		System.out.println("[ �� �˻� ]");
		try {
			System.out.print("* �˻� ��� : 1.���� 2.���� 3.�ۼ��� > ");
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

		ArrayList<Board> list = dao.selectSearch(map);

		if(list == null || list.size() == 0) {
			System.out.println(" [�˸�] �˻��� ���� �����ϴ�.");
		}

		for(Board b : list) {
			System.out.print("��ȣ :" +b.getBoard_num()+"\t");
			System.out.print("���� :" +b.getBoard_title()+"\t");
			System.out.print("�ۼ��� :" +b.getBoard_name()+"\t");
			System.out.println("�ۼ��� :" +b.getBoard_date()+"\t");
		}	
	}




	//���� �ޱ� �Լ�
	public void insertReply(int board_num) {
		String reply_name,reply_text;
		Reply reply;

		System.out.println("==== ���� ���� ====");
		scan.nextLine();
		System.out.print("�̸� : ");
		reply_name = scan.nextLine();
		System.out.print("���� : ");
		reply_text = scan.nextLine();

		reply = new Reply();
		reply.setBoard_num(board_num);
		reply.setReply_name(reply_name);
		reply.setReply_text(reply_text);

		boolean flag = dao.insertReply(reply);

		if(flag) {
			System.out.println(" [�˸�] ���� ��� ����");
		}else {
			System.out.println(" [�˸�] ���� ��� ����");
		}


	}

}
