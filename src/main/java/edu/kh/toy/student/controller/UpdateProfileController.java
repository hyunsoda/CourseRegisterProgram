package edu.kh.toy.student.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.toy.classes.model.dto.Cls;
import edu.kh.toy.classes.model.service.ClassService;
import edu.kh.toy.register.model.dto.Register;
import edu.kh.toy.register.model.service.RegisterService;
import edu.kh.toy.student.model.dto.Student;
import edu.kh.toy.student.model.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updateProfile")
public class UpdateProfileController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/updateProfile.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			
			String newMajor = req.getParameter("newMajor");
			Student std = (Student) session.getAttribute("loginStudent");
			
			StudentService service = new StudentService();
			
			int result = service.updateProfile(std, newMajor);
			
			if(result > 0) {
				// session.setAttribute("message", "수정이 완료되었습니다. \n 다시 로그인해주세요");
				RegisterService rservice = new RegisterService();
				
				String loginId = ((Student)session.getAttribute("loginStudent")).getStudentId();
				String loginPw = ((Student)session.getAttribute("loginStudent")).getStudentPw();
				
				Student loginStudent = service.login(loginId, loginPw);
				
				session.setAttribute("loginStudent", loginStudent);
				
				List<Register> regList = rservice.selectAll(std.getStudentNo());
				session.setAttribute("regList", regList);
				
				
				
				ClassService clsService = new ClassService();
				List<Cls> classList = clsService.selectAll(loginStudent.getMajor());
				session.setAttribute("classList", classList);
				
				
				session.setAttribute("message", "수정이 완료되었습니다");
				resp.sendRedirect("/");
				
//				if(regList != null) {
//					
//					
//					req.getRequestDispatcher("/WEB-INF/views/registerList.jsp").forward(req, resp);
//					
//					
//					
//				} else {
//					session.setAttribute("message", "신청한 강의가 없습니다");
//					
//					resp.sendRedirect(req.getHeader("referer"));
//				}
				
				
				
				//session.invalidate();
			
			} else {
				session.setAttribute("message", "수정을 실패하였습니다");
					String referer = req.getHeader("referer");
					resp.sendRedirect(referer);
				
			}
		
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("정보수정 중 발생한 에러");
			
			
		}
	}
	
}
