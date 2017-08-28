package com.rain.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rain.dto.Address;
import com.rain.dto.User;
import com.rain.dto.UserDetail;

public class UserTest {

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
		user.getAddressOfList().add(address);
		
		Address officeAddress = new Address();
		officeAddress.setStreet("office st");
		officeAddress.setCity("st");
		officeAddress.setPincode("123");
		officeAddress.setState("China");
		user.getAddressOfList().add(officeAddress);
		
		user.setCnUserDetail(new UserDetail("xia", "1223"));
		user.setEnUserDetail(new UserDetail("tian", "345"));
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		session = factory.openSession();
		user = (User)session.get(User.class, 1);
		session.close();
		System.out.println(user.getAddressOfList().size());
	}

}
