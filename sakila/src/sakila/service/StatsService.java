package sakila.service;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import sakila.dao.StatsDao;
import sakila.vo.Stats;

public class StatsService {
	private StatsDao statsDao;
	// 오늘의 방문자 수 dao메서드 호출 Stats + 총 방문자 수 dao메서드 호출 int -> Map
	public Stats getToday() { // 오늘 날짜 구하는 메서드
		Calendar today = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		String day = formater.format(today.getTime());
		Stats stats = new Stats();
		stats.setDay(day);
		return stats;
	}
	
	public Stats getStats() {
		Stats returnStats = null;
		statsDao = new StatsDao();
		final String URL= "jdbc:mariadb://localhost:3306/sakila";
		final String USER = "root";
		final String PASSWORD = "java1004";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false); // conn이 자동적으로 commit되는걸 막음
			
			Stats stats = this.getToday();
			
			returnStats = statsDao.selectDay(conn, stats);
			if(returnStats != null) { //returnStats값이 있을 경우 updateStats실행
				statsDao.updateStats(conn, stats);
			}else { // returnStats값이 비어있을 경우 insertStats 실행
				statsDao.insertStats(conn, stats);
			}
			conn.commit();
		}catch (Exception e) {
			try { // 예외 발생 시 rollback
				conn.rollback();
			}catch (SQLException e1){
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally { // 무조건 실행
			try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return returnStats;
	}
	
	public void countStats() {
		statsDao = new StatsDao();
		final String URL= "jdbc:mariadb://localhost:3306/sakila";
		final String USER = "root";
		final String PASSWORD = "java1004";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false); // conn이 자동적으로 commit되는걸 막음
			//
			Stats stats = this.getToday();
			
			if(statsDao.selectDay(conn, stats) == null) {
				statsDao.insertStats(conn, stats);
			}else {
				statsDao.updateStats(conn, stats);
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
