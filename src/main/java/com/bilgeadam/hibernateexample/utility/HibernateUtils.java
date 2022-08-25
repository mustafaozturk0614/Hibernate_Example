package com.bilgeadam.hibernateexample.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bilgeadam.hibernateexample.entity.Post;
import com.bilgeadam.hibernateexample.entity.User;
import com.bilgeadam.hibernateexample.entity.UserDetail;

public class HibernateUtils {

	// hibernate ile ba�lant�m�z� kuracak

	private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

	private static SessionFactory sessionFactoryHibernate() {
		try {
			Configuration configuration = new Configuration();

			// Entity claslar�m�z� buraya ekliyoruz
			configuration.addAnnotatedClass(User.class);
			configuration.addAnnotatedClass(Post.class);
			configuration.addAnnotatedClass(UserDetail.class);

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
