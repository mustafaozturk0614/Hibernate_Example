package com.bilgeadam.hibernateexample.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bilgeadam.hibernateexample.entity.Post;
import com.bilgeadam.hibernateexample.utility.HibernateUtils;

public class PostRepository implements ICrud<Post> {

	private Session session;
	private EntityManager entityManager;
	private CriteriaBuilder criteriaBuilder;
	private Transaction transaction;

	public PostRepository() {
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
	public void save(Post t) {

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
	public void update(Post t, long id) {
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
		Optional<Post> post = findById(id);
		if (post.isPresent()) {
			try {
				openSession();
				session.delete(post.get());
				successClose();

			} catch (Exception e) {
				errorClose();
			}
		} else {
			System.out.println(id + "li veri databasede bulunmamaktadýr");
		}

	}

	@Override
	public List<Post> findAll() {

		CriteriaQuery<Post> criteria = criteriaBuilder.createQuery(Post.class);
		Root<Post> root = criteria.from(Post.class);
		criteria.select(root);

		return entityManager.createQuery(criteria).getResultList();
	}

	@Override
	public Optional<Post> findById(long id) {
		Post post = null;
		CriteriaQuery<Post> criteria = criteriaBuilder.createQuery(Post.class);
		Root<Post> root = criteria.from(Post.class);
		criteria.select(root);
		criteria.where(criteriaBuilder.equal(root.get("id"), id));
		try {
			post = entityManager.createQuery(criteria).getSingleResult();
			return Optional.of(post);
		} catch (Exception e) {
			return Optional.ofNullable(null);
		}

	}

}
