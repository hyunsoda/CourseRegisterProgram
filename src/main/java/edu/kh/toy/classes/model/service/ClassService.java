package edu.kh.toy.classes.model.service;

import java.sql.Connection;
import java.util.List;

import edu.kh.toy.classes.model.dao.ClassDAO;
import edu.kh.toy.classes.model.dto.Cls;

import static edu.kh.toy.common.JDBCTemplate.*;
import edu.kh.toy.student.model.dto.Student;

public class ClassService {

	private ClassDAO dao = new ClassDAO();
	
	public List<Cls> selectAll(String major) throws Exception{
		
		Connection conn = getConnection();
		List<Cls> classList = dao.selectAll(conn, major);
		
		close(conn);
		
		return classList;
	}

}
