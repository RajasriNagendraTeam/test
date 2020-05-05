package com.mkyong;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mkyong.stock.Product;

public class ClientLogicProgram {

	public static void main(String... args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Session session1 = factory.openSession();

		Product p = null; // Transient state..
		Object o = session1.get(Product.class, new Integer(106));
		p = (Product) o; // now p is in Persistent state..

		session1.close();

		p.setPrice(360); // p is in Detached state

		Session session2 = factory.openSession();

		Transaction tx = session2.beginTransaction();
		session2.update(p); // now p reached to Persistent state
		tx.commit();

		session2.close();

		factory.close();
	}
}
