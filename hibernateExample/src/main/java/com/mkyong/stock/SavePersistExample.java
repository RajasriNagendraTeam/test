package com.mkyong.stock;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SavePersistExample {
	
	public static void main(String[] args) {

		System.out.println("Hibernate save() (XML Mapping)");

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Stock stock = new Stock();
		stock.setStockName("fruits");
		stock.setStockCode("444");
		Transaction transaction = session.beginTransaction();
		 //int id=(int)session.save(stock);
            session.persist(stock);
		// System.out.println("id : "+id);
		transaction.commit();
		System.out.println("Done");

	}

}
