package com.mkyong;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.mkyong.stock.Product;

public class AnnotSaveEx {

	public static void main(String[] args) {

		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Product p = new Product();

		p.setProductId(106);
		p.setProName("biles");
		p.setPrice(150);

		Transaction tx = session.beginTransaction();
		session.save(p);
		System.out.println("Object saved successfully using annotations.....!!");
		tx.commit();
		session.close();
		factory.close();
	}

}