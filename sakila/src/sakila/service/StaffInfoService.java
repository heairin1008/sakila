package sakila.service;

import java.sql.Connection;
import java.sql.SQLException;

import sakila.dao.StaffInfoDao;
import sakila.util.DBUtil;
import sakila.vo.StaffInfo;

public class StaffInfoService {
	private StaffInfoDao staffInfoDao;
	
	public StaffInfo getStaffInfo(StaffInfo staffInfo) {
		StaffInfo returnInfo = null;
		staffInfoDao = new StaffInfoDao();
		Connection conn = null;
		
		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			conn.setAutoCommit(false);
			
			returnInfo = staffInfoDao.selectStaffInfo(conn, staffInfo);
			
			conn.commit();
		}catch (Exception e) {
			try {
				conn.rollback();
			}catch (SQLException e1) {
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
		
		return returnInfo;
	}
}
