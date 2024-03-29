package edu.kh.toy.register.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.toy.register.model.dto.Register;
import edu.kh.toy.register.model.service.RegisterService;
import edu.kh.toy.student.model.dto.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/dropClass")
public class DropController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			
		HttpSession session = req.getSession();
		
		Student student = (Student) session.getAttribute("loginStudent");
			
		String regNo = req.getParameter("regNo");
		
		RegisterService service = new RegisterService();
		
		int result = service.dropClass(regNo);
		
		if(result >0) {
			List<Register> regList = service.selectAll(student.getStudentNo());
			session.setAttribute("regList", regList);
		} else {
			session.setAttribute("message", "삭제 실패");
		}
		
		resp.sendRedirect(req.getHeader("referer"));
		
		} catch(Exception e) {
			System.out.println("강의 삭제 중 발생하는 예외입니다");
			e.printStackTrace();
			
		}
	}
}
