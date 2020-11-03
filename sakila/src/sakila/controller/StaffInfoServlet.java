package sakila.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sakila.service.StaffInfoService;
import sakila.vo.Staff;
import sakila.vo.StaffInfo;

/**
 * Servlet implementation class StaffInfoServlet
 */
@WebServlet("/auth/StaffInfoServlet")
public class StaffInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		StaffInfo staffInfo = new StaffInfo();
		StaffInfoService staffInfoService = new StaffInfoService();
		
		Staff staff = (Staff)session.getAttribute("loginStaff");
		System.out.println("debug : session 정보 객체 저장" + staff);
		staffInfo.setStaffId(staff.getStaffId());
		
		StaffInfo returnInfo = staffInfoService.getStaffInfo(staffInfo);
		System.out.println("staffId : " + returnInfo);
		
		if(returnInfo != null) {
			request.setAttribute("staffInfo", returnInfo);
		}
		request.getRequestDispatcher("/WEB-INF/views/auth/staffInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
