package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Dto.Customer;

public class CustomerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void save(Customer customer) {
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();

	}

	public List<Customer> check1(String eid) {
		List<Customer> list = entityManager.createQuery("select x from Customer x where email=?1").setParameter(1, eid)
				.getResultList();
		return list;
	}

	public List<Customer> check2(long mobile) {
		List<Customer> list = entityManager.createQuery("select x from Customer x where mob=?1").setParameter(1, mobile)
				.getResultList();
		return list;
	}

	public Customer login(int customerid) {
		Customer customer = entityManager.find(Customer.class, customerid);
		return customer;
	}

	public void update(Customer customer_Information) {
		entityTransaction.begin();
		entityManager.merge(customer_Information);
		entityTransaction.commit();
	}

	public Customer findById(int id) {
		return entityManager.find(Customer.class, id);
	}
}
