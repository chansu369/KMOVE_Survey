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


			System.out.println("┌──────────────────────────────┐");
			System.out.println("│ 	관리자 설문 Menu							 │");
			System.out.println("└──────────────────────────────┘");
			System.out.println("│1. 설문 추가                                                        │");	
			System.out.println("│2. 설문 조회                                                        │");	
			System.out.println("│3. 설문 수정                                                        │");	
			System.out.println("│4. 설문 삭제                                                        │");	
			System.out.println("│9. 상위 메뉴                                                        │");	
			System.out.println("└──────────────────────────────┘");
			System.out.print(" 메뉴 번호를 선택하세요=> ");

			code = getNextInt();

			switch(code) {

			case 1:
				addSurvey();
				break;
				//설문조회
			case 2:
				selectSurvey();
				break;
				//설문수정
			case 3:
				updateSurvey();
				break;
				//설문삭제
			case 4:
				deleteSurvey();
				break;
			case 9:
				aui = new AdminUI();
				aui.printMenu();
				return;
			default:
				System.out.println(" [에러] 잘못입력했습니다.");
				break;	

			}

		}



	}



	//설문 추가
	synchronized void addSurvey() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ 	설문 추가							 │");
		System.out.println("└──────────────────────────────┘");

		Q_sheet sheet = new Q_sheet();
		Choice choice = new Choice();

		System.out.println("===설문지 정보 입력===");
		System.out.print("[설문지 타입] (33기 or 34기) : ");
		String q_type = scan.nextLine();
		System.out.print("[문항 번호] (34기 : 1 ~ 99 // 33기 : 100 ~ 200) : ");
		int q_num = getNextInt();
		System.out.print("[문항] : ");
		String q_text = scan.nextLine();
		System.out.print("[답안형식] (2,3,4,5,,,) : ");
		int a_type = getNextInt();

		sheet.setQ_type(q_type);
		sheet.setQ_num(q_num);
		sheet.setQ_text(q_text);
		sheet.setA_type(a_type);

		boolean flag1 =dao.insertQsheet(sheet);

		scan.nextLine();

		boolean flag2 = false;

		for(int i = 1;i<=a_type;i++) {
			System.out.println("===답안지 정보 입력===");
			System.out.print("[기수 정보] (33기 or 34기): ");
			String card = scan.nextLine();
			System.out.print("[답안 텍스트] : ");
			String answer_text = scan.nextLine();

			choice.setQ_num(sheet.getQ_num());
			choice.setCard(card);
			choice.setChoice_num(i);
			choice.setAnswer_text(answer_text);

			flag2 = dao.insertChoice(choice);
		}
		
		if(flag1 == true) {
			System.out.println(" [알림] 설문등록성공");
		}else {
			System.out.println(" [알림] 설문등록실패 (문항 번호 중복)");
		}
		
		if(flag2 == true) {
			System.out.println(" [알림] 답안등록성공");
		}else {
			System.out.println(" [알림] 답안등록실패 (답안 번호 중복)");
		}
		
	}


	//설문 조회
	synchronized void selectSurvey() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ 	설문 조회							 │");
		System.out.println("└──────────────────────────────┘");

		ArrayList<Q_sheet> list34 = dao.selectQsheet();
		ArrayList<Choice> chlist34 = dao.selectChoice();

		ArrayList<Q_sheet> list33 = dao.selectQsheets();
		ArrayList<Choice> chlist33 = dao.selectChoices();

		int count = 1;
		int count2 = 100;

		//34기 설문조회
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ 	34기 설문조회							 │");
		System.out.println("└──────────────────────────────┘");

		for(Q_sheet qs34 : list34) {
			System.out.println(+ qs34.getQ_num()+"번. " + qs34.getQ_text());

			for(Choice c34 : chlist34) {
				if(c34.getQ_num() == count) {
					System.out.println(c34.getChoice_num()+". " + c34.getAnswer_text());
				}
			}	
			count++;
		}
		
		//33기 설문조회
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ 33기 설문조회							 │");
		System.out.println("└──────────────────────────────┘");

		for(Q_sheet qs33 : list33) {
			System.out.println(+ qs33.getQ_num()+"번. " + qs33.getQ_text());

			for(Choice c33 : chlist33) {
				if(c33.getQ_num() == count2) {
					System.out.println(c33.getChoice_num()+". " + c33.getAnswer_text());
				}
			}	
			count2++;
		}



	}

	//설문 수정
	synchronized void updateSurvey() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ 	설문 수정							 │");
		System.out.println("└──────────────────────────────┘");

		scan.nextLine();
		
		Q_sheet sheet = new Q_sheet();
		System.out.println("===설문지 수정===");
		System.out.print("[수정할 문항 번호] : ");
		int q_num = getNextInt();
		sheet.setQ_num(q_num);

		scan.nextLine();
		System.out.print("[설문지 타입] : ");
		String q_type = scan.nextLine();
		System.out.print("[문항] : ");
		String q_text = scan.nextLine();
		System.out.print("[답안형식] (2,3,4,5,,,) : ");
		int a_type = getNextInt();

		sheet.setQ_type(q_type);
		sheet.setQ_text(q_text);
		sheet.setA_type(a_type);

		boolean flag1 =dao.updateQsheet(sheet);
		
		if(flag1) {
			System.out.println(" [알림] 설문 수정 성공");
		}else {
			System.out.println(" [알림] 설문 수정 실패");
		}
	}


	//설문 삭제
	synchronized void deleteSurvey() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ 	설문 삭제								 │");
		System.out.println("└──────────────────────────────┘");

		System.out.print("[수정할 문항 번호] : ");
		int q_num = getNextInt();
		
		boolean flag1 = dao.deleteQsheet(q_num);
		boolean flag2 = dao.deleteChoice(q_num);

		
		if(flag1 == true && flag2 == true) {
			System.out.println(" [알림] 설문 삭제 성공");
		}else {
			System.out.println(" [알림] 설문 삭제 실패");
		}
		scan.nextLine();
	}



	//정수 입력기
	public int getNextInt() {
		int option = 0;

		do {
			try {
				option = scan.nextInt();
			} catch (Exception e) {
				System.out.println("[에러] 잘못 입력하였습니다");
				scan.nextLine();
			}
		} while(option == 0);

		return option;
	}

}
