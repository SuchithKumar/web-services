package com.yolobyob.getthechick.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yolobyob.getthechick.jpaRepo.ItemJpaRepo;
import com.yolobyob.getthechick.pojo.Item;

@Repository
public class ItemDao {

	
	@Autowired
	private ItemJpaRepo repo;
	
	public Item saveItem(Item item) {
		return repo.save(item);
	}
	
	
}
