package com.mkyong;


import org.hibernate.*;
import org.hibernate.cfg.*;

public class InsertDynamicQuery { 

	public static void main(String[] args)
	{

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();		
        Transaction tx = session.beginTransaction();

Query qry = session.createQuery("insert into Product(productId,proName,price)select i.itemId,i.itemName,i.itemPrice from Items i where i.itemId= ?");

	        qry.setParameter(0,600);
	        int res = qry.executeUpdate();


	        System.out.println("Command successfully executed....");
	        System.out.println("Numer of records effected...,"+res);
			// session.update(u); // now p reached to Persistent state
			tx.commit();
		session.close();
		factory.close();
	}

}
