package com.bilgeadam.hibernateexample.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;

import com.bilgeadam.hibernateexample.utility.HibernateUtils;

public interface ICrud<T> {

	void save(T t);

	void update(T t, long id);

	void delete(long id);

	List<T> findAll();

	Optional<T> findById(long id);

	default Session databaseConnectionHibernate() {

		return HibernateUtils.getSessionFactory().openSession();
	}

}
