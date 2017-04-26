package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.model.CartAnnotation;
import com.hibernate.util.HibernateAnnotationUtil;

public class HibernateAntnOneToManyMappingGet {
	public static void main(String[] args) {
		// for cart id 15 get all the items

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;

		// Get Session
		sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		session = sessionFactory.getCurrentSession();
		System.out.println("Session created");
		// start transaction
		tx = session.beginTransaction();

		CartAnnotation cart = (CartAnnotation) session.get(
				CartAnnotation.class, 20L);

		System.out.println(cart);
		System.out.println(cart.getItems());

		tx.commit();

		// session.close();//becauee of contextual thread session gets closed
		// due to tx.commit().

		sessionFactory.close();
	}
}
