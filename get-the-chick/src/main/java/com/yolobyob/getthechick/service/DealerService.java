package com.yolobyob.getthechick.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yolobyob.getthechick.controller.DealerController;
import com.yolobyob.getthechick.dao.DealerDao;
import com.yolobyob.getthechick.entities.Address;
import com.yolobyob.getthechick.entities.Dealer;
import com.yolobyob.getthechick.entities.ImageUrl;
import com.yolobyob.getthechick.entities.Item;

@Service
public class DealerService {

	@Autowired
	DealerDao dealerDao;

	@Autowired
	DealerController dealerController;

	public Dealer saveDealer(Dealer dealer) {
		return dealerDao.saveDealer(dealer);
	}

	public Optional<Dealer> getDealerById(long dealerId) {
		return dealerDao.getDealerById(dealerId);
	}
	
	public Optional<Dealer> findDealerByPhone(String phone) {
		return dealerDao.findDealerByPhone(phone);
	}
	
	public Optional<Dealer> findDealerByEmailId(String emailId) {
		return dealerDao.findDealerByEmailId(emailId);
	}

	public Item savedDealerItem(Item item) {
		return dealerDao.saveItem(item);
	}

	public List<Item> getDealersAllItems(long dealerId) {
		Optional<Dealer> dealer = dealerDao.getDealerById(dealerId);
		if (dealer.isPresent()) {
			return dealer.get().getItems();
		}
		return new ArrayList<Item>();
	}

	public Optional<Item> getDealerItemById(long dealerId, long itemId) {
		Optional<Dealer> dealer = dealerDao.getDealerById(dealerId);
		List<Item> items = dealer.get().getItems();
		Optional<Item> optionalItem = Optional.empty();
		if (dealer.isPresent()) {
			Iterator<Item> iterator = items.iterator();
			while (iterator.hasNext()) {
				Item item = iterator.next();
				if (item.getItemId() == itemId) {
					optionalItem = Optional.of(item);
					return optionalItem;
				}
			}
		}
		return optionalItem;
	}
	
	public Address saveAddress(Address address) {
		return dealerDao.saveAddress(address);
	}
	
	public ImageUrl saveImageUrl(ImageUrl url) {
		return dealerDao.saveImageUrl(url);
	}
}
