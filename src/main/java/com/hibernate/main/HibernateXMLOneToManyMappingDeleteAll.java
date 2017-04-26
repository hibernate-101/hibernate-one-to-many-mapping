package com.hibernate.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.model.Cart;
import com.hibernate.util.HibernateUtil;

public class HibernateXMLOneToManyMappingDeleteAll {
	public static void main(String[] args) {
		// Deleting All Parent Objects(Cart) With All Child's(Item)
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;

		// Get Session
		sessionFactory = HibernateUtil.getSessionFactory();
		// session = sessionFactory.openSession();
		session = sessionFactory.getCurrentSession();
		System.out.println("Session created");

		Query query = session.createQuery("From Cart");
		List cart = query.list();
		Iterator itr = cart.iterator();

		tx = session.beginTransaction();
		while (itr.hasNext()) {
			Cart c = (Cart) itr.next();
			session.delete(c);

		}

		tx.commit();

		System.out
				.println("One To Many is Done for deleting all parents with childs...!");
		sessionFactory.close();

	}

}
