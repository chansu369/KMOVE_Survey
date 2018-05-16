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
		//메인메뉴 출력 함수 호출
		while(true) {
			printMainMenu();

			
			//메뉴번호를 입력받는다.
			int no = 0;
			try {
				no = scan.nextInt();
			}catch(Exception e) {
				System.out.println(" [에러] 숫자를 입력해 주세요.");
				scan.nextLine();
			}
			//입력받은 메뉴번호에 따라서 처리
			switch(no) {
			//글쓰기
			case 1:
				//등록함수 호출
				insertBoard();
				break;
			case 2:
				//전체출력함수 호출
				selectAll();
				break;
			case 3:
				selectNum();
				break;
			case 4:
				//글 삭제함수 호출
				deleteBoard();
				break;
			case 5:
				selectSearch();
				break;
			case 6:
				selectTop();
			case 9:
				System.out.println(" [알림] 게시판을 나갑니다.");
				return;
			default :
				System.out.println(" [에러] 번호를 다시 선택하세요.");
				break;
			}
		}

	}


	public void printMainMenu() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ 	게시판 연습										 │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│1. 글 쓰기                                                        │");	
		System.out.println("│2. 글 전체 목록                                                        │");	
		System.out.println("│3. 글 읽기                                                        │");	
		System.out.println("│4. 글 삭제                                                        │");	
		System.out.println("│5. 글 검색                                                     │");	
		System.out.println("│6. 상위 조회수 글 출력                                           │");	
		System.out.println("│9. 상위 메뉴                                                        │");	
		System.out.println("└──────────────────────────────┘");
		System.out.print(" 메뉴 번호를 선택하세요=> ");
		
	}

	//등록 함수
	public void insertBoard() {
		//제목, 내용, 작성자
		String title,content,name;
		Board board;


		System.out.println(" [ 글쓰기 ]");
		scan.nextLine();
		System.out.print("이름 : ");
		name = scan.nextLine();
		System.out.print("제목 : ");
		title = scan.nextLine();
		System.out.print("내용 : ");
		content = scan.nextLine();

		board = new Board();
		board.setBoard_name(name);
		board.setBoard_title(title);
		board.setBoard_content(content);

		boolean flag = dao.insertBoard(board);

		if(flag) {
			System.out.println(" [알림] 등록 완료");
		}else {
			System.out.println(" [알림] 등록 실패");
		}


	}

	//전체 목록
	public void selectAll() {
		System.out.println("[ 글 목록 ]");
		ArrayList<Board> list = dao.selectAll();

		if(list == null || list.size() == 0) {
			System.out.println(" [알림] 등록된 글이 없습니다.");
		}

		for(Board b : list) {
			System.out.print("번호 :" +b.getBoard_num()+"\t");
			System.out.print("제목 :" +b.getBoard_title()+"\t");
			System.out.print("작성자 :" +b.getBoard_name()+"\t");
			System.out.println("작성일 :" +b.getBoard_date()+"\t");
		}
		
		
	}
	
	//글을 조회수를 기준으로 내림차순 출력
	public void selectTop() {
		System.out.println("[ 상위 조회수 목록 ]");
		ArrayList<Board> list = dao.selectAll();

		if(list == null || list.size() == 0) {
			System.out.println(" [알림] 등록된 글이 없습니다.");
		}

		for(Board b : list) {
			System.out.print("번호 :" +b.getBoard_num()+"\t");
			System.out.print("제목 :" +b.getBoard_title()+"\t");
			System.out.print("작성자 :" +b.getBoard_name()+"\t");
			System.out.println("조회수 :" +b.getBoard_hit()+"\t");
		}
	}
	

	//글 삭제
	public void deleteBoard() {
		int no = 0;
		System.out.print("삭제할 글의 번호 입력 > ");
		try {
			no = scan.nextInt();
		}catch(Exception e) {
			System.out.println(" [에러] 숫자를 입력하세요.");
			scan.nextLine();
		}

		boolean flag = dao.deleteBoard(no);

		if(flag) {
			System.out.println(" [알림] 삭제 완료");
		}else {
			System.out.println(" [알림] 삭제 실패");
		}

	}

	//글의 번호로 글 내용 출력
	public void selectNum() {
		int no = 0;

		System.out.println("[ 글 읽기 ]");
		System.out.print("* 읽을 글의 번호 > ");
		try {
			no = scan.nextInt();
		}catch(Exception e) {
			System.out.println(" [에러] 숫자로 입력하세요.");
			scan.nextLine();
		}
		Board b = dao.selectNum(no);

		if(b == null) {
			System.out.println("해당 번호의 글이 없습니다.");
			return;
		}else {
			System.out.print("번호 :" +b.getBoard_num()+"\t");
			System.out.print("제목 :" +b.getBoard_title()+"\t");
			System.out.print("내용 :" +b.getBoard_content()+"\t");
			System.out.print("작성자 :" +b.getBoard_name()+"\t");
			System.out.print("작성일 :" +b.getBoard_date()+"\t");
			System.out.println("조회수 :" +b.getBoard_hit()+"\t");

			//해당 글의 리플 출력
			System.out.println();

			//해당 글의 리플 등록 메뉴
			System.out.print("1. 리플 달기  0.메인메뉴로 >");
			int num = 0;

			try {
				num = scan.nextInt();
			}catch(Exception e) {
				scan.nextLine();
			}

			if(num != 1) {
				return;
			}

			//리플 달기 함수 호출
			insertReply(no);
		}
	}



	//글 검색
	public void selectSearch() {
		int col = 0;					//검색수단
		String text = null;		//검색어


		System.out.println("[ 글 검색 ]");
		try {
			System.out.print("* 검색 대상 : 1.제목 2.내용 3.작성자 > ");
			col = scan.nextInt();
			System.out.print("* 검색어 > ");
			scan.nextLine();
			text = scan.nextLine();
		}catch(Exception e) {
			System.out.println(" [에러] 잘못 입력하셨습니다.");
			scan.nextLine();
			return;
		}

		HashMap<String, Object> map = new HashMap<>();
		map.put("col", col);
		map.put("text", text);

		ArrayList<Board> list = dao.selectSearch(map);

		if(list == null || list.size() == 0) {
			System.out.println(" [알림] 검색된 글이 없습니다.");
		}

		for(Board b : list) {
			System.out.print("번호 :" +b.getBoard_num()+"\t");
			System.out.print("제목 :" +b.getBoard_title()+"\t");
			System.out.print("작성자 :" +b.getBoard_name()+"\t");
			System.out.println("작성일 :" +b.getBoard_date()+"\t");
		}	
	}




	//리플 달기 함수
	public void insertReply(int board_num) {
		String reply_name,reply_text;
		Reply reply;

		System.out.println("==== 리플 쓰기 ====");
		scan.nextLine();
		System.out.print("이름 : ");
		reply_name = scan.nextLine();
		System.out.print("내용 : ");
		reply_text = scan.nextLine();

		reply = new Reply();
		reply.setBoard_num(board_num);
		reply.setReply_name(reply_name);
		reply.setReply_text(reply_text);

		boolean flag = dao.insertReply(reply);

		if(flag) {
			System.out.println(" [알림] 리플 등록 성공");
		}else {
			System.out.println(" [알림] 리플 등록 실패");
		}


	}

}
