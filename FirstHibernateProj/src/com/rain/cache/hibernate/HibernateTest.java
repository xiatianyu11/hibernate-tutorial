package com.rain.cache.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rain.cache.dto.User;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session1 = factory.openSession();
			Session session2 = factory.openSession();
			User user1 = (User) session1.get(User.class, 1);
			User user2 = (User) session2.get(User.class, 1);
			System.out.println(user1.getVersion());
			System.out.println(user2.getVersion());
			
			
			
			Transaction tx1 = session1.beginTransaction();
			user1.setUserName("bbb");
			session1.update(user1);
			tx1.commit();
			session1.close();
			System.out.println(user1.getVersion() + "---");
			System.out.println(user2.getVersion());
			
			
			Transaction tx2 = session2.beginTransaction();
			user2.setUserName("dddd");
			session2.update(user2);
			//session2.delete(user2);
			tx2.commit();
			
			System.out.println(user1.getVersion());
			System.out.println(user2.getVersion());
			
			
			
			session2.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
