package com.mkyong;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mkyong.stock.Product;

public class HQLSelect2 {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Query query = session.createQuery("select p.productId from Product p");

		List<Integer> productIds = query.list();
		Iterator<Integer> iterator = productIds.iterator();
		Integer productId = null;
		while (iterator.hasNext()) {
			productId = iterator.next();
			System.out.println(productId);
		}

		session.close();
		factory.close();
	}

}