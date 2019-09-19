package com.yolobyob.getthechick.jpaRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.yolobyob.getthechick.entities.Address;

@Component
public interface AddressJpaRepo extends JpaRepository<Address, Long> {

	
	
}
