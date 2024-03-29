package edu.kh.toy.student.controller;

import java.io.IOException;

import edu.kh.toy.student.model.dto.Student;
import edu.kh.toy.student.model.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.jsp.HttpJspPage;

@WebServlet("/signup")
public class SignupController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			HttpSession session = req.getSession();
			
			
			String inputId = req.getParameter("inputId");
			String inputPw = req.getParameter("inputPw");
			String inputName = req.getParameter("inputName");
			String inputmajor = req.getParameter("inputMajor");
			
			Student student = new Student();
			
			student.setStudentId(inputId);
			student.setStudentPw(inputPw);
			student.setStudentName(inputName);
			student.setMajor(inputmajor);
			
			StudentService service = new StudentService();
			
			int result2 = service.duplicationCheck(student);
			
			if(result2 != 0) {
				
				session.setAttribute("message", "중복된 아이디입니다.");
				resp.sendRedirect(req.getHeader("referer"));
			
		} else {
			
			int result = service.signup(student);
			
			if(result > 0) {
				session.setAttribute("message", "입학을 축하드립니다!");
				resp.sendRedirect("/");
			} else {
				session.setAttribute("message", "회원가입 실패");
				resp.sendRedirect(req.getHeader("referer"));
			}
			
			
			
		}
		
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("회원가입 중 예외 발생");
		}
		
		
	}
}
