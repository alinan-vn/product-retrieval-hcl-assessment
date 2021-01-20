import product.Product;
import robot.RobotEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import hibernate.HibernateUtils;
import product.Product;

public class App {

	static Session hibernateSession;
	
	static List<String> names = Arrays.asList(
			"XX-PO2-LL30", "AZ-JK9-OO99", "GK-KS8-PP23", 
			"ZZ-TO6-BB33", "UI-LK9-JS09", "ML-KJ6-LM88",
			"JJ-KO9-AF29", "DF-AF1-DJ49", "DJ-AK4-LH05"
	);
	
	static List<String> types = Arrays.asList(
			"TOY", "EQUIPMENT", "TOOL", "SCIENCE",
			"ENERGY", "NATURAL GAS", "AERONAUTICS",
			"AEROSPACE", "EDUCATION"
	);
	
	public static void main(String[] args) {
		
//		Random rand = new Random();
//		String randomName = names.get(rand.nextInt(names.size()));
//		System.out.println(randomName);
		
		try {
//			hibernateSession = HibernateUtils
//					.buildSessionFactory()
//					.openSession();
//			hibernateSession.beginTransaction();
			
			// Insert some products
			for (int i = 0; i <= 10; i++) {
				Random rand = new Random();
				String randomName = names.get(rand.nextInt(names.size()));
				String randomType = types.get(rand.nextInt(types.size()));
				long leftLim = 1L;
				long rightLim = 100000L;
				long randomPrice = leftLim + (long) (Math.random() * (rightLim - leftLim));
				
				Product product = new Product();
				product.setName(randomName);
				product.setType(randomType);
				product.setPrice(randomPrice);
				
				hibernateSession.save(product);
			}
			
			// Get all products
			CriteriaBuilder builder = hibernateSession.getCriteriaBuilder();
			CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
			criteria.from(Product.class);
			List<Product> products = hibernateSession.createQuery(criteria).getResultList();			
			
			products.forEach((p) -> System.out.println(
                    "p: " + p.getId() +
                            " name:" + p.getName() +
                            " weight:" + p.getPrice()
            ));
			
			hibernateSession.getTransaction().commit();
			
		} catch (Exception sqlException) {
			if (null != hibernateSession.getTransaction()) {
				hibernateSession.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (hibernateSession != null) {
				hibernateSession.close();
			}
		}
	}
	
}



























