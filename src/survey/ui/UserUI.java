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
			//»ç¿ëÀÚ ¸Þ´º
			userMain();



			code = getNextInt();

			switch(code) {
			//¼³¹® ½ÃÀÛ
			case 1:
				startSurvey();
				break;
				//¼³¹® Á¶È¸
			case 2:
				selectSurvey();
				break;
				//ÀÀ´ä ¼öÁ¤
			case 3:
				updateSurvey();
				break;
				//°Ô½ÃÆÇ ÀÔÀå
			case 4:
				new BoardUI();
				break;
				//È¸¿øÁ¤º¸ Á¶È¸
			case 5:
				selectUser();
				break;
				//È¸¿øÁ¤º¸ ¼öÁ¤
			case 6:
				updateUser();
				break;
				//È¸¿øÅ»Åð
			case 7:
				deleteUser();
				return;
			case 9:
				sui = new SurveyUI();
				sui.printMenu();
				break;
			default:
				System.out.println(" [¿¡·¯] Àß¸øÀÔ·ÂÇß½À´Ï´Ù.");
				break;
			}



		}
	}

	//»ç¿ëÀÚ ¸Þ´º
	public void userMain() {
		System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
		System.out.println("¦¢ 	»ç¿ëÀÚ Menu						 ¦¢");
		System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
		System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
		System.out.println("¦¢1. ¼³¹® ½ÃÀÛ                                                        ¦¢");	
		System.out.println("¦¢2. ¼³¹® Á¶È¸                                                        ¦¢");	
		System.out.println("¦¢3. ÀÀ´ä ¼öÁ¤                                                        ¦¢");	
		System.out.println("¦¢4. °Ô½ÃÆÇ ÀÔÀå                                                     ¦¢");	
		System.out.println("¦¢5. È¸¿ø Á¤º¸ Á¶È¸                                                     ¦¢");	
		System.out.println("¦¢6. È¸¿ø Á¤º¸ ¼öÁ¤                                                    ¦¢");	
		System.out.println("¦¢7. È¸¿ø Å»Åð                                                    ¦¢");	
		System.out.println("¦¢9. ·Î±× ¾Æ¿ô                                                     ¦¢");	
		System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
		System.out.print(" ¸Þ´º ¹øÈ£¸¦ ¼±ÅÃÇÏ¼¼¿ä=> ");


	}


	//¼³¹® ½ÃÀÛ
	public void startSurvey() {
		System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
		System.out.println("¦¢ 	Survey							 ¦¢");
		System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");

		int count1,count2,count3;
		//»ç¿ëÀÚ Á¤º¸ ¹Þ¾Æ¿À±â
		User l_user = new User();
		l_user = SurveyUI.user;

		//±â¼öº° ¼³¹®Áö ´Ù¸£°Ô Ãâ·Â
		if(l_user.getCard() == 34) {
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("¦¢ 	34±â ¼³¹®Áö							 ¦¢");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");


			ArrayList<Q_sheet> list = dao.selectQsheet();
			ArrayList<Choice> chlist = dao.selectChoice();

			count1 = 1;
			for(Q_sheet q : list) {
				System.out.println(+ q.getQ_num()+"¹ø. " + q.getQ_text());

				for(Choice c : chlist) {
					if(c.getQ_num() == count1) {
						System.out.println(c.getChoice_num()+". " + c.getAnswer_text());
					}
				}
				System.out.print(" [´ä¾È ÀÔ·Â] :  ");
				int an = getNextInt();
				System.out.println("\t");

				//´ä¾È µî·Ï
				Answer answer = new Answer();
				answer.setQ_code(count1);
				answer.setAnswer_num(an);
				answer.setUser_num(l_user.getUser_num());

				boolean flag = dao.insertAnswer(answer);

				if(flag) {
					count1++;
				}else {
					System.out.println(" [¾Ë¸²] ´ä¾Èµî·Ï½ÇÆÐ");
					return;
				}
				scan.nextLine();
			}

			//33±â
		}else if (l_user.getCard() == 33) {
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("¦¢ 	33±â ¼³¹®Áö							 ¦¢");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");

			ArrayList<Q_sheet> list = dao.selectQsheets();
			ArrayList<Choice> chlist = dao.selectChoices();

			count2 = 31;
			count3 = 100;
			for(Q_sheet q : list) {
				System.out.println(+ q.getQ_num()+"¹ø. " + q.getQ_text());

				for(Choice c : chlist) {
					if(c.getQ_num() == count3) {
						System.out.println(c.getChoice_num()+". " + c.getAnswer_text());
					}
				}
				System.out.print(" [´ä¾È ÀÔ·Â] :  ");
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
					System.out.println(" [¾Ë¸²] ´ä¾Èµî·Ï½ÇÆÐ");
					return;
				}
				scan.nextLine();
			}
			System.out.println(" [¾Ë¸²] ´ä¾Èµî·Ï¼º°ø");
		}else {
			System.out.println(" [¾Ë¸²] ±â¼öÁ¤º¸ Àß¸ø ÀÔ·Â");
			return;
		}
		
		System.out.println(" [¾Ë¸²] ´ä¾Èµî·Ï¼º°ø");

	}



	//¼³¹® Á¶È¸

	public void selectSurvey() {
		System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
		System.out.println("¦¢ 	¼³¹® Á¶È¸							 ¦¢");
		System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");

		//·Î±×ÀÎ »ç¿ëÀÚ °´Ã¼ ¹Þ¾Æ¿À±â
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


	//ÀÀ´ä ¼öÁ¤
	public void updateSurvey() {
		System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
		System.out.println("¦¢ 	ÀÀ´ä ¼öÁ¤							 ¦¢");
		System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");

		Answer an = new Answer();
		//¼³¹®Á¶È¸
		asv.selectSurvey();

		System.out.println("===============================================\t");

		//»ç¿ëÀÚ¹øÈ£¿Í ¹®Á¦¹øÈ£ ÇÊ¿ä
		System.out.print("¼öÁ¤ÇÒ ÀÀ´äÀÇ ¹®Ç× ¹øÈ£ ÀÔ·Â (34±â : 1 ~ 99 // 33±â : 100 ~ 200) : ");
		int q_num = getNextInt();

		System.out.print("¼öÁ¤ÇÒ ÀÀ´ä¹øÈ£ ÀÔ·Â : ");
		int answer_num = getNextInt();

		an.setQ_code(q_num);
		an.setAnswer_num(answer_num);
		an.setUser_num(SurveyUI.user.getUser_num());

		boolean flag = dao.updateAnswer(an);

		if(flag) {
			System.out.println(" [¾Ë¸²] ÀÀ´ä ¼öÁ¤ ¼º°ø");
		}else {
			System.out.println(" [¾Ë¸²] ÀÀ´ä ¼öÁ¤ ½ÇÆÐ");
		}
	}


	//È¸¿øÁ¤º¸ Á¶È¸
	//¿Ï¼º
	public void selectUser() {
		System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
		System.out.println("¦¢ 	È¸¿øÁ¤º¸ Á¶È¸							 ¦¢");
		System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");


		int col = 0;					//°Ë»ö¼ö´Ü
		String text = null;		//°Ë»ö¾î


		try {
			System.out.print("* °Ë»ö ´ë»ó : 1.ÀÌ¸§ 2.»ç¿ëÀÚ ID  > ");
			col = scan.nextInt();
			System.out.print("* °Ë»ö¾î > ");
			scan.nextLine();
			text = scan.nextLine();
		}catch(Exception e) {
			System.out.println(" [¿¡·¯] Àß¸ø ÀÔ·ÂÇÏ¼Ì½À´Ï´Ù.");
			scan.nextLine();
			return;
		}

		HashMap<String, Object> map = new HashMap<>();
		map.put("col", col);
		map.put("text", text);

		ArrayList<User> list = dao.selectUser(map);

		if(list == null || list.size() == 0) {
			System.out.println(" [¾Ë¸²] °Ë»öµÈ ±ÛÀÌ ¾ø½À´Ï´Ù.");
		}

		for(User u : list) {
			System.out.println("°íÀ¯ È¸¿ø ¹øÈ£ : "+ u.getNum());
			System.out.println("»ç¿ëÀÚ ¹øÈ£ : "+ u.getUser_num());
			System.out.println("ÀÌ¸§ : "+ u.getName());
			System.out.println("³ªÀÌ : "+ u.getAge());
			System.out.println("ÀüÈ­ ¹øÈ£ : "+ u.getPhone());
			System.out.println("ÁÖ¼Ò : "+ u.getAddress());
			System.out.println("»ç¿ëÀÚ ID : "+ u.getUser_id());
			System.out.println("±â¼ö Á¤º¸ : "+ u.getCard());
		}	
	}

	//È¸¿øÁ¤º¸¼öÁ¤
	//¿Ï¼º
	public void updateUser() {
		System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
		System.out.println("¦¢ 	È¸¿øÁ¤º¸ ¼öÁ¤							 ¦¢");
		System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");

		User update_u = new User();
		System.out.print("[ °íÀ¯ È¸¿ø ¹øÈ£ ÀÔ·Â ] : ");
		int num = getNextInt();

		scan.nextLine();
		System.out.print("[ ¼öÁ¤ÇÒ ID ] : ");
		String user_id = scan.next();
		System.out.print("[ ¼öÁ¤ÇÒ ºñ¹Ð¹øÈ£ ] : ");
		String user_pwd = scan.next();
		System.out.print("[ ±â¼ö ] (33 or 34): ");
		int card = getNextInt();


		update_u.setNum(num);
		update_u.setUser_id(user_id);
		update_u.setUser_pwd(user_pwd);
		update_u.setCard(card);


		boolean flag = dao.updateUser(update_u);

		if(flag) {
			System.out.println(" [¾Ë¸²] ¾÷µ¥ÀÌÆ® ¼º°ø");
		}else {
			System.out.println(" [¾Ë¸²] ¾÷µ¥ÀÌÆ® ½ÇÆÐ");
		}



	}


	//È¸¿øÅ»Åð
	//¿Ï¼º

	public void deleteUser() {
		System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
		System.out.println("¦¢ 	È¸¿øÅ»Åð							 ¦¢");
		System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");


		int num = SurveyUI.user.getNum();

		System.out.print(" [¾Ë¸²] Á¤¸» Å»ÅðÇÏ½Ã°Ú½À´Ï±î? (y/n)  : ");
		String delete_answer = scan.nextLine();
		
		if(delete_answer.toLowerCase().equals("y")) { 

			boolean flag = dao.deleteUser(num);

			if(flag) {
				System.out.println(" [¾Ë¸²] Å»Åð°¡ ¿Ï·áµÇ¾ú½À´Ï´Ù.");
			}else {
				System.out.println(" [¾Ë¸²] Å»Åð ½ÇÆÐÇß½À´Ï´Ù.");
			}

		}else if(delete_answer.toLowerCase().equals("n")) {
			return;
		}

	}






	//Á¤¼ö ÀÔ·Â±â
	public int getNextInt() {
		int option = 0;

		do {
			try {
				option = scan.nextInt();
			} catch (Exception e) {
				System.out.println("[¿¡·¯] Àß¸ø ÀÔ·ÂÇÏ¿´½À´Ï´Ù");
				scan.nextLine();
			}
		} while(option == 0);

		return option;
	}

}
