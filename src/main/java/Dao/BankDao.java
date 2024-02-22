package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Dto.BankAccount;

public class BankDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void save_Account(BankAccount bank_account) {
		entityTransaction.begin();
		entityManager.persist(bank_account);
		entityTransaction.commit();
	}

	public List<BankAccount> fetchAll() {
		List<BankAccount> list = entityManager.createQuery("select x from BankAccount x").getResultList();
		return list;
	}

	public BankAccount fetch_account_details(long acc_no) {
		BankAccount bank_account = entityManager.find(BankAccount.class, acc_no);
		return bank_account;

	}

	public void update_the_details(BankAccount bank_account) {

		entityTransaction.begin();
		entityManager.merge(bank_account);
		entityTransaction.commit();
	}

	public BankAccount find(Long acno) {
		BankAccount bank_account = entityManager.find(BankAccount.class, acno);

		return bank_account;

	}
}
