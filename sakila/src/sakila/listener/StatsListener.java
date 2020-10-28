package sakila.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import sakila.service.StatsService;

@WebListener
public class StatsListener implements HttpSessionListener { // ������ �����Ǵ� ���� ����
	private StatsService statsService;
    public StatsListener() {

    }

    public void sessionCreated(HttpSessionEvent se)  { // ������ �����Ǿ������� �̺�Ʈ�� ���� Ȯ�� ����
    	if(se.getSession().isNew()) { // ���ο� ������ �����Ǿ��� ��
    		statsService = new StatsService();
    		statsService.countStats();
    	}
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 

    }
	
}
