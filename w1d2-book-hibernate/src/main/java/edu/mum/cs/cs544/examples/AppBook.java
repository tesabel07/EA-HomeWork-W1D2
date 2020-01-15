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


public class AppBook {
	
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
			
			  Book b1=new Book("Spring","ISBN-123","Mimi",24.99,new Date());
			  Book b2=new Book("Hibernate","ISBN-321","Kiki",34.99,new Date());
			  Book b3=new Book("Angular","ISBN-567","Titi",45.99,new Date());
			  
			  session.persist(b1);
			  session.persist(b2);
			  session.persist(b3);
//			   System.out.println("B1:-  "+b1);
//			   System.out.println("B2:-  "+b2);
//			   System.out.println("B3:-  "+b3);
			transaction.commit();
			
		}catch (HibernateException e) {
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
			
			List<Book> allBook = session.createQuery("from Book").list();
			for(Book theBook : allBook) {
				System.out.println("Book:-  "+theBook);
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
	
	public static void update(Long id,String title, double price) {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			  Book tempBook = (Book) session.get(Book.class, id);
			     tempBook.setTitle(title);
			     tempBook.setPrice(price); 
			
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	public static void delete(Long id) {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			  Book tempBook = (Book) session.get(Book.class, id);
			     session.delete(tempBook);
			
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
		
		AppBook.save();
		System.out.println("\n below is list of book \n");
		AppBook.list();
		System.out.println("\n below is update the book \n");
		AppBook.update(1L, "Update TItle", 100.99);
		System.out.println("\n below is delete the book \n");
		AppBook.delete(2L);
		System.out.println("\n below is list of book \n");
		AppBook.list();

	}

}
