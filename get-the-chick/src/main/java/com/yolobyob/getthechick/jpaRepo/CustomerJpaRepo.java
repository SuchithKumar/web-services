package com.yolobyob.getthechick.jpaRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.yolobyob.getthechick.pojo.Customer;

@Component
public interface CustomerJpaRepo extends JpaRepository<Customer	, Long> {

}
