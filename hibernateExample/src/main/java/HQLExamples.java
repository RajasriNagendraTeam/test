import com.mkyong.*;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLExamples {

	public static void main(String[] args)
	{

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();


/* Selecting all objects(records) end________________________ */		


/* Selecting partial objects(More than one object) start__________ */		


	/*	

Query qry = session.createQuery("select p.productId,p.proName from Product p");

		List l =qry.list();
		System.out.println("Total Number Of Records : "+l.size());
		Iterator it = l.iterator();

		while(it.hasNext())
		{
			Object o[] = (Object[])it.next();

			System.out.println("Product id : "+o[0]+ "Product Name : "+o[1]);

			System.out.println("----------------");
		}			

		*/

/* Selecting partial objects(More than one object)end_____________ */				


// Selecting single object start_____________


        Query qry = session.createQuery(
        		"select p.productId from Product p");

		List l =qry.list();
		System.out.println("Total Number Of Records : "+l.size());
		Iterator it = l.iterator();

		while(it.hasNext())
		{
			Integer i = (Integer)it.next();
			System.out.println("Product id : "+i.intValue());
			System.out.println("---------------------------");

		}		

// selecting single object end____________


		session.close();
		factory.close();
	}

}