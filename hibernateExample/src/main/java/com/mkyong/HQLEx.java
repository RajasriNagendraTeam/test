package com.mkyong;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class HQLEx {

	public static void main(String[] args)
	{

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();		

	        Query qry = session.createQuery("delete from Product p where p.proName=:iphone");
	      //  qry.setParameter("iphone",101);
	        int res = qry.executeUpdate();

	        System.out.println("Command successfully executed....");
	        System.out.println("Numer of records effected due to delete query"+res);

			Transaction tx = session.beginTransaction();
			// session.update(u); // now p reached to Persistent state
			tx.commit();
		session.close();
		factory.close();
	}

}
