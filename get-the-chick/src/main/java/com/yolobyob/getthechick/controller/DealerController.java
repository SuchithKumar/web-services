package com.yolobyob.getthechick.controller;

import java.net.URI;
import java.util.Iterator;
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

import com.yolobyob.getthechick.entities.Address;
import com.yolobyob.getthechick.entities.Dealer;
import com.yolobyob.getthechick.entities.ImageUrl;
import com.yolobyob.getthechick.entities.Item;
import com.yolobyob.getthechick.entities.Order;
import com.yolobyob.getthechick.exception.DealerNotFoundException;
import com.yolobyob.getthechick.exception.ItemNotFoundException;
import com.yolobyob.getthechick.exception.OrderNotFoundException;
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
	public List<Item> getDealersAllItems(@PathVariable long dealerId) {
		return dealerService.getDealersAllItems(dealerId);
	}

	@GetMapping("/dealers/{dealerId}/items/{itemId}")
	public Item getItemById(@PathVariable long dealerId, @PathVariable long itemId) {
		Optional<Item> item = dealerService.getDealerItemById(dealerId, itemId);
		if (item.isPresent()) {
			return item.get();
		} else {
			throw new ItemNotFoundException("Item with Item ID - " + itemId + " not found for Dealer ID - " + dealerId);
		}

	}

	@PostMapping(path = "/dealers/{dealerId}/items")
	public ResponseEntity<String> saveItem(@PathVariable long dealerId, @Valid @RequestBody Item item) {

		Optional<Dealer> dealer = dealerService.getDealerById(dealerId);
		item.setDealer(dealer.get());
		Item savedItem = dealerService.savedDealerItem(item);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{itemId}").build(savedItem.getItemId());

		return ResponseEntity.created(uri).build();

	}

	@GetMapping(path = "/dealers/{dealerId}/orders")
	public List<Order> getAllDealerOrders(@PathVariable Long dealerId) {
		Dealer dealer = getDealerById(dealerId);
		return dealer.getOrders();
	}

	
	@GetMapping(path = "/dealers/{dealerId}/orders/{orderId}")
	public Order getDealerOrderById(@PathVariable Long dealerId, @PathVariable Long orderId){
		Dealer dealer = getDealerById(dealerId);
		List<Order> orders = dealer.getOrders();
		Iterator<Order> iterator = orders.iterator();
		Order order = null;
		while(iterator.hasNext()) {
			order = iterator.next();
			if(order.getOrderId()==orderId) {
				return order;
			}
		}
		
		throw new OrderNotFoundException("Order not found!");
		
	}
	
	
	@PostMapping(path = "/dealers/{dealerId}/addresses")
	public ResponseEntity<String> saveDealerAddress(@PathVariable Long dealerId,@Valid @RequestBody Address address) {
		Dealer dealer = getDealerById(dealerId);
		
		address.setDealer(dealer);
		Address savedAddress =  dealerService.saveAddress(address);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{addressId}").build(savedAddress.getAddressId());
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(path = "/dealers/{dealerId}/addresses")
	public List<Address> getDealersAddress(@PathVariable Long dealerId){
		Dealer dealer = getDealerById(dealerId);
		return dealer.getAddresses();
	}
	
	@PostMapping(path = "/dealers/{dealerId}/items/{itemId}/images")
	public ResponseEntity<String> saveImageUrl(@PathVariable Long dealerId,@PathVariable Long itemId,@Valid @RequestBody ImageUrl url ){
		Item item = getItemById(dealerId, itemId);
		
		url.setItem(item);
		ImageUrl savedUrl = dealerService.saveImageUrl(url);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{imageUrlId}").build(savedUrl.getImageId());
		
		return ResponseEntity.created(uri).build();
		
	}
	
	@GetMapping(path ="/dealers/{dealerId}/items/{itemId}/images")
	public List<ImageUrl> getImages(@PathVariable Long dealerId,@PathVariable Long itemId){
		Item item = getItemById(dealerId, itemId);
		return item.getItemImageUrls();
	}
	
	
}

