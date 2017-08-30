package com.rain.ineritance.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rain.ineritance.dto.User;
import com.rain.ineritance.dto.Vehicle;
import com.rain.ineritance.dto.FourWheeler;
import com.rain.ineritance.dto.TwoWheeler;

public class UserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User();
		//user.setUserId(1);
		user.setUserName("summer");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setVehicleName("Bike");
		twoWheeler.setSteeringHandler("Bike something handle");
		
		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setVehicleName("Posrc");
		fourWheeler.setSteerWheel("Posrc something handle");
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.save(twoWheeler);
		session.save(fourWheeler);
		session.getTransaction().commit();
		session.close();
		
//		user = null;
//		session = factory.openSession();
//		user = (User)session.get(User.class, 1);
//		session.close();
		//System.out.println(user.getAddressOfList().size());
	}

}
