package com.bilgeadam.hibernateexample.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bilgeadam.hibernateexample.entity.User;
import com.bilgeadam.hibernateexample.utility.HibernateUtils;

public class UserRepository implements ICrud<User> {

	private Session session;
	private EntityManager entityManager;
	private CriteriaBuilder criteriaBuilder;
	private Transaction transaction;

	public UserRepository() {
		entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		criteriaBuilder = entityManager.getCriteriaBuilder();
	}

	public void openSession() {
		session = databaseConnectionHibernate();
		transaction = session.beginTransaction();

	}

	public void successClose() {

		transaction.commit();
		session.close();

	}

	public void errorClose() {

		transaction.rollback();
		session.close();

	}

	@Override
	public void save(User t) {

		try {
			openSession();
			session.save(t);
			successClose();

		} catch (Exception e) {
			e.printStackTrace();
			errorClose();
		}

	}

	@Override
	public void update(User t, long id) {
		try {
			openSession();
			t.setId(id);
			session.update(t);
			successClose();

		} catch (Exception e) {
			errorClose();
		}

	}

	@Override
	public void delete(long id) {
		Optional<User> user = findById(id);
		if (user.isPresent()) {
			try {
				openSession();
				session.delete(user.get());
				successClose();

			} catch (Exception e) {
				errorClose();
			}
		} else {
			System.out.println(id + "li veri databasede bulunmamaktadýr");
		}

	}

	@Override
	public List<User> findAll() {

		CriteriaQuery<User> criteria = criteriaBuilder.createQuery(User.class);
		Root<User> root = criteria.from(User.class);
		criteria.select(root);

		return entityManager.createQuery(criteria).getResultList();
	}

	@Override
	public Optional<User> findById(long id) {
		User user = null;
		CriteriaQuery<User> criteria = criteriaBuilder.createQuery(User.class);
		Root<User> root = criteria.from(User.class);
		criteria.select(root);
		criteria.where(criteriaBuilder.equal(root.get("id"), id));
		try {
			user = entityManager.createQuery(criteria).getSingleResult();
			return Optional.of(user);
		} catch (Exception e) {
			return Optional.ofNullable(null);
		}

	}

	public void startLike(String value) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);

		Root<User> root = query.from(User.class);

//		query.select(root);

//		query.where(criteriaBuilder.like(root.get("name").get("firstName"), value + "%"));
//		String hql = "select u from User as u  where  u.name.firstName   like :x  ";
		query.select(root).where(criteriaBuilder.like(root.get("name").get("firstName"), value + "%"));
		List<User> users = entityManager.createQuery(query).getResultList();
		users.forEach(System.out::println);
	}
	// post number 10dan buyuk olanlarý getiren bir fonksiyon like gt

	public void gt(int number) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
		Root<User> root = query.from(User.class);

		query.select(root).where(criteriaBuilder.gt(root.get("postNumber"), number));

		List<User> users = entityManager.createQuery(query).getResultList();
		users.forEach(System.out::println);
	}

	public void sumPost() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
		Root<User> root = query.from(User.class);
		query.multiselect(criteriaBuilder.sum(root.get("postNumber")));
		Long result = entityManager.createQuery(query).getSingleResult();
		System.out.println(result);
	}

}