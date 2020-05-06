package com.rs.hibernate.onetooneannotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneLogic {
	public static void main(String args[]) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Student s = new Student();
		s.setStudentId(101);
		s.setStudentName("Venu");
		s.setGrp("MPC");

		Address ad = new Address();
		ad.setAddressId(1);
		ad.setPlace("AP");

		ad.setParent(s);
		Transaction tx = session.beginTransaction();
		session.save(ad);
		tx.commit();
		session.close();
		System.out.println("One to One with annotations is done..!!!!");
		factory.close();
	}
}