package sakila.dao;

import java.sql.*;
import java.sql.PreparedStatement;

import sakila.query.StaffQuery;
import sakila.vo.Staff;
import sakila.vo.StaffInfo;

public class StaffDao {
	public Staff selectStaffByKey(Connection conn, Staff staff) throws Exception{
		System.out.println("debug : selectStaffByKey 실행"); // 실행되는지 확인
		Staff returnStaff = null;
		PreparedStatement stmt = conn.prepareStatement(StaffQuery.SELECT_STAFF_BY_KEY);
		stmt.setString(1, staff.getEmail());
		stmt.setString(2, staff.getPassword());
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			returnStaff = new Staff();
			returnStaff.setEmail(rs.getString("email"));
			System.out.println("debug : staffId(" + rs.getString("email") + ")"); // staff_id값 확인
			returnStaff.setUserName(rs.getString("username"));
			System.out.println("debug : userName(" + rs.getString("username") + ")"); // username값 확인
		}
		stmt.close();
		rs.close();
		return returnStaff;
	}
}
