package com.rs.hibernate.onetomany;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OurLogic2 {

	public static void main(String args[]) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		// parent object
		Vendor vendor = (Vendor) session.get(Vendor.class, 101);
		System.out.println(vendor.getVendorId()+", "+vendor.getVendorName());
		vendor.setVendorName("vendor2");
		
		Set<Customer> customers = vendor.getCustomers();
		System.out.println("set");
		Iterator<Customer> iterator = customers.iterator();
		System.out.println("iterator");
		
		Customer customer = null;
		while(iterator.hasNext()) {
			customer = iterator.next();
			
			customer.setCustomerName("test2");
		}
		
		System.out.println("Prior to call update");
		Transaction tx = session.beginTransaction();

		session.update(vendor);

		tx.commit();
		session.close();
		System.out.println("One To Many is Done..!!");
		factory.close();

	}
}