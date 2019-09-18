package com.yolobyob.getthechick.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.yolobyob.getthechick.entities.Address;
import com.yolobyob.getthechick.entities.Admin;
import com.yolobyob.getthechick.entities.Customer;
import com.yolobyob.getthechick.entities.Dealer;
import com.yolobyob.getthechick.entities.ImageUrl;
import com.yolobyob.getthechick.entities.Item;
import com.yolobyob.getthechick.entities.Order;


public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
        	Configuration configuration = new Configuration();
        	configuration.configure();
        	configuration.addAnnotatedClass(Dealer.class);
        	configuration.addAnnotatedClass(Customer.class);
        	configuration.addAnnotatedClass(Address.class);
        	configuration.addAnnotatedClass(Admin.class);
        	configuration.addAnnotatedClass(Item.class);
        	configuration.addAnnotatedClass(Order.class);
        	configuration.addAnnotatedClass(ImageUrl.class);
        	System.out.println("Hibernate Configuration loaded");
        	
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        	System.out.println("Hibernate serviceRegistry created");
        	
        	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        	
            return sessionFactory;
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}
