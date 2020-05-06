package com.mkyong;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mkyong.stock.Product;

public class HQLSelect {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Query query = session.createQuery("from Product p");

		List<Product> products = query.list();
		Iterator<Product> iterator = products.iterator();
		Product product = null;
		while (iterator.hasNext()) {
			product = iterator.next();
			System.out.println(product.getProductId() + ", " + product.getProName() + " and " + product.getPrice());
		}

		session.close();
		factory.close();
	}

}