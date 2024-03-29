package edu.kh.toy.student.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.toy.classes.model.dto.Cls;
import edu.kh.toy.classes.model.service.ClassService;
import edu.kh.toy.student.model.dto.Student;
import edu.kh.toy.student.model.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
		
		String loginId = req.getParameter("loginId");
		String loginPw = req.getParameter("loginPw");
		
		StudentService service = new StudentService();
		
		Student loginStudent = service.login(loginId, loginPw);
		
		HttpSession session = req.getSession();
		
		if(loginStudent != null) {
			session.setAttribute("loginStudent", loginStudent);
			
			ClassService clsService = new ClassService();
			List<Cls> classList = clsService.selectAll(loginStudent.getMajor());
			session.setAttribute("classList", classList);
			
			resp.sendRedirect("/");
			
		}else {
			session.setAttribute("message", "아이디 또는 비밀번호를 확인해주세요!");
			
			String referer = req.getHeader("referer");
			resp.sendRedirect(referer);
		}
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("로그인 중 예외 발생");
			
		}
		

	}
		
	
	
	
}
