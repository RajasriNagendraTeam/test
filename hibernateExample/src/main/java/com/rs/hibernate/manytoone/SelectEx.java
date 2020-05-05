package com.rs.hibernate.manytoone;

import com.rs.hibernate.manytoone.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SelectEx {

	public static void main(String args[]) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Object o = session.get(Customer.class, new Integer(506));

		Customer c = (Customer) o;

		System.out.println(c.getCustomerName());
		Vendor v = c.getParentObjects();
		System.out.println(v.getVendorName());

		session.close();
		System.out.println("many to one select is done..!!");
		factory.close();

	}
}