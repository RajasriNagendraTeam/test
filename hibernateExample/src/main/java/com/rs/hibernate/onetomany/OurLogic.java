package com.rs.hibernate.onetomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OurLogic {

	public static void main(String args[]) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		// parent object
		Vendor v = new Vendor();
		v.setVendorId(101);
		v.setVendorName("java4s");

		// creating 3 child objects
		Customer c1 = new Customer();
		c1.setCustomerId(504);
		c1.setCustomerName("customer4");

		Customer c2 = new Customer();
		c2.setCustomerId(505);
		c2.setCustomerName("customer5");

		Customer c3 = new Customer();
		c3.setCustomerId(506);
		c3.setCustomerName("customer6");

		// adding child objects to set, as we taken 3rd property set in parent
		Set s = new HashSet();
		s.add(c1);
		s.add(c2);
		s.add(c3);

		v.setCustomers(s);

		Transaction tx = session.beginTransaction();

		session.save(v);

		tx.commit();
		session.close();
		System.out.println("One To Many is Done..!!");
		factory.close();

	}
}