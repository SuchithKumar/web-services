package com.yolobyob.getthechick.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yolobyob.getthechick.entities.Address;
import com.yolobyob.getthechick.entities.Dealer;
import com.yolobyob.getthechick.entities.ImageUrl;
import com.yolobyob.getthechick.entities.Item;
import com.yolobyob.getthechick.jpaRepo.AddressJpaRepo;
import com.yolobyob.getthechick.jpaRepo.DealerJpaRepo;
import com.yolobyob.getthechick.jpaRepo.ImageUrlRepo;
import com.yolobyob.getthechick.jpaRepo.ItemJpaRepo;

@Repository
public class DealerDao {

	@Autowired
	DealerJpaRepo dealerRepo;
	
	@Autowired
	ItemJpaRepo itemRepo;

	@Autowired
	AddressJpaRepo addressRepo;
	
	@Autowired
	ImageUrlRepo imageUrlRepo;
	
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
	
	public Item saveItem(Item item) {
		return itemRepo.save(item);
	}
	
	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}
	
	public ImageUrl saveImageUrl(ImageUrl url) {
		return imageUrlRepo.save(url);
	}
}
