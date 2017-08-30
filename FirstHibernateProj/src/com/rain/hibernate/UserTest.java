package com.rain.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rain.dto.Address;
import com.rain.dto.Persion;
import com.rain.dto.Role;
import com.rain.dto.User;
import com.rain.dto.UserDetail;
import com.rain.dto.Vehicle;

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
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		user.setVehicle(vehicle);
		
		Persion p1 = new Persion();
		p1.setPersionName("Xia Ling");
		Persion p2 = new Persion();
		p1.setPersionName("Xia Haoran");
		user.getChildren().add(p1);
		user.getChildren().add(p2);
		p1.setUser(user);
		p2.setUser(user);
		
		Role r1 = new Role();
		r1.setRoleName("r1");
		user.getRoles().add(r1);
		Role r2 = new Role();
		r2.setRoleName("r2");
		user.getRoles().add(r2);
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
		
//		user = null;
//		session = factory.openSession();
//		user = (User)session.get(User.class, 1);
//		session.close();
		//System.out.println(user.getAddressOfList().size());
	}

}
