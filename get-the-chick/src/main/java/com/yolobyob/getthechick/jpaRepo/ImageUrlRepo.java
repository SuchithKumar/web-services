package com.yolobyob.getthechick.jpaRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.yolobyob.getthechick.entities.ImageUrl;

@Component
public interface ImageUrlRepo extends JpaRepository<ImageUrl, Long> {

}
