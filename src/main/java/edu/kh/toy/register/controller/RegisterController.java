package edu.kh.toy.register.controller;

import java.io.IOException;

import edu.kh.toy.classes.model.dto.Cls;
import edu.kh.toy.register.model.service.RegisterService;
import edu.kh.toy.student.model.dto.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/register")
public class RegisterController extends HttpServlet{
	
	private RegisterService service = new RegisterService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();
			String clsName =  req.getParameter("clsName");
			Student student = (Student)session.getAttribute("loginStudent");
			
			int result = service.duplicationCheck(clsName,student.getStudentNo());
			
			if(result>0) {
				session.setAttribute("message", "이미 신청한 강의입니다.");
				resp.sendRedirect("/");
			} else {
				
			int result1 = service.register(clsName,student.getStudentNo(),student.getMajor());
			
			if(result1 > 0 ) {
				session.setAttribute("message", "신청되었습니다!");
				resp.sendRedirect("/");
			} 
			
		 }
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("강의 신청 중 발생한 에러입니다.");
		}
		
	}
}
