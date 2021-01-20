import org.hibernate.Session;
import hibernate.HibernateUtils;

public class App {

	static Session hibernateSession;
	
	public static void main(String[] args) {
		
		try {
			hibernateSession = HibernateUtils
					.buildSessionFactory()
					.openSession();
		}
	}
	
}
