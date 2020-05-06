package com.mkyong;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mkyong.stock.Product;

public class HQLSelect3 {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Query query = session.createQuery("select p.productId, p.proName from Product p");

		List<Object[]> productIds = query.list();
		Iterator<Object[]> iterator = productIds.iterator();
		Object[] productArr = null;
		while (iterator.hasNext()) {
			productArr = iterator.next();
			System.out.println(productArr[0]+", "+productArr[1]);
		}

		session.close();
		factory.close();
	}

}