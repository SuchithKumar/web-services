package com.yolobyob.getthechick.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.yolobyob.getthechick.exception.DealerNotFoundException;
import com.yolobyob.getthechick.exception.ItemNotFoundException;
import com.yolobyob.getthechick.pojo.Dealer;
import com.yolobyob.getthechick.pojo.Item;
import com.yolobyob.getthechick.pojo.LoginBean;
import com.yolobyob.getthechick.service.DealerService;

@RestController
public class DealerController {

	@Autowired
	DealerService dealerService;
	

	@PostMapping("/dealers")
	public ResponseEntity<String> saveDealer(@Valid @RequestBody Dealer dealer) {
		Dealer savedDealer = dealerService.saveDealer(dealer);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{dealerId}").build(savedDealer.getDealerId());
		return ResponseEntity.created(uri).build();

	}

	@GetMapping("/dealers/{dealerId}")
	public Dealer getDealerById(@PathVariable long dealerId) {

		Optional<Dealer> dealer = dealerService.getDealerById(dealerId);

		if (dealer.isPresent()) {
			return dealer.get();
		} else {
			throw new DealerNotFoundException("Dealer with ID-" + dealerId + " was not found in our DB!");
		}
	}

	
	
	@GetMapping("/dealers/{dealerId}/items")
	public List<Item> getDealersAllItems(@PathVariable long dealerId){
		return dealerService.getDealersAllItems(dealerId);
	}
	
	@GetMapping("/dealers/{dealerId}/items/{itemId}")
	public Item getItemById(@PathVariable long dealerId,@PathVariable long itemId){
		Optional<Item> item = dealerService.getDealerItemById(dealerId, itemId);
		if(item.isPresent()) {
			return item.get();
		}else {
			throw new ItemNotFoundException("Item with Item ID - "+itemId+" not found for Dealer ID - "+dealerId);
		}
				
	}
	
	@PostMapping(path = "/dealers/{dealerId}/items")
	public ResponseEntity<String> saveItem(@PathVariable long dealerId,@Valid @RequestBody Item item){
		
		Optional<Dealer> dealer = dealerService.getDealerById(dealerId);
		item.setDealer(dealer.get());
		Item savedItem = dealerService.savedDealerItem(item);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{itemId}").build(savedItem.getItemId());
		
		return ResponseEntity.created(uri).build();
		
	}
	
	
	
	
}
