package survey.dao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import survey.vo.Answer;


public class SVManager {
	private final String FILE_NAME = "answer.dat";	// 파일명 상수
	public ArrayList<Answer> list;	

	private FileInputStream fis;	//파일을 읽기위한 스트림
	private FileOutputStream fos;	//파일을 쓰기위한 스트림
	private ObjectInputStream ois;	//객체를 읽기위한 스트림
	private ObjectOutputStream oos;	//객체를 쓰기위한 스트림


	public SVManager(){
		File f = new File(FILE_NAME);

		if(f.exists()) {
			getFile();
		} else {
			list = new ArrayList<Answer>();
		}
	}


	
	public boolean setFile(){
		boolean result = false;
		try {
			fos = new FileOutputStream(FILE_NAME);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(list);
			oos.flush();
			result = true;
		} catch (IOException e) {
			System.out.println("[에러] 파일 쓰기에 실패했습니다.");
			//e.printStackTrace();
		}finally {
			closeStreams();
		}
		return result;
	}


	@SuppressWarnings("unchecked")
	public void getFile() {
		try {
			fis = new FileInputStream(FILE_NAME);
			ois = new ObjectInputStream(fis);

			list = (ArrayList<Answer>)ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeStreams();
		}

	}


	private void closeStreams() {
		if(fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(fos != null) {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ois != null) {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(oos != null) {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

