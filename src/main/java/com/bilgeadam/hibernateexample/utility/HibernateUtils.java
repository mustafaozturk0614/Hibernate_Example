package com.bilgeadam.hibernateexample.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bilgeadam.hibernateexample.entity.User;

public class HibernateUtils {

	// hibernate ile baðlantýmýzý kuracak

	private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

	private static SessionFactory sessionFactoryHibernate() {
		try {
			Configuration configuration = new Configuration();

			// Entity claslarýmýzý buraya ekliyoruz
			configuration.addAnnotatedClass(User.class);

			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();

			return factory;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

}
