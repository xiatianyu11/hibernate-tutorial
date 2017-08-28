package com.rain.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rain.dto.UserRole;
import com.rain.dto.UserRoleId;

public class UserRoleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserRole userRole = new UserRole();
		UserRoleId id = new UserRoleId();
		id.setRoleId(1);
		id.setUserId(1);
		userRole.setUserRoleId(id);
		userRole.setDescription("description");
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(userRole);
		session.getTransaction().commit();
		session.close();
	}

}
