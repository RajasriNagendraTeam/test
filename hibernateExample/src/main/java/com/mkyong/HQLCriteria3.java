package com.mkyong;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.mkyong.stock.Product;
import com.mkyong.stock.Stock;

public class HQLCriteria3 {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Stock.class);
		
		ProjectionList p1=Projections.projectionList();
        p1.add(Projections.property("stockId"));
        p1.add(Projections.property("stockCode"));	
        criteria.setProjection(p1);		

		List<Object[]> stocks = criteria.list();
		Iterator<Object[]> iterator = stocks.iterator();
		Object[] stockArr = null;
		while (iterator.hasNext()) {
			stockArr = iterator.next();
			System.out.println(stockArr[0]+" and "+stockArr[1]);
		}

		session.close();
		factory.close();
	}

}