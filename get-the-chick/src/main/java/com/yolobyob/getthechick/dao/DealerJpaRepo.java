package com.yolobyob.getthechick.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.yolobyob.getthechick.pojo.Dealer;

@Component
public interface DealerJpaRepo extends JpaRepository<Dealer	, Long> {

}
