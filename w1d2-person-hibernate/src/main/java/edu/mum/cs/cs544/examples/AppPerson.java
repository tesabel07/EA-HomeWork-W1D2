package edu.mum.cs.cs544.examples;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppPerson {
	
	private static SessionFactory sessionFactory;
	private static Session session = null;
	private static Transaction transaction = null;
	
	
	static {
		// This step will read hibernate.cfg.xml and prepare hibernate for use
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(sr);
	}
	
	public static void save() {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Person p1 = new Person("Abel","Nedi",new Date());
			Person p2 = new Person("Beti","Bete",new Date());
			Person p3 = new Person("Seble","Aygoda",new Date()); 
			   session.persist(p1);
			   session.persist(p2);
			   session.persist(p3);
			   			
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	public static void list() {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
            List<Person> allPerson = session.createQuery("from Person").list();
            for(Person thePerson : allPerson) {
            	System.out.println("person:-  "+thePerson);
            }
			   			
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	public static void update() {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
           Person tempPerson = (Person)session.get(Person.class, 1L);
			   		tempPerson.setFirstname("Kidus");	
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	public static void delete() {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
           Person tempPerson = (Person)session.get(Person.class, 2L);
               session.delete(tempPerson);
			   			
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public static void main(String[] args) {
		AppPerson.save();
		System.out.println("\n below is list Person \n");
		AppPerson.list();
		
		System.out.println("\n below is update Person \n");
		AppPerson.update();
		System.out.println("\n below is delete Person \n");
		AppPerson.delete();
		
		
		System.out.println("\n below is list Person \n");
		AppPerson.list();

	}

}
