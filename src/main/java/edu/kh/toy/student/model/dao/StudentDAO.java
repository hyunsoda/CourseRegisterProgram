package edu.kh.toy.student.model.dao;

import static edu.kh.toy.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;


import edu.kh.toy.student.model.dto.Student;

public class StudentDAO {

	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;
	private Properties prop;
	
	public StudentDAO() {
		try {
			prop = new Properties();
			
			String filePath = StudentDAO.class.getResource("/edu/kh/toy/sql/student-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public Student login(Connection conn, String loginId, String loginPw) throws Exception{
	
		Student loginStudent = null;
		
		try {
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginId);
			pstmt.setString(2, loginPw);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				int studentNo = rs.getInt("STUDENT_NO");
				String studentId = rs.getString("STUDENT_ID");
				String studentPw = rs.getString("STUDENT_PW");
				String studentName = rs.getString("STUDENT_NAME");
				String major = rs.getString("MAJOR");
				
				loginStudent = new Student(studentNo, studentId, studentPw,studentName,major,"N");
			}
			
		} finally {
			close(rs);
			close(pstmt);
			
		}
		
		
		
		return loginStudent;
	}



	public int signup(Connection conn, Student student) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("signup");
			System.out.println(student.getStudentId());
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, student.getStudentId());
			pstmt.setString(2, student.getStudentPw());
			pstmt.setString(3, student.getStudentName());
			pstmt.setString(4, student.getMajor());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		
		
		return result;
	}



	public int duplicationCheck(Connection conn, Student student) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("duplicationCheck");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, student.getStudentId());
			
			rs = pstmt.executeQuery();

		 	if(rs.next()) {
		 		result = rs.getInt(1); // 첫 번째 column
		 	}
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}



	public int updateProfile(Connection conn, Student std, String newMajor) throws Exception{
		
		int result = 0;
		
		try{
			String sql = prop.getProperty("updateProfile");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newMajor);
			pstmt.setInt(2, std.getStudentNo());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		
		
		return result;
	}



	public Student searchPw(Connection conn, String inputNo, String inputMajor) throws Exception{
		
		Student student = null;
		
		try {
			String sql = prop.getProperty("searchId");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inputNo);
			pstmt.setString(2, inputMajor);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				student = new Student();
				
				student.setStudentId(rs.getString("STUDENT_ID"));
				student.setMajor(inputMajor);
				student.setStudentName(rs.getString("STUDENT_NAME"));
				student.setStudentNo(rs.getInt("STUDENT_NO"));
				student.setStudentPw(rs.getString("STUDENT_PW"));
				
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return student;
	}
	
	
	
	
	
}
