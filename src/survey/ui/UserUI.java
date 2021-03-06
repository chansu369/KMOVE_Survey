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
			//餌辨濠 詭景
			userMain();



			code = getNextInt();

			switch(code) {
			//撲僥 衛濛
			case 1:
				startSurvey();
				break;
				//撲僥 褻��
			case 2:
				selectSurvey();
				break;
				//擬港 熱薑
			case 3:
				updateSurvey();
				break;
				//啪衛っ 殮濰
			case 4:
				new BoardUI();
				break;
				//�蛾讔內� 褻��
			case 5:
				selectUser();
				break;
				//�蛾讔內� 熱薑
			case 6:
				updateUser();
				break;
				//�蛾躠酷�
			case 7:
				deleteUser();
				return;
			case 9:
				sui = new SurveyUI();
				sui.printMenu();
				break;
			default:
				System.out.println(" [縑楝] 澀跤殮溘ц蝗棲棻.");
				break;
			}



		}
	}

	//餌辨濠 詭景
	public void userMain() {
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("弛 	餌辨濠 Menu						 弛");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("弛1. 撲僥 衛濛                                                        弛");	
		System.out.println("弛2. 撲僥 褻��                                                        弛");	
		System.out.println("弛3. 擬港 熱薑                                                        弛");	
		System.out.println("弛4. 啪衛っ 殮濰                                                     弛");	
		System.out.println("弛5. �蛾� 薑爾 褻��                                                     弛");	
		System.out.println("弛6. �蛾� 薑爾 熱薑                                                    弛");	
		System.out.println("弛7. �蛾� 驍黴                                                    弛");	
		System.out.println("弛9. 煎斜 嬴醒                                                     弛");	
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.print(" 詭景 廓�ㄧ� 摹鷗ж撮蹂=> ");


	}


	//撲僥 衛濛
	public void startSurvey() {
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("弛 	Survey							 弛");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");

		int count1,count2,count3;
		//餌辨濠 薑爾 嫡嬴螃晦
		User l_user = new User();
		l_user = SurveyUI.user;

		//晦熱滌 撲僥雖 棻腦啪 轎溘
		if(l_user.getCard() == 34) {
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("弛 	34晦 撲僥雖							 弛");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");


			ArrayList<Q_sheet> list = dao.selectQsheet();
			ArrayList<Choice> chlist = dao.selectChoice();

			count1 = 1;
			for(Q_sheet q : list) {
				System.out.println(+ q.getQ_num()+"廓. " + q.getQ_text());

				for(Choice c : chlist) {
					if(c.getQ_num() == count1) {
						System.out.println(c.getChoice_num()+". " + c.getAnswer_text());
					}
				}
				System.out.print(" [港寰 殮溘] :  ");
				int an = getNextInt();
				System.out.println("\t");

				//港寰 蛔煙
				Answer answer = new Answer();
				answer.setQ_code(count1);
				answer.setAnswer_num(an);
				answer.setUser_num(l_user.getUser_num());

				boolean flag = dao.insertAnswer(answer);

				if(flag) {
					count1++;
				}else {
					System.out.println(" [憲葡] 港寰蛔煙褒ぬ");
					return;
				}
				scan.nextLine();
			}

			//33晦
		}else if (l_user.getCard() == 33) {
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("弛 	33晦 撲僥雖							 弛");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");

			ArrayList<Q_sheet> list = dao.selectQsheets();
			ArrayList<Choice> chlist = dao.selectChoices();

			count2 = 31;
			count3 = 100;
			for(Q_sheet q : list) {
				System.out.println(+ q.getQ_num()+"廓. " + q.getQ_text());

				for(Choice c : chlist) {
					if(c.getQ_num() == count3) {
						System.out.println(c.getChoice_num()+". " + c.getAnswer_text());
					}
				}
				System.out.print(" [港寰 殮溘] :  ");
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
					System.out.println(" [憲葡] 港寰蛔煙褒ぬ");
					return;
				}
				scan.nextLine();
			}
			System.out.println(" [憲葡] 港寰蛔煙撩奢");
		}else {
			System.out.println(" [憲葡] 晦熱薑爾 澀跤 殮溘");
			return;
		}
		
		System.out.println(" [憲葡] 港寰蛔煙撩奢");

	}



	//撲僥 褻��

	public void selectSurvey() {
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("弛 	撲僥 褻��							 弛");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");

		//煎斜檣 餌辨濠 偌羹 嫡嬴螃晦
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


	//擬港 熱薑
	public void updateSurvey() {
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("弛 	擬港 熱薑							 弛");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");

		Answer an = new Answer();
		//撲僥褻��
		asv.selectSurvey();

		System.out.println("===============================================\t");

		//餌辨濠廓�ˋ� 僥薯廓�� в蹂
		System.out.print("熱薑й 擬港曖 僥о 廓�� 殮溘 (34晦 : 1 ~ 99 // 33晦 : 100 ~ 200) : ");
		int q_num = getNextInt();

		System.out.print("熱薑й 擬港廓�� 殮溘 : ");
		int answer_num = getNextInt();

		an.setQ_code(q_num);
		an.setAnswer_num(answer_num);
		an.setUser_num(SurveyUI.user.getUser_num());

		boolean flag = dao.updateAnswer(an);

		if(flag) {
			System.out.println(" [憲葡] 擬港 熱薑 撩奢");
		}else {
			System.out.println(" [憲葡] 擬港 熱薑 褒ぬ");
		}
	}


	//�蛾讔內� 褻��
	//諫撩
	public void selectUser() {
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("弛 	�蛾讔內� 褻��							 弛");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");


		int col = 0;					//匐儀熱欽
		String text = null;		//匐儀橫


		try {
			System.out.print("* 匐儀 渠鼻 : 1.檜葷 2.餌辨濠 ID  > ");
			col = scan.nextInt();
			System.out.print("* 匐儀橫 > ");
			scan.nextLine();
			text = scan.nextLine();
		}catch(Exception e) {
			System.out.println(" [縑楝] 澀跤 殮溘ж樟蝗棲棻.");
			scan.nextLine();
			return;
		}

		HashMap<String, Object> map = new HashMap<>();
		map.put("col", col);
		map.put("text", text);

		ArrayList<User> list = dao.selectUser(map);

		if(list == null || list.size() == 0) {
			System.out.println(" [憲葡] 匐儀脹 旋檜 橈蝗棲棻.");
		}

		for(User u : list) {
			System.out.println("堅嶸 �蛾� 廓�� : "+ u.getNum());
			System.out.println("餌辨濠 廓�� : "+ u.getUser_num());
			System.out.println("檜葷 : "+ u.getName());
			System.out.println("釭檜 : "+ u.getAge());
			System.out.println("瞪�� 廓�� : "+ u.getPhone());
			System.out.println("輿模 : "+ u.getAddress());
			System.out.println("餌辨濠 ID : "+ u.getUser_id());
			System.out.println("晦熱 薑爾 : "+ u.getCard());
		}	
	}

	//�蛾讔內蜈鶬�
	//諫撩
	public void updateUser() {
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("弛 	�蛾讔內� 熱薑							 弛");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");

		User update_u = new User();
		System.out.print("[ 堅嶸 �蛾� 廓�� 殮溘 ] : ");
		int num = getNextInt();

		scan.nextLine();
		System.out.print("[ 熱薑й ID ] : ");
		String user_id = scan.next();
		System.out.print("[ 熱薑й 綠塵廓�� ] : ");
		String user_pwd = scan.next();
		System.out.print("[ 晦熱 ] (33 or 34): ");
		int card = getNextInt();


		update_u.setNum(num);
		update_u.setUser_id(user_id);
		update_u.setUser_pwd(user_pwd);
		update_u.setCard(card);


		boolean flag = dao.updateUser(update_u);

		if(flag) {
			System.out.println(" [憲葡] 機等檜お 撩奢");
		}else {
			System.out.println(" [憲葡] 機等檜お 褒ぬ");
		}



	}


	//�蛾躠酷�
	//諫撩

	public void deleteUser() {
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("弛 	�蛾躠酷�							 弛");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");


		int num = SurveyUI.user.getNum();

		System.out.print(" [憲葡] 薑蜓 驍黴ж衛啊蝗棲梱? (y/n)  : ");
		String delete_answer = scan.nextLine();
		
		if(delete_answer.toLowerCase().equals("y")) { 

			boolean flag = dao.deleteUser(num);

			if(flag) {
				System.out.println(" [憲葡] 驍黴陛 諫猿腎歷蝗棲棻.");
			}else {
				System.out.println(" [憲葡] 驍黴 褒ぬц蝗棲棻.");
			}

		}else if(delete_answer.toLowerCase().equals("n")) {
			return;
		}

	}






	//薑熱 殮溘晦
	public int getNextInt() {
		int option = 0;

		do {
			try {
				option = scan.nextInt();
			} catch (Exception e) {
				System.out.println("[縑楝] 澀跤 殮溘ж艘蝗棲棻");
				scan.nextLine();
			}
		} while(option == 0);

		return option;
	}

}
