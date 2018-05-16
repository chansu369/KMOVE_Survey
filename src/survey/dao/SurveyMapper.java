package survey.dao;

import java.util.ArrayList;
import java.util.HashMap;

import survey.vo.Admin;
import survey.vo.Answer;
import survey.vo.Board;
import survey.vo.Choice;
import survey.vo.Person;
import survey.vo.Q_sheet;
import survey.vo.Reply;
import survey.vo.User;

public interface SurveyMapper {


	//관리자
	//관리자 로그인
	public Admin loginAdmin(Admin ad);

	public void insertAdmin(Admin ad);

	public ArrayList<Answer> selectFile(int user_num);


	//사용자
	//user 회원가입
	public void insertPerson(Person p);

	public void insertUser(User u);

	//user 로그인
	public User loginUser(User u);

	//user 탈퇴
	public void deleteUser(int num);


	//user 조회
	public ArrayList<User> selectUser(HashMap<String, Object> map);

	//user 수정
	public void updateUser(User u);

	
	
	
	
	//설문지
	
	//설문 추가
	public void insertQsheet(Q_sheet sheet);
	
	//설문 - 답안 추가
	public void insertChoice(Choice choice);
	
	//설문지 수정
	public void updateQsheet(Q_sheet sheet);
	
	//설문 삭제
	public void deleteQsheet(int q_num);
	
	//답안 삭제
	public void deleteChoice(int q_num);
	
	//답안 수정
	public void updateAnswer(Answer answer);
	
	//사용자 -> 설문응답 조회
	public ArrayList<HashMap<String,Object>> getChoice(HashMap<String,Object> map);
	
	
	
	//설문조회 -> 시작시에(34기)
	public ArrayList<Q_sheet> selectQsheet();
	
	//설문응답출력 (34기)
	public ArrayList<Choice> selectChoice();
	
	//설문응답
	public void insertAnswer(Answer answer);
	

	//설문조회 -> 시작시에(33기)
	public ArrayList<Q_sheet> selectQsheets();
	
	//설문응답출력 (33기)
	public ArrayList<Choice> selectChoices();

	
	
	
	
	//게시판 
	public ArrayList<Board> selectTop();
	
	public int insertBoard(Board b);

	public ArrayList<Board> selectAll();

	public void deleteBoard(int num);


	public Board selectNum(int num);

	public void updateHit(int num);

	public ArrayList<Board> selectSearch(HashMap<String, Object> map);


	public void insertReply(Reply reply);
}
