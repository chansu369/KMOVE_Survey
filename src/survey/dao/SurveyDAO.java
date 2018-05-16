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




	//관리자
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

	
	//파일출력에 필요한 컬럼값 받아오기
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


	//사용자
	//등록기능
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



	//user 로그인
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


	//user 탈퇴
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

	//user 조회
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


	//user 수정
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






	//설문지

	//설문추가
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


	//설문 - 답안 추가
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


	//설문 수정
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


	//설문 삭제
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

	//답안 삭제
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




	//설문조회 -> 시작시에(34기)
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



	//설문응답출력 (34기)
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



	//설문조회 -> 시작시에(33기)
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

	//사용자 -> 설문응답 조회
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


	//설문응답출력 (34기)
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



	//설문응답
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






	//응답 수정
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





	//게시판 쿼리
	//기능함수를 정의
	//등록기능
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

	//전체 목록 함수
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

	//조회수 내림차순 출력
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
	

	//삭제 함수
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


	//번호로 글내용 출력 선택
	public Board selectNum(int num) {
		SqlSession session = null;
		Board find_b = null;

		try {
			session = factory.openSession();
			SurveyMapper mapper = session.getMapper(SurveyMapper.class);

			//조회수를 증가
			mapper.updateHit(num);
			session.commit();

			//해당 글 번호의 글 객체를 얻어오는 부분
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




	//리플등록함수
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
