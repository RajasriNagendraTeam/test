package com.rs.hibernate.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertEx {

	public static void main(String args[]) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Vendor v = new Vendor();

		v.setVendorId(101);
		v.setVendorName("java4s");

		Customer c1 = new Customer();

		c1.setCustomerId(504);
		c1.setCustomerName("customer4");
		c1.setParentObjects(v);

		Customer c2 = new Customer();

		c2.setCustomerId(505);
		c2.setCustomerName("customer5");
		c2.setParentObjects(v);

		Customer c3 = new Customer();

		c3.setCustomerId(506);
		c3.setCustomerName("customer6");
		c3.setParentObjects(v);

		Transaction tx = session.beginTransaction();

		session.save(c1);

		session.save(c2);

		session.save(c3);

		tx.commit();
		session.close();
		System.out.println(" Many to one is Done..!!");
		factory.close();

	}
}