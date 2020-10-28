package sakila.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import sakila.service.StatsService;

@WebListener
public class StatsListener implements HttpSessionListener { // 세션이 생성되는 것을 감지
	private StatsService statsService;
    public StatsListener() {

    }

    public void sessionCreated(HttpSessionEvent se)  { // 세션이 생성되었는지를 이벤트를 통해 확인 가능
    	if(se.getSession().isNew()) { // 새로운 세션이 생성되었을 때
    		statsService = new StatsService();
    		statsService.countStats();
    	}
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 

    }
	
}
