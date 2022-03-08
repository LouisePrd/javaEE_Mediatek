import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitListener implements ServletContextListener {
//lancement de projet : charge mediatheque_data -> execture bloc static

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			Class.forName("Mediatheque_Data");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

}