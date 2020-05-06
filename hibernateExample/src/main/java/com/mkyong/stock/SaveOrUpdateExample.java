package com.mkyong.stock;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveOrUpdateExample {
	
	public static void main(String[] args) {

		System.out.println("Hibernate save() (XML Mapping)");

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Stock stock = new Stock();
		stock.setStockId(106);
		stock.setStockName("cloths");
		stock.setStockCode("123");
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(stock);
		transaction.commit();
		System.out.println("Done");

	}

}
