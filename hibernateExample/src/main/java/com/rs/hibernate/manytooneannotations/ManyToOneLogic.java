package com.rs.hibernate.manytooneannotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class ManyToOneLogic {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Vendor v = new Vendor();

		v.setVendorId(101);
		v.setVendorName("java6s");

		Customers c1 = new Customers();

		c1.setCustomerId(501);
		c1.setCustomerName("customer1");
		c1.setParent(v);

		Customers c2 = new Customers();

		c2.setCustomerId(502);
		c2.setCustomerName("customer2");
		c2.setParent(v);

		Customers c3 = new Customers();

		c3.setCustomerId(503);
		c3.setCustomerName("customer3");
		c3.setParent(v);

		Transaction tx = session.beginTransaction();

		// session.save(v);
		session.save(c2);
		session.save(c2);
		session.save(c3);

		tx.commit();
		session.close();
		System.out.println("Many to One with annotation done...!!");
		factory.close();

	}

}
