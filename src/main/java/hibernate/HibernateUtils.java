package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import product.Product;

public class HibernateUtils {

	static SessionFactory hibernateSessionFactory;
	
	public static SessionFactory buildSessionFactory() {
		Configuration conf = new Configuration();
		conf.addAnnotatedClass(Product.class);
		conf.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(
						conf.getProperties()
				).build();
		hibernateSessionFactory = conf.buildSessionFactory(serviceRegistryObj);
		
		return hibernateSessionFactory;		
	}
}
