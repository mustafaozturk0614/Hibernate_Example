package com.bilgeadam.hibernateexample.hql;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.bilgeadam.hibernateexample.entity.User;
import com.bilgeadam.hibernateexample.utility.HibernateUtils;

/*
 * 
 * postnumber 10 dan buyuk olanlarý getirsin 
 * 
 * 
 */
public class HqlTest {

	public static void findAll() {
		String hql = "select u from User as u";
		Session session = HibernateUtils.getSessionFactory().openSession();
		TypedQuery<User> typedQuery = session.createQuery(hql, User.class);
		List<User> users = typedQuery.getResultList();
		users.forEach(System.out::println);

	}

	public static void startLike(String value) {

		String hql = "select u from User as u  where  u.name.firstName   like :x  ";
		Session session = HibernateUtils.getSessionFactory().openSession();
		TypedQuery<User> typedQuery = session.createQuery(hql, User.class);
		typedQuery.setParameter("x", value + "%");
		List<User> users = typedQuery.getResultList();
		users.forEach(System.out::println);
	}

	public static void greaterThan(int number) {

		String hql = "select u from User as u where u.postNumber >:key";
		Session session = HibernateUtils.getSessionFactory().openSession();
		TypedQuery<User> typedQuery = session.createQuery(hql, User.class);
		typedQuery.setParameter("key", number);
		List<User> users = typedQuery.getResultList();
		users.forEach(System.out::println);
	}

	public static void main(String[] args) {

//		findAll();
//		startLike("M");

		greaterThan(10);

	}

}
