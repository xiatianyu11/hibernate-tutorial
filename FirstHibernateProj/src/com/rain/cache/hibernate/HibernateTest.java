package com.rain.cache.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rain.cache.dto.User;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserName("xxx");
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		
		session = factory.openSession();
		session.beginTransaction();
		User user1 = (User) session.get(User.class, 1);
		User user2 = (User) session.get(User.class, 1);
		System.out.println(user2.getUserName());
		session.getTransaction().commit();
		session.close();
		
		session = factory.openSession();
		session.beginTransaction();
		User user3 = (User) session.get(User.class, 1);
		System.out.println(user2.getUserName());
		session.getTransaction().commit();
		session.close();
		
		
	}

}
