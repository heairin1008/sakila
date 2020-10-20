package sakila.dao;

import java.sql.Connection;
import sakila.vo.Stats;

public class StatsDao {
	// 오늘 날짜에 방문자가 있는지(insert을 사용해야하는지 update를 사용해야하는지) 판단
	// 방문자가 있으면 true, 없으면 false 출력
	public Stats selectDay(Connection conn, Stats stats) throws Exception{
		Stats returnStats = null;
		
		/*if(rs.next()) {
			returnStats = new Stats();
			// .....
		}
		*/
		
		return returnStats; // false -> 방문자가 없으면 insert 실행
	}
	
	// 방문자수 카운트 첫 방문자 
	public void insertStats(Connection conn, Stats stats) throws Exception{
		
	}
	
	// 방문자수 카운트 추가
	public void updateStats(Connection conn) throws Exception{
		
	}
}
