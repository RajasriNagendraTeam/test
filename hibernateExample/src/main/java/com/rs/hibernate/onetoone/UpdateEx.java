package com.rs.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateEx {

	public static void main(String[] args) {
		System.out.println("Hibernate one to one ");

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Student st = (Student) session.get(Student.class, 100);

		System.out.println(st.getStudentId() + ", " + st.getStudentName());
		System.out.println("prior to address");
		System.out.println(
				st.getAddress().getAddressId() + ", " + st.getAddress().getCity() + ", " + st.getAddress().getState());
		st.setStudentName("rohit");
		st.getAddress().setCity("bezawada");
		session.save(st);
		transaction.commit();
		System.out.println("Done");
	}
}
