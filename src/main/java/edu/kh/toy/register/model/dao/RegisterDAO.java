package edu.kh.toy.register.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.toy.register.model.dto.Register;

import static edu.kh.toy.common.JDBCTemplate.*;

public class RegisterDAO {

	public RegisterDAO() {
		try {
			prop = new Properties();
			
			String filePath = RegisterDAO.class.getResource("/edu/kh/toy/sql/register-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public int register(Connection conn, String clsName, int studentNo, String major) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("register");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,clsName );
			pstmt.setInt(2, studentNo);
			pstmt.setString(3, major);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		
		
		return result;
	}

	public int duplicationCheck(Connection conn, String clsName, int studentNo) throws Exception{
		
		int result = 0;
		
		try {
		 	String sql = prop.getProperty("duplicationCheck");
		 	
		 	pstmt = conn.prepareStatement(sql);
		 	pstmt.setString(1, clsName);
		 	pstmt.setInt(2, studentNo);
		 	
		 	rs = pstmt.executeQuery(); // count지만 select이기 때문에 resultSet임
			
		 	if(rs.next()) {
		 		result = rs.getInt(1); // 첫 번째 column
		 	}
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
		
		
	}

	public List<Register> selectAll(Connection conn, int studentNo) throws Exception{
		
		List<Register> regList = new ArrayList<Register>();
		
		try {
			String sql = prop.getProperty("selectAll");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, studentNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Register regi = new Register();
				
				regi.setClsName(rs.getString("CLS_NAME"));
				regi.setMajor(rs.getString("MAJOR"));
				regi.setRegNo(rs.getInt("REG_NO"));
				regi.setStudentNo(rs.getInt("STUDENT_NO"));
				
				regList.add(regi);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return regList;
	}

	public int dropClass(Connection conn, String regNo) throws Exception{
		
		int result = 0;
		try {
			String sql = prop.getProperty("dropClass");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, regNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		
		
		return result;
	}



}
