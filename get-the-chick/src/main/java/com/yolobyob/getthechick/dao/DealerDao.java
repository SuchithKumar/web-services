package com.yolobyob.getthechick.dao;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yolobyob.getthechick.jpaRepo.DealerJpaRepo;
import com.yolobyob.getthechick.jpaRepo.ItemJpaRepo;
import com.yolobyob.getthechick.pojo.Dealer;
import com.yolobyob.getthechick.util.HibernateUtil;

@Repository
public class DealerDao {

	HibernateUtil hibernateUtil = new HibernateUtil();
	SessionFactory factory;
	Session session;
	
	@Autowired
	DealerJpaRepo dealerRepo;
	
	@Autowired
	ItemJpaRepo itemRepo;
	
	public Dealer saveDealer(Dealer dealer) {
		return dealerRepo.save(dealer);
	}
	
	public Optional<Dealer> getDealerById(long dealerId) {
		return dealerRepo.findById(dealerId);
	}

	public Optional<Dealer> getDealerByPhone(String phone) {

		factory = HibernateUtil.getSessionFactory();
		session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Optional<Dealer> dealer;
		Query query = session.createQuery("from Dealer d where d.phone= :no");
		query.setParameter("no", phone);
		dealer = (Optional<Dealer>) query.uniqueResult();
		tx.commit();
		session.close();
		factory.close();
		return dealer;
		
	}
	
	
}
