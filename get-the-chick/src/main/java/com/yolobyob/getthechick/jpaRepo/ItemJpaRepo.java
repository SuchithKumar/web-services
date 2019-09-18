package com.yolobyob.getthechick.jpaRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.yolobyob.getthechick.entities.Item;

@Component
public interface ItemJpaRepo extends JpaRepository<Item, Long> {

	
	
}
