package com.yolobyob.getthechick.dao;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yolobyob.getthechick.entities.Dealer;
import com.yolobyob.getthechick.jpaRepo.DealerJpaRepo;
import com.yolobyob.getthechick.jpaRepo.ItemJpaRepo;
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

	public Optional<Dealer> findDealerByPhone(String phone){
		Optional<Dealer> dealer = Optional.empty();
		
		Dealer foundDealer = dealerRepo.findByPhone(phone);
		if(foundDealer!=null) {
			dealer = Optional.of(foundDealer);
		}
		
		return dealer;
	}
	
}
