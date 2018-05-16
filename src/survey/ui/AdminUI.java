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

			//관리자메뉴
			adminMain();

			

			code = getNextInt();

			switch(code) {
				//설문메뉴
			case 1:
				asv = new AdminSV();
				asv.printMenu();
				return;
				//게시판입장
			case 2:
				new BoardUI();
				break;
				//파일출력
			case 3:
				outFile();
				break;
				//관리자 회원가입
			case 4:
				insertAdmin();
				break;
				//상위메뉴
			case 9:
				sui = new SurveyUI();
				sui.printMenu();
				return;
			default:
				System.out.println(" [에러] 잘못입력했습니다.");
				break;
			}



		}


	}


	//관리자 메뉴
	//완성
	
	synchronized void adminMain() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ 	관리자 Menu							 │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│1. 설문 메뉴 입장                                                     │");	
		System.out.println("│2. 게시판 입장                                                     │");	
		System.out.println("│3. 응답내용 파일출력                                           │");	
		System.out.println("│4. 관리자 회원가입                                                        │");	
		System.out.println("│9. 상위 메뉴                                                        │");	
		System.out.println("└──────────────────────────────┘");
		System.out.print(" 메뉴 번호를 선택하세요=> ");


	}


	

	//응답내용 파일출력
	synchronized void outFile() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ 	응답내용 파일출력				 │");
		System.out.println("└──────────────────────────────┘");

		//파일에 출력할 컬럼 받아오기
		System.out.print("파일로 출력할 사용자 번호 입력 : ");
		int user_num = getNextInt();
		svm = new SVManager();
		svm.list = dao.selectFile(user_num);
		
		//파일 출력
		try {
			svm.setFile();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(" [에러] 파일 출력 실패");
		}
		System.out.println(" [알림] 파일 출력 성공");
	}

	
	//관리자 회원가입
	//완성
	synchronized void insertAdmin() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ 	관리자 회원가입				 │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("=====================================");
		
		Person p = new Person();
		Admin ad = new Admin();
		
		
		System.out.print("[ 이름 ] : ");
		String name = scan.next();
		System.out.print("[ 나이 ] : ");
		int age = getNextInt();
		System.out.print("[ 전화번호 ] : ");
		String phone = scan.next();
		System.out.print("[ 주소 ] : ");
		String address = scan.next();
		

		p.setName(name);
		p.setAge(age);
		p.setPhone(phone);
		p.setAddress(address);
		dao.insertPerson(p);
		
		scan.nextLine();
		System.out.print("[ ID ] : ");
		String admin_id = scan.next();
		System.out.print("[ 비밀번호 ] : ");
		String admin_pwd = scan.next();
		
		ad.setNum(p.getNum());
		ad.setAdmin_id(admin_id);
		ad.setAdmin_pwd(admin_pwd);
		
		boolean flag = dao.insertAdmin(ad);
		
		
		if(flag) {
			System.out.println("입력 성공");
		}else {
			System.out.println("입력 실패");
		}
		
		
		
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
