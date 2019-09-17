package com.yolobyob.getthechick.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yolobyob.getthechick.pojo.Dealer;

@Repository
public class DealerDao {

	@Autowired
	DealerJpaRepo repo;
	
	public Dealer saveDealer(Dealer dealer) {
		return repo.save(dealer);
	}
	
	
	
}
