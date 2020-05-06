package com.mkyong;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mkyong.stock.Stock;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate one to many (XML Mapping)");

		//1. Configure the configuration object
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		//2. Get the session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		//3. Create or open session by using session factory
		Session session = sessionFactory.openSession();

		//4. Open Transaction
		Transaction transaction = session.beginTransaction();

		Stock stock = new Stock();
		stock.setStockCode("7051");
		stock.setStockName("Admin");
		
		//5. Call method which is in session to persist the data
		session.save(stock);

		//6. Call commit to persist into DB
		transaction.commit();
		
		System.out.println("Done");
	}
}
