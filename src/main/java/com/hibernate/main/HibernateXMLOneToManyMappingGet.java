package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.model.Cart;
import com.hibernate.util.HibernateUtil;

public class HibernateXMLOneToManyMappingGet {
	public static void main(String[] args) {
		// for cart id 15 get all the items

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;

		// Get Session
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.getCurrentSession();
		System.out.println("Session created");
		// start transaction
		tx = session.beginTransaction();

		Cart cart = (Cart) session.get(Cart.class, 15L);

		System.out.println(cart);
		System.out.println(cart.getItem());

		tx.commit();

		// session.close();//becauee of contextual thread session gets closed
		// due to tx.commit().

		sessionFactory.close();
	}
}
