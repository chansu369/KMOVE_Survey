package survey.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import survey.vo.Admin;
import survey.vo.Answer;
import survey.vo.Board;
import survey.vo.Choice;
import survey.vo.Person;
import survey.vo.Q_sheet;
import survey.vo.Reply;
import survey.vo.User;

public class SurveyDAO {
	private SqlSessionFactory factory=MybatisConfig.getSqlSessionFactory();




	//������
	public boolean insertAdmin(Admin ad) {
		SqlSession session = null;

		try {		
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			mapper.insertAdmin(ad);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if(session != null) {
				session.close();
			}
		}

		return true;

	}



	public Admin loginAdmin(Admin ad) {
		SqlSession session = null;
		Admin find_ad = null;

		try {		
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			find_ad = mapper.loginAdmin(ad);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			if(session != null) {
				session.close();
			}
		}

		return find_ad;

	}

	
	//������¿� �ʿ��� �÷��� �޾ƿ���
	public ArrayList<Answer> selectFile(int user_num) {
		SqlSession session = null;
		ArrayList<Answer> list = null;

		try {		
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			list = mapper.selectFile(user_num);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}

		return list;

	}


	//�����
	//��ϱ��
	public boolean insertPerson(Person p) {
		SqlSession session = null;

		try {		
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			mapper.insertPerson(p);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if(session != null) {
				session.close();
			}
		}

		return true;

	}

	public boolean insertUser(User u) {
		SqlSession session = null;

		try {		
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			mapper.insertUser(u);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if(session != null) {
				session.close();
			}
		}

		return true;

	}



	//user �α���
	public User loginUser(User u) {
		SqlSession session = null;
		User find_u = null;

		try {		
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			find_u = mapper.loginUser(u);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			if(session != null) {
				session.close();
			}
		}

		return find_u;

	}


	//user Ż��
	public boolean deleteUser(int num) {
		SqlSession session = null;

		try {		
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			mapper.deleteUser(num);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if(session != null) {
				session.close();
			}
		}

		return true;
	}

	//user ��ȸ
	public ArrayList<User> selectUser(HashMap<String, Object> map) {
		SqlSession session = null;
		ArrayList<User> list = null;

		try {
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			list = mapper.selectUser(map);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			if(session != null) {
				session.close();
			}
		}

		return list;
	}


	//user ����
	public boolean updateUser(User u) {
		SqlSession session = null;

		try {
			session = factory.openSession();

			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			mapper.updateUser(u);
			session.commit();

		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return true;
	}






	//������

	//�����߰�
	public boolean insertQsheet(Q_sheet sheet) {
		SqlSession session = null;

		try {		
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			mapper.insertQsheet(sheet);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if(session != null) {
				session.close();
			}
		}

		return true;

	}


	//���� - ��� �߰�
	public boolean insertChoice(Choice choice) {
		SqlSession session = null;

		try {		
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			mapper.insertChoice(choice);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if(session != null) {
				session.close();
			}
		}

		return true;


	}


	//���� ����
	public boolean updateQsheet(Q_sheet sheet) {
		SqlSession session = null;

		try {
			session = factory.openSession();

			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			mapper.updateQsheet(sheet);
			session.commit();

		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return true;

	}


	//���� ����
	public boolean deleteQsheet(int q_num) {
		SqlSession session = null;

		try {		
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			mapper.deleteQsheet(q_num);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if(session != null) {
				session.close();
			}
		}

		return true;

	}

	//��� ����
	public boolean deleteChoice(int q_num) {
		SqlSession session = null;

		try {		
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			mapper.deleteChoice(q_num);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if(session != null) {
				session.close();
			}
		}

		return true;

	}




	//������ȸ -> ���۽ÿ�(34��)
	public ArrayList<Q_sheet> selectQsheet(){
		SqlSession session = null;
		ArrayList<Q_sheet> list = null;

		try {
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			list = mapper.selectQsheet();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return list;
	}



	//����������� (34��)
	public ArrayList<Choice> selectChoice(){
		SqlSession session = null;
		ArrayList<Choice> list = null;

		try {
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			list = mapper.selectChoice();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return list;
	}



	//������ȸ -> ���۽ÿ�(33��)
	public ArrayList<Q_sheet> selectQsheets(){
		SqlSession session = null;
		ArrayList<Q_sheet> list = null;

		try {
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			list = mapper.selectQsheets();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return list;
	}

	//����� -> �������� ��ȸ
	public ArrayList<HashMap<String,Object>> getChoice(HashMap<String,Object> map){
		SqlSession session = null;
		ArrayList<HashMap<String,Object>> list = null;

		try {
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			list = mapper.getChoice(map);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return list;
	}


	//����������� (34��)
	public ArrayList<Choice> selectChoices(){
		SqlSession session = null;
		ArrayList<Choice> list = null;

		try {
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			list = mapper.selectChoices();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return list;
	}



	//��������
	public boolean insertAnswer(Answer answer) {
		SqlSession session = null;

		try {		
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			mapper.insertAnswer(answer);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if(session != null) {
				session.close();
			}
		}

		return true;

	}






	//���� ����
	public boolean updateAnswer(Answer answer) {
		SqlSession session = null;

		try {		
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			mapper.updateAnswer(answer);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if(session != null) {
				session.close();
			}
		}

		return true;
		
	}





	//�Խ��� ����
	//����Լ��� ����
	//��ϱ��
	public boolean insertBoard(Board b) {
		SqlSession session = null;

		try {		
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			mapper.insertBoard(b);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if(session != null) {
				session.close();
			}
		}

		return true;
	}

	//��ü ��� �Լ�
	public ArrayList<Board> selectAll() {
		SqlSession session = null;
		ArrayList<Board> list = null;

		try {
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			list = mapper.selectAll();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return list;
	}

	//��ȸ�� �������� ���
	public ArrayList<Board> selectTop(){
		SqlSession session = null;
		ArrayList<Board> list = null;

		try {
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			list = mapper.selectTop();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return list;
	}
	

	//���� �Լ�
	public boolean deleteBoard(int num) {
		SqlSession session = null;

		try {
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			mapper.deleteBoard(num);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return true;
	}


	//��ȣ�� �۳��� ��� ����
	public Board selectNum(int num) {
		SqlSession session = null;
		Board find_b = null;

		try {
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);

			//��ȸ���� ����
			mapper.updateHit(num);
			session.commit();

			//�ش� �� ��ȣ�� �� ��ü�� ������ �κ�
			find_b = mapper.selectNum(num);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			if(session != null) {
				session.close();
			}
		}

		return find_b;

	}




	public ArrayList<Board> selectSearch(HashMap<String, Object> map) {
		SqlSession session = null;
		ArrayList<Board> list = null;

		try {
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			list = mapper.selectSearch(map);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			if(session != null) {
				session.close();
			}
		}

		return list;
	}




	//���õ���Լ�
	public boolean insertReply(Reply reply) {
		SqlSession session = null;

		try {
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);
			mapper.insertReply(reply);
			session.commit();

		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
