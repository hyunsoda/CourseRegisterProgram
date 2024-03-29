package edu.kh.toy.student.model.service;

import java.sql.Connection;

import static edu.kh.toy.common.JDBCTemplate.*;

import edu.kh.toy.student.model.dao.StudentDAO;
import edu.kh.toy.student.model.dto.Student;

public class StudentService {
	
	private StudentDAO dao = new StudentDAO();

	
	
	public Student login(String loginId, String loginPw) throws Exception{
		Connection conn = getConnection();
		
		Student loginStudent = dao.login(conn,loginId,loginPw);
		
		close(conn);
		
		
		return loginStudent;
	}



	public int signup(Student student) throws Exception{
	
		Connection conn = getConnection();
		
		int result = dao.signup(conn,student);
		
		if(result >0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}



	public int duplicationCheck(Student student) throws Exception{
		
		Connection conn = getConnection();
		 
		int result = dao.duplicationCheck(conn, student);
		
		close(conn);
		return result;
	}



	public int updateProfile(Student std, String newMajor) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.updateProfile(conn,std,newMajor);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}



	public Student searchPw(String inputNo, String inputMajor) throws Exception{
		
		Connection conn = getConnection();
		Student student = dao.searchPw(conn,inputNo,inputMajor);
		
		close(conn);
				
		
		return student;
	}

}
