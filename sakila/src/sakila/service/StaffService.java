package sakila.service;

import java.sql.Connection;
import java.sql.SQLException;

import sakila.dao.StaffDao;
import sakila.util.DBUtil;
import sakila.vo.Staff;

public class StaffService {
	private StaffDao staffDao;
	
	public Staff getStaffByKey(Staff staff) {
		Staff returnStaff = null;
		staffDao = new StaffDao();
		Connection conn = null;
		
		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			conn.setAutoCommit(false); // connection이 자동으로 commit되지 않게 막아줌
			
			returnStaff = staffDao.selectStaffByKey(conn, staff); // id / username값을 넣어줌

			conn.commit();
		}catch (Exception e) {
			try {
				conn.rollback();
			}catch (SQLException e1){
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return returnStaff;
	}
}
