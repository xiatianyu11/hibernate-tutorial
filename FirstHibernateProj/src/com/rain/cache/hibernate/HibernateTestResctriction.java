package com.rain.cache.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.rain.cache.dto.User;
import com.rain.cache.dto.Vehicle;

public class HibernateTestResctriction {

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
		Criteria criteria = session.createCriteria(Vehicle.class);
		criteria.add(Restrictions.eq("vehicleName", "xxx"))
				.add(Restrictions.gt("vehicleId", 0))
				.add(Restrictions.between("vehicleId", 1, 5));
		criteria.list();
		session.getTransaction().commit();
		session.close();
		
		
		session = factory.openSession();
		session.beginTransaction();
		Query q = session.getNamedQuery("Vehicle.getAll");
		q.list();
		session.getTransaction().commit();
		session.close();
		
		
		session = factory.openSession();
		session.beginTransaction();
		Query q1 = session.getNamedQuery("Vehicle.getByName");
		q1.setParameter(0, "xxx");
		q1.setFirstResult(1);
		q1.setMaxResults(2);
		q1.list();
		session.getTransaction().commit();
		session.close();
		
	}

}
