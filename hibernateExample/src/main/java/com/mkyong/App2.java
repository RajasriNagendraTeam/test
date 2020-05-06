package com.mkyong;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mkyong.stock.Stock;

public class App2 {
	public static void main(String[] args) {
		System.out.println("Hibernate one to many (XML Mapping)");

		// 1. Configure the configuration object
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// 2. Get the session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// 3. Create or open session by using session factory
		Session session = sessionFactory.openSession();

		// 4. Open Transaction
		Transaction transaction = session.beginTransaction();

		// 1. Transient: Object is not associated with the session
		Stock stock = null;

		// 2. Persistent: Object had association with the session.
		stock = (Stock) session.get(Stock.class, 2);

		session.close();

		// 3. Detached: Object had association with the session previously but not now
		stock.setStockName("RAJA");

		session = sessionFactory.openSession();
		transaction = session.beginTransaction();

		// 2. Persistent: Object had association with the session.
		session.update(stock);

		transaction.commit();

		System.out.println("Done");
	}
}
