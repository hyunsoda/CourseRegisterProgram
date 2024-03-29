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

@WebServlet("/searchPw")
public class SearchPwController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/searchPw.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String inputNo = req.getParameter("inputNo");
			String inputMajor = req.getParameter("inputMajor");
			
			StudentService service = new StudentService();
			Student student = service.searchPw(inputNo, inputMajor);
					
			HttpSession session = req.getSession();
			
			if(student != null) {
				session.setAttribute("searchId", student);
				
				req.getRequestDispatcher("/WEB-INF/views/searchId2.jsp").forward(req, resp);
				
			} else {
				session.setAttribute("message", "찾으시는 정보가 없습니다.");
				String referer = req.getHeader("referer");
				resp.sendRedirect(referer);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("비밀번호 찾기 도중 발생한 에러");
		}
		
		
		
		
		
		
	}
	
}
