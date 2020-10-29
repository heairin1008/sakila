package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sakila.query.StaffQuery;
import sakila.vo.StaffInfo;

public class StaffInfoDao {
	public StaffInfo selectStaffInfo(Connection conn, StaffInfo staffInfo) throws Exception{
		System.out.println("debug : selectStaffInfo 실행");
		StaffInfo returnInfo = null;
		PreparedStatement stmt = conn.prepareStatement(StaffQuery.SELECT_STAFF_INFO);
		stmt.setInt(1, staffInfo.getStaffId());
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			returnInfo = new StaffInfo();
			returnInfo.setUserName(rs.getString("staff.username"));
			System.out.println("debug : username(" + rs.getString("staff.username") + ")");
			returnInfo.setFullName(rs.getString("v.name"));
			System.out.println("debug : fullname(" + rs.getString("v.name") + ")");
			returnInfo.setPhone(rs.getString("v.phone"));
			System.out.println("debug : phone(" + rs.getString("v.phone") +")");
			returnInfo.setAddress(rs.getString("v.address"));
			System.out.println("debug : address(" + rs.getString("v.address") +")");
			returnInfo.setCity(rs.getString("v.city"));
			System.out.println("debug : city(" + rs.getString("v.city") +")");
			returnInfo.setCountry(rs.getString("v.country"));
			System.out.println("debug : country(" + rs.getString("v.country") +")");
			returnInfo.setEmail(rs.getString("staff.email"));
			System.out.println("debug : email(" + rs.getString("v.email") +")");
		}
		stmt.close();
		rs.close();
		
		return returnInfo;
	}
}
