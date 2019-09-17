package com.yolobyob.getthechick.dao;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yolobyob.getthechick.pojo.Customer;
import com.yolobyob.getthechick.util.HibernateUtil;

@Repository
public class CustomerDao {

	HibernateUtil hibernateUtil = new HibernateUtil();
	SessionFactory factory;
	Session session;

	@Autowired
	CustomerJpaRepo repo;

	public Customer saveCustomer(Customer customer) {
		return repo.save(customer);
	}

	public Optional<Customer> getCustomerById(long id) {
		return repo.findById(id);
	}

	public Optional<Customer> getCustomerByPhone(String phone) {

		factory = HibernateUtil.getSessionFactory();
		session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Optional<Customer> customer;
		Query query = session.createQuery("from Customer where phone= :no");
		query.setParameter("no", phone);
		customer = (Optional<Customer>) query.uniqueResult();
		tx.commit();
		session.close();
		factory.close();
		return customer;
		
	}
}
