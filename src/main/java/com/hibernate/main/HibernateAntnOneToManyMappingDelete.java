package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.model.CartAnnotation;
import com.hibernate.util.HibernateAnnotationUtil;

public class HibernateAntnOneToManyMappingDelete {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;

		// Get Session
		sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		session = sessionFactory.getCurrentSession();
		System.out.println("Session created");
		// start transaction
		tx = session.beginTransaction();

		CartAnnotation cart = (CartAnnotation) session.get(CartAnnotation.class, 20L);

		session.delete(cart);

		tx.commit();
		System.out.println("One To Many is Done for deleting..!!");

		sessionFactory.close();
	}

}
