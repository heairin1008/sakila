package sakila.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sakila.service.StaffService;
import sakila.service.StatsService;
import sakila.vo.Staff;
import sakila.vo.Stats;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private StatsService statsService;
	private StaffService staffService;
	// 로그인 폼으로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginStaff") != null) { // 로그인 세션값이 있다면 인덱스 페이지로 이동
			response.sendRedirect(request.getContextPath() + "/auth/IndexServlet");
			return;
		}
		statsService = new StatsService();
		
		Map<String, Object> map = statsService.getStats();
		request.setAttribute("map", map);
		
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	// 로그인 액션으로 이동
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		staffService = new StaffService();
		Staff staff = new Staff(); 
		// login.jsp에서 id / password값 받아오기
		String staffId = request.getParameter("id");
		String password = request.getParameter("password");
		// staff에 id / password값 넣기
		staff.setEmail(staffId);
		staff.setPassword(password);
		Staff returnStaff = staffService.getStaffByKey(staff);
		
		if(returnStaff != null) {
			String userName = returnStaff.getUserName();
			
			request.setAttribute("staffId", staffId);
			request.setAttribute("userName", userName);
			
			//session
			HttpSession session = request.getSession();
			session.setAttribute("loginStaff", userName);
			response.sendRedirect(request.getContextPath() + "/auth/IndexServlet");
			// session담고 IndexServlet 포워딩
			System.out.println("로그인 성공");
			return;
		}
		response.sendRedirect(request.getContextPath() + "/LoginServlet");
	}

}
