package com.rs.hibernate.manytoone;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SelectAllEx {

	public static void main(String args[]) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Query qry = session.createQuery("from Customer c");

		List l = qry.list();
		Iterator it = l.iterator();
		while (it.hasNext())

		{

			Object o = it.next();

			Customer c = (Customer) o;

			System.out.println(c.getCustomerName());

			Vendor v = c.getParentObjects();

			System.out.println(v.getVendorName());

		}

		session.close();
		System.out.println("many to one select done..!!");
		factory.close();

	}
}