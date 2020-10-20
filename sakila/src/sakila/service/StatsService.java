package sakila.service;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import sakila.dao.StatsDao;
import sakila.vo.Stats;

public class StatsService {
	private StatsDao statsDao;
	public void countStats() {
		statsDao = new StatsDao();
		final String URL= "";
		final String USER = "root";
		final String PASSWORD = "java1004";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false); // conn이 자동적으로 commit되는걸 막음
			//
			Calendar today = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
			String day = formater.format(today);
			Stats stats = new Stats();
			stats.setDay(day);
			
			if(statsDao.selectDay(conn, stats)) {
				statsDao.updateStats(conn);
			}else {
				statsDao.insertStats(conn, stats);
			}
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
	}
}
