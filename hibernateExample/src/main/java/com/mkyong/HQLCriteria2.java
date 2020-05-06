package com.mkyong;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.mkyong.stock.Product;
import com.mkyong.stock.Stock;

public class HQLCriteria2 {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Stock.class);

		criteria.setProjection(Projections.property("stockId"));
		
		List<Integer> stockIds = criteria.list();
		Iterator<Integer> iterator = stockIds.iterator();
		Integer stockId = null;
		while (iterator.hasNext()) {
			stockId = iterator.next();
			System.out.println(stockId);
		}

		session.close();
		factory.close();
	}

}