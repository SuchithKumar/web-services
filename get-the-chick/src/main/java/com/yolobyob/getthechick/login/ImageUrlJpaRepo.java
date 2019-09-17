package com.yolobyob.getthechick.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.yolobyob.getthechick.pojo.ImageUrl;
import com.yolobyob.getthechick.pojo.Item;

@Component
public interface ImageUrlJpaRepo extends JpaRepository<ImageUrl, Long> {

}
