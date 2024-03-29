package edu.kh.toy.register.model.service;

import static edu.kh.toy.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.toy.register.model.dao.RegisterDAO;
import edu.kh.toy.register.model.dto.Register;

public class RegisterService {

	private RegisterDAO dao = new RegisterDAO();
	
	
	public int register(String clsName, int studentNo, String major) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.register(conn,clsName, studentNo,major);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		
		return result;
	}


	public int duplicationCheck(String clsName, int studentNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.duplicationCheck(conn, clsName, studentNo); 
		
		close(conn);
		
		return result;
		
	}


	public List<Register> selectAll(int studentNo) throws Exception{
		
		Connection conn = getConnection();
		
		List<Register> regList = dao.selectAll(conn, studentNo);
		
		close(conn);
		
		
		return regList;
	}


	public int dropClass(String regNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.dropClass(conn,regNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		return result;
	}

}
