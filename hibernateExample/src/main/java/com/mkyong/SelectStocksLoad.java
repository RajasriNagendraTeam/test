package com.mkyong;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mkyong.stock.Stock;

public class SelectStocksLoad {
	public static void main(String[] args) {
		System.out.println("Hibernate one to many (XML Mapping)");

		// 1. Configure the configuration object
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// 2. Get the session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// 3. Create or open session by using session factory
		Session session = sessionFactory.openSession();

		Stock stock = (Stock) session.load(Stock.class, 22);
		if (stock != null) {
			System.out.println(stock.getStockId() + ", " + stock.getStockCode() + " and " + stock.getStockName());
		}

		stock = (Stock) session.load(Stock.class, 22);
		if (stock != null) {
			System.out.println(stock.getStockId() + ", " + stock.getStockCode() + " and " + stock.getStockName());
		}

		System.out.println("Done");
	}
}
