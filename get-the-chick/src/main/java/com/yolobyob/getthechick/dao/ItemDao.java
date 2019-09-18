package com.yolobyob.getthechick.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yolobyob.getthechick.entities.Item;
import com.yolobyob.getthechick.jpaRepo.ItemJpaRepo;

@Repository
public class ItemDao {

	
	@Autowired
	private ItemJpaRepo repo;
	
	public Item saveItem(Item item) {
		return repo.save(item);
	}
	
	
}
