package com.rs.hibernate.onetomany;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OurLogic3 {

	public static void main(String args[]) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		// parent object
		Vendor vendor = (Vendor) session.get(Vendor.class, 101);
		System.out.println(vendor.getVendorId()+", "+vendor.getVendorName());
		
		
		System.out.println("Prior to call delete");
		Transaction tx = session.beginTransaction();

		session.delete(vendor);

		tx.commit();
		session.close();
		System.out.println("One To Many is Done..!!");
		factory.close();

	}
}