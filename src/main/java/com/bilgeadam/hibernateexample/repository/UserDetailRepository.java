package com.bilgeadam.hibernateexample.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bilgeadam.hibernateexample.entity.UserDetail;
import com.bilgeadam.hibernateexample.utility.HibernateUtils;

public class UserDetailRepository implements ICrud<UserDetail> {

	private Session session;
	private EntityManager entityManager;
	private CriteriaBuilder criteriaBuilder;
	private Transaction transaction;

	public UserDetailRepository() {
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
	public void save(UserDetail t) {

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
	public void update(UserDetail t, long id) {
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
		Optional<UserDetail> userDetail = findById(id);
		if (userDetail.isPresent()) {
			try {
				openSession();
				session.delete(userDetail.get());
				successClose();

			} catch (Exception e) {
				errorClose();
			}
		} else {
			System.out.println(id + "li veri databasede bulunmamaktadýr");
		}

	}

	@Override
	public List<UserDetail> findAll() {

		CriteriaQuery<UserDetail> criteria = criteriaBuilder.createQuery(UserDetail.class);
		Root<UserDetail> root = criteria.from(UserDetail.class);
		criteria.select(root);

		return entityManager.createQuery(criteria).getResultList();
	}

	@Override
	public Optional<UserDetail> findById(long id) {
		UserDetail userDetail = null;
		CriteriaQuery<UserDetail> criteria = criteriaBuilder.createQuery(UserDetail.class);
		Root<UserDetail> root = criteria.from(UserDetail.class);
		criteria.select(root);
		criteria.where(criteriaBuilder.equal(root.get("id"), id));
		try {
			userDetail = entityManager.createQuery(criteria).getSingleResult();
			return Optional.of(userDetail);
		} catch (Exception e) {
			return Optional.ofNullable(null);
		}

	}

	public void startLike(String value) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<UserDetail> query = criteriaBuilder.createQuery(UserDetail.class);

		Root<UserDetail> root = query.from(UserDetail.class);

//		query.select(root);

//		query.where(criteriaBuilder.like(root.get("name").get("firstName"), value + "%"));
//		String hql = "select u from UserDetail as u  where  u.name.firstName   like :x  ";
		query.select(root).where(criteriaBuilder.like(root.get("name").get("firstName"), value + "%"));
		List<UserDetail> userDetails = entityManager.createQuery(query).getResultList();
		userDetails.forEach(System.out::println);
	}
	// post number 10dan buyuk olanlarý getiren bir fonksiyon like gt

	public void gt(int number) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserDetail> query = criteriaBuilder.createQuery(UserDetail.class);
		Root<UserDetail> root = query.from(UserDetail.class);

		query.select(root).where(criteriaBuilder.gt(root.get("postNumber"), number));

		List<UserDetail> userDetails = entityManager.createQuery(query).getResultList();
		userDetails.forEach(System.out::println);
	}

	public void sumPost() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
		Root<UserDetail> root = query.from(UserDetail.class);
		query.multiselect(criteriaBuilder.sum(root.get("postNumber")));
		Long result = entityManager.createQuery(query).getSingleResult();
		System.out.println(result);
	}

}