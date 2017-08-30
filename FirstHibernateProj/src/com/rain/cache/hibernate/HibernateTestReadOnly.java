package com.rain.cache.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rain.cache.dto.Vehicle;

public class HibernateTestReadOnly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("xxx");
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
		
		
		session = factory.openSession();
		session.beginTransaction();
		Vehicle vehicle1 = (Vehicle) session.get(Vehicle.class, 1);
		Vehicle vehicle2 = (Vehicle) session.get(Vehicle.class, 1);
		session.getTransaction().commit();
		session.close();
		
		session = factory.openSession();
		session.beginTransaction();
		Vehicle vehicle3 = (Vehicle) session.get(Vehicle.class, 1);
		session.getTransaction().commit();
		session.close();
		
		session = factory.openSession();
		session.beginTransaction();
		Vehicle vehicle4 = (Vehicle) session.get(Vehicle.class, 1);
		vehicle4.setVehicleName("ggggggggg");
		session.getTransaction().commit();
		session.close();
		
		
		session = factory.openSession();
		session.beginTransaction();
		vehicle4.setVehicleName("bbbbbbbbbbbbbbbb");
		session.update(vehicle4);
		session.getTransaction().commit();
		session.close();
		
		session = factory.openSession();
		session.beginTransaction();
		Vehicle vehicle5 = (Vehicle) session.get(Vehicle.class, 1);
		System.out.println(vehicle5.getVehicleName());
		session.getTransaction().commit();
		session.close();
		System.out.println("=====");
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Vehicle vehicle where vehicle.vehicleId=1");
		query.setCacheable(true);
		List<Vehicle> list = query.list();
		System.out.println(vehicle5.getVehicleName()+"=====");
		session.getTransaction().commit();
		session.close();
		
		session = factory.openSession();
		session.beginTransaction();
		Query query2 = session.createQuery("from Vehicle vehicle where vehicle.vehicleId=1");
		query2.setCacheable(true);
		List<Vehicle> list2 = query2.list();
		System.out.println(vehicle5.getVehicleName()+"---");
		session.getTransaction().commit();
		session.close();
	}

}
