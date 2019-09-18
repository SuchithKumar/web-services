package com.yolobyob.getthechick.jpaRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.yolobyob.getthechick.entities.Dealer;

@Component
public interface DealerJpaRepo extends JpaRepository<Dealer	, Long> {

	public Dealer findByPhone(String phone);
	
}
