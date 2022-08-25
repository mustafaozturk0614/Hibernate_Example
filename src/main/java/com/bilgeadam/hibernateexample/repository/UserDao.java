package com.bilgeadam.hibernateexample.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.bilgeadam.hibernateexample.entity.User;
import com.bilgeadam.hibernateexample.utility.HibernateUtils;

public class UserDao implements ICrud<User> {

	public void save(User user) {
		Session session = null;

		try {
			// database baðlantýsý kuruldu
			session = databaseConnectionHibernate();
			// transaction
			session.getTransaction().begin();
			// kayýt iþlemi
			session.save(user);
			// tansaction sonlandýrma
			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Baðlantý hatasý");
			e.printStackTrace();
			session.getTransaction().rollback();

		} finally {
			// baðlantý kapanýyor
			session.close();
		}

	}

	public void update(User t, long id) {
		Session session = null;

		try {
			Optional<User> user = findById(id);
			if (user != null) {
				user.get().setUsername(t.getUsername());
//				user.get().setGender(t.getGender());
				user.get().setPassword(t.getPassword());
				session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(user.get());
				session.getTransaction().commit();

				System.out.println("Kullanýcý Baþarýyla güncellendi");
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}

	public void delete(long id) {
		Session session = null;

		try {
			Optional<User> user = findById(id);

			if (user != null) {
				session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.delete(user);
				session.getTransaction().commit();
				System.out.println(user.get().getUsername() + "silindi");
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}

	public List<User> findAll() {
		Session session = null;
		try {
			session = databaseConnectionHibernate();
			String query = "select users from User as users ";
			TypedQuery<User> typedQuery = session.createQuery(query, User.class);
			List<User> userList = typedQuery.getResultList();
			for (User user : userList) {
				System.out.println(user);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}

		return null;
	}

	public Optional<User> findById(long id) {
		User user = null;
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			user = session.find(User.class, id);
			if (user != null) {
				System.out.println("user bulundu" + user);

			} else {
				System.out.println("user bulunamadý" + user);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return Optional.ofNullable(user);
	}

}
