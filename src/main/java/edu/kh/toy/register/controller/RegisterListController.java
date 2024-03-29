package edu.kh.toy.register.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.processing.SupportedSourceVersion;

import edu.kh.toy.register.model.dto.Register;
import edu.kh.toy.register.model.service.RegisterService;
import edu.kh.toy.student.model.dto.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/registerList")
public class RegisterListController extends HttpServlet{
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
		
		RegisterService service = new RegisterService();
	
		HttpSession session = req.getSession();
		Student student = (Student)session.getAttribute("loginStudent");
		
		List<Register> regList = service.selectAll(student.getStudentNo());
		
		if(regList != null) {
			session.setAttribute("regList", regList);
			
			req.getRequestDispatcher("/WEB-INF/views/registerList.jsp").forward(req, resp);
			
			
			
		} else {
			session.setAttribute("message", "신청한 강의가 없습니다");
			resp.sendRedirect(req.getHeader("referer"));
		}
		
		 
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("수강신청 완료 목록 조회 중 발생한 에러");
			}
		
	}
	
}
