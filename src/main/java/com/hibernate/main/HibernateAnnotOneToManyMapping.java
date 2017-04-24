package com.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.model.CartAnnotation;
import com.hibernate.model.ItemsAnnotation;
import com.hibernate.util.HibernateAnnotationUtil;

public class HibernateAnnotOneToManyMapping {
	public static void main(String[] args) {
		CartAnnotation cart = new CartAnnotation();
		cart.setName("MyCart1");

		ItemsAnnotation item1 = new ItemsAnnotation("I10", 100, 1, cart);
		ItemsAnnotation item2 = new ItemsAnnotation("I20", 200, 2, cart);
		Set<ItemsAnnotation> itemsSet = new HashSet<ItemsAnnotation>();
		itemsSet.add(item1);
		itemsSet.add(item2);

		cart.setItems(itemsSet);
		cart.setTotal(100 * 1 + 200 * 2);

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			// Get Session
			sessionFactory = HibernateAnnotationUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			System.out.println("Session created");
			// start transaction
			tx = session.beginTransaction();
			// Save the Model object
			session.save(cart);
			
			// commenting below 2 lines while using cascade="save-update"
			//session.save(item1);
			//session.save(item2);
			// Commit transaction
			tx.commit();
			System.out.println("Cart1 ID=" + cart.getId());
			System.out.println("item1 ID=" + item1.getId()
					+ ", Foreign Key Cart ID=" + item1.getCart().getId());
			System.out.println("item2 ID=" + item2.getId()
					+ ", Foreign Key Cart ID=" + item2.getCart().getId());

		} catch (Exception e) {
			System.out.println("Exception occured. " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (!sessionFactory.isClosed()) {
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}
	}

}
