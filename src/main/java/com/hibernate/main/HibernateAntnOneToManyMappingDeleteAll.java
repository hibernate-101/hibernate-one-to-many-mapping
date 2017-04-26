package com.hibernate.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.model.Cart;
import com.hibernate.model.CartAnnotation;
import com.hibernate.util.HibernateAnnotationUtil;

public class HibernateAntnOneToManyMappingDeleteAll {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;

		// Get Session
		sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		session = sessionFactory.openSession();
		System.out.println("Session opened");
		Query query = session.createQuery("From CartAnnotation");
		List cart = query.list();
		Iterator itr = cart.iterator();
		// start transaction
		tx = session.beginTransaction();
		while (itr.hasNext()) {
			CartAnnotation c = (CartAnnotation) itr.next();
			session.delete(c);
		}

		tx.commit();
		session.close();
		System.out
				.println("One To Many is Done for deleting all parents with childs...!");
		sessionFactory.close();

	}

}
