package com.mkyong.stock;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MergeUpdateExample {

	public static void main(String[] args) {

		System.out.println("Hibernate merge() (XML Mapping)");

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Product Product1 = (Product) session.get(Product.class, 106);
		session.close();
		Product1.setProName("bat");
		Session session1 = sessionFactory.openSession();
		Product Product2 = (Product) session1.get(Product.class, 106);
		Transaction tx = session1.beginTransaction();
		session1.merge(Product1);
		tx.commit();
		session1.close();
		System.out.println(Product1.getProductId() + ", " + Product1.getProName());
		System.out.println("Done merge()");
		
	}

}
