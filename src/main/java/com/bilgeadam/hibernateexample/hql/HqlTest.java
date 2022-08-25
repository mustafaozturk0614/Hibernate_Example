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
 * postnumberin toplamý
 * min 
 * max
 * ortalamasý
 * 8-20 arasýndakileri getiren  fonksiyonlarý yazalým ;
 * 
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

	public static void sumPostNumber() {

		String hql = "select sum(u.postNumber) from User as u   ";
		Session session = HibernateUtils.getSessionFactory().openSession();
		long sum = session.createQuery(hql, Long.class).getSingleResult();
		System.out.println(sum);
	}

	public static void minPostNumber() {
		String hql = "select min(u.postNumber) from User as u";
		Session session = HibernateUtils.getSessionFactory().openSession();
		Integer user = session.createQuery(hql, Integer.class).getSingleResult();
		System.out.println(user);
	}

	public static void maxPostNumber() {
		String hql = "select max(u.postNumber) from User as u   ";
		Session session = HibernateUtils.getSessionFactory().openSession();
		Integer user = session.createQuery(hql, Integer.class).getSingleResult();
		System.out.println(user);
	}

	public static void avgPostNumber() {
		String hql = "select avg(u.postNumber) from User as u   ";
		Session session = HibernateUtils.getSessionFactory().openSession();
		Double user = session.createQuery(hql, Double.class).getSingleResult();
		System.out.println(user);
	}

	public static void betweenPostNumber(int number1, int number2) {
		String hql = "select u from User as u  where  u.postNumber between :number1 and :number2";
		Session session = HibernateUtils.getSessionFactory().openSession();
		TypedQuery<User> typedQuery = session.createQuery(hql, User.class);
		typedQuery.setParameter("number1", number1);
		typedQuery.setParameter("number2", number2);
		List<User> users = typedQuery.getResultList();
		users.forEach(System.out::println);
	}

	public static void getTwoUser() {
		String hql = "select u from User as u  order by u.name.firstName asc";
		Session session = HibernateUtils.getSessionFactory().openSession();
		TypedQuery<User> typedQuery = session.createQuery(hql, User.class);
		typedQuery.setMaxResults(2);
		List<User> users = typedQuery.getResultList();
		users.forEach(System.out::println);
	}

	public static void main(String[] args) {

//		findAll();
//		startLike("M");

//		greaterThan(10);
//		sumPostNumber();
//		minPostNumber();
//		maxPostNumber();
//		avgPostNumber();
//		betweenPostNumber(5, 15);
		getTwoUser();

	}

}
