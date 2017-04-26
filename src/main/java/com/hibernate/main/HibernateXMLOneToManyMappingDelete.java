package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Cart;
import com.hibernate.util.HibernateUtil;

public class HibernateXMLOneToManyMappingDelete {
	public static void main(String[] args) {

		// Deleting Single Parent Object(Cart) With All Child's(Item)
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;

		// Get Session
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.getCurrentSession();
		System.out.println("Session created");
		// start transaction
		tx = session.beginTransaction();

		Cart cart = (Cart) session.get(Cart.class, 12L);

		// While deleting Cart we have to apply "On Delete Cascade" in Item
		// table.else will get Constraint violation.
		session.delete(cart);
		tx.commit();

		System.out.println("One To Many is Done for deleting..!!");

		sessionFactory.close();
	}

}
