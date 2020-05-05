package com.mkyong;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.mkyong.stock.Product;
import com.mkyong.stock.Stock;

public class HQLCriteria4 {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Stock.class);
		
		criteria.add(Restrictions.ne("stockId", 334554));
		
		criteria.addOrder(Order.asc("stockId"));
		
		criteria.setFirstResult(3);
		criteria.setMaxResults(3);
		
		List<Stock> stocks = criteria.list();
		Iterator<Stock> iterator = stocks.iterator();
		Stock stock = null;
		while (iterator.hasNext()) {
			stock = iterator.next();
			System.out.println(stock.getStockId() + ", " + stock.getStockCode() + " and " + stock.getStockName());
		}

		session.close();
		factory.close();
	}

}