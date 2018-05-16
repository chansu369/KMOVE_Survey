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


	//������
	//������ �α���
	public Admin loginAdmin(Admin ad);

	public void insertAdmin(Admin ad);

	public ArrayList<Answer> selectFile(int user_num);


	//�����
	//user ȸ������
	public void insertPerson(Person p);

	public void insertUser(User u);

	//user �α���
	public User loginUser(User u);

	//user Ż��
	public void deleteUser(int num);


	//user ��ȸ
	public ArrayList<User> selectUser(HashMap<String, Object> map);

	//user ����
	public void updateUser(User u);

	
	
	
	
	//������
	
	//���� �߰�
	public void insertQsheet(Q_sheet sheet);
	
	//���� - ��� �߰�
	public void insertChoice(Choice choice);
	
	//������ ����
	public void updateQsheet(Q_sheet sheet);
	
	//���� ����
	public void deleteQsheet(int q_num);
	
	//��� ����
	public void deleteChoice(int q_num);
	
	//��� ����
	public void updateAnswer(Answer answer);
	
	//����� -> �������� ��ȸ
	public ArrayList<HashMap<String,Object>> getChoice(HashMap<String,Object> map);
	
	
	
	//������ȸ -> ���۽ÿ�(34��)
	public ArrayList<Q_sheet> selectQsheet();
	
	//����������� (34��)
	public ArrayList<Choice> selectChoice();
	
	//��������
	public void insertAnswer(Answer answer);
	

	//������ȸ -> ���۽ÿ�(33��)
	public ArrayList<Q_sheet> selectQsheets();
	
	//����������� (33��)
	public ArrayList<Choice> selectChoices();

	
	
	
	
	//�Խ��� 
	public ArrayList<Board> selectTop();
	
	public int insertBoard(Board b);

	public ArrayList<Board> selectAll();

	public void deleteBoard(int num);


	public Board selectNum(int num);

	public void updateHit(int num);

	public ArrayList<Board> selectSearch(HashMap<String, Object> map);


	public void insertReply(Reply reply);
}
