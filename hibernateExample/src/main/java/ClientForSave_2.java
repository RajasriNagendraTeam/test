import com.mkyong.*;
import com.mkyong.stock.Product;

import org.hibernate.*;
import org.hibernate.cfg.*;

import java.util.*;

public class ClientForSave_2 {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

	

		/* Using Question Mark */

		Query qry = session.createQuery("from Product p where p.productId= ?");

		qry.setParameter(0, 105);

		List l = qry.list();
		System.out.println("Total Number Of Records : " + l.size());
		Iterator it = l.iterator();

		while (it.hasNext()) {
			Object o = (Object) it.next();
			Product p = (Product) o;
			System.out.println("Product Name : " + p.getProName());
			System.out.println("Product Price : " + p.getPrice());
			System.out.println("---------------------------");

		}

		session.close();
		factory.close();
	}

}