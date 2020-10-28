package sakila.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DBListener implements ServletContextListener {

    public DBListener() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent sce)  { 
        System.out.println("DBListener.contextInitialized() ����");
        try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("mariadb ����̺�ε� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("Class.forName() ���� ����");
			e.printStackTrace();
		}
   }
	
}
