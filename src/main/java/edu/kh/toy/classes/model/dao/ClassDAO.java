package edu.kh.toy.classes.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static edu.kh.toy.common.JDBCTemplate.*;


import edu.kh.toy.classes.model.dto.Cls;
import edu.kh.toy.student.model.dto.Student;

public class ClassDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public ClassDAO() {
		try {
			prop = new Properties();
			
			String filePath = ClassDAO.class.getResource("/edu/kh/toy/sql/class-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public List<Cls> selectAll(Connection conn, String major) throws Exception{
		
		List<Cls> classList = new ArrayList<Cls>();
		
		try {
			String sql = prop.getProperty("selectAll");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, major);
			
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				Cls cls = new Cls();
				
				
				cls.setClsNo(rs.getInt("CLS_NO"));
				cls.setClsName(rs.getString("CLS_NAME"));
				cls.setMajor(major);
			
				
				classList.add(cls);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return classList;
	}

}
