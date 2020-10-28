package sakila.service;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import sakila.dao.StatsDao;
import sakila.util.DBUtil;
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
	
	public Map<String, Object> getStats() {
		Stats returnStats = null; // 당일 방문자 수 
		int totalStats = 0; // 총 방문자 수 
		Map<String, Object> map = null;
		map = new HashMap<String, Object>(); // service에서 값을 두 개 이상을 보내기 위해 map 사용
		statsDao = new StatsDao();
		Connection conn = null;
		try {
			DBUtil dbUtil = new DBUtil(); // DB Connection 호출
			conn = dbUtil.getConnection();
			conn.setAutoCommit(false); // conn이 자동적으로 commit되는걸 막음
			
			Stats stats = this.getToday();
			
			returnStats = statsDao.selectDay(conn, stats);
			totalStats = statsDao.selectTotalDay(conn, stats);
			
			if(returnStats != null) { //returnStats값이 있을 경우 updateStats실행
				statsDao.updateStats(conn, stats);
			}else { // returnStats값이 비어있을 경우 insertStats 실행
				statsDao.insertStats(conn, stats);
			}
			
			map.put("returnStats", returnStats); // map에 당일 방문자 수 입력
			map.put("totalStats", totalStats); // map에 총 방문자 수 입력
			
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
		return map;
	}
	
	public void countStats() {
		statsDao = new StatsDao();

		Connection conn = null;
		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			conn.setAutoCommit(false);
			
			Stats stats = this.getToday();
			
			if(statsDao.selectDay(conn, stats) == null) { // 당일 방문자 수가 0일 때
				statsDao.insertStats(conn, stats);
			}else { // 당일 방문자 수가 1 이상일 때
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
