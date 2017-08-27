package com.rain.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rain.dto.Address;
import com.rain.dto.User;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User();
		//user.setUserId(1);
		user.setUserName("summer");
		Address address = new Address();
		address.setStreet("st");
		address.setCity("xx");
		address.setPincode("123");
		address.setState("China");
		user.setAddress(address);
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

}
