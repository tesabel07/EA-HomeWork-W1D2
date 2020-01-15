package edu.mum.cs.cs544.examples;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Application {
	private static SessionFactory sessionFactory;

	static {
		// This step will read hibernate.cfg.xml and prepare hibernate for use
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(sr);
	}

	public static void main(String[] args) {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			 
			Car c1=new Car("Toyota",2019,199.99);
			Car c2=new Car("Honda",2015,89.99);
			
			session.persist(c1);
			session.persist(c2);
			
			System.out.println(c1);
			System.out.println(c2);
			  
			
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
///////////////////////////////////////////////////////////////////////////below retrieve all cars
		
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			List<Car> allCar = session.createQuery("from Car").list();
			for(Car theCar : allCar) {
				System.out.println(theCar);
			}
			
			 tx.commit(); 

		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		// Close the SessionFactory (not mandatory)
		sessionFactory.close();
	}
}