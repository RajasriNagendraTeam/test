package com.rs.hibernate.onetoone;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEx {

	public static void main(String[] args) {
		System.out.println("Hibernate one to one...");

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		Student st = (Student) session.get(Student.class, 102);

		System.out.println("address id : " + st.getAddress().getAddressId());
		session.delete(st);
		tx.commit();
		System.out.println("Done");
	}
}
