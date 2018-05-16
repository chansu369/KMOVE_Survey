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


	//메뉴
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
				System.out.println(" [에러] 잘못입력했습니다.");
				break;
			}
		}
	}
	
	
	//시작화면 및 로그인메뉴
	//완성
	public void printLoginMenu() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│K-MOVE Survey						 │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│1.회원가입                                                         │");	
		System.out.println("│2.로그인	                                                            │");	
		System.out.println("│9.프로그램 종료                                                  │");	
		System.out.println("└──────────────────────────────┘");
		System.out.print(" 메뉴 번호를 선택하세요=> ");	
	}




	//회원가입 화면
	//사용자한테서 입력 -> DB에 저장
	//완성
	public void insertMenu() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ 	사용자 회원가입				 │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("=====================================");

		Person p = new Person();
		User u = new User();



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
		String user_id = scan.next();
		System.out.print("[ 비밀번호 ] : ");
		String user_pwd = scan.next();
		System.out.print("[ 기수 ] (33 or 34): ");
		int card = getNextInt();

		u.setNum(p.getNum());
		u.setUser_id(user_id);
		u.setUser_pwd(user_pwd);
		u.setCard(card);

		boolean flag = dao.insertUser(u);


		if(flag) {
			System.out.println(" [알림] 입력 성공");
		}else {
			System.out.println(" [알림] 입력 실패");
		}

	}



	//로그인 화면
	//완성
	public void loginMenu() {
		int code =0;

		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ 	로그인										 │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│1.관리자	                                                         │");	
		System.out.println("│2.사용자			                                                   │");	
		System.out.println("│9.상위메뉴			                                                   │");	
		System.out.println("└──────────────────────────────┘");
		System.out.print(" 메뉴 번호를 선택하세요=> ");	

		scan.nextLine();

		code = getNextInt();

		switch(code) {
		//관리자 로그인
		case 1:

			Admin find_ad = new Admin();
			System.out.print("[ ID 입력 ] : ");
			String admin_id = scan.next();
			System.out.print("[ 비밀번호 입력] : ");
			String admin_pwd = scan.next(); 

			find_ad.setAdmin_id(admin_id);
			find_ad.setAdmin_pwd(admin_pwd);

			//select 쿼리 실행 -> Admin테이블에서 아이디와 비밀번호를 받아온다
			find_ad = dao.loginAdmin(find_ad);

			if(find_ad == null) {
				System.out.println("[알림] 등록된 관리자 정보가 없습니다.");
				mainflag = false;
			}else {
				System.out.println("[알림] 로그인 성공");
				MultiThread mt1 = new MultiThread(" [알림] 관리자 thread 실행");
				Thread tr1 = new Thread(mt1);
				tr1.start();
				mainflag = true;
			}
			break;

			//사용자 로그인
		case 2:
			User find_u = new User();
			System.out.print("[ ID 입력 ] : ");
			String user_id = scan.next();
			System.out.print("[ 비밀번호 입력 ] : ");
			String user_pwd = scan.next();

			find_u.setUser_id(user_id);
			find_u.setUser_pwd(user_pwd);

			//select 쿼리 실행 -> userinfo테이블에서 아이디와 비밀번호를 받아온다
			user = new User();
			user = dao.loginUser(find_u);

			if(user == null) {
				System.out.println("[알림] 등록된 사용자 정보가 없습니다.");
			}else {
				System.out.println("[알림] 로그인 성공");
				//find_u의 user_num을 함수를 이용하여 UserUI에 넘겨야해요
				uui = new UserUI();
				uui.printMenu();
				return;
			}
			break;

			//상위메뉴
		case 9:
			return;
		default:
			System.out.println("[알림] 잘못입력했습니다.");
			break;

		}
	}


	public User getUser() {
		return SurveyUI.user;
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
