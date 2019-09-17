package com.yolobyob.getthechick.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.yolobyob.getthechick.pojo.ImageUrl;

public class ImageUrlController {

	@Autowired
	ImageUrlJpaRepo repo;
	
	@PostMapping("/dealers/{dealerId}/items/{itemId}/imageUrls")
	public ImageUrl save(@RequestBody ImageUrl imageUrl,@PathVariable long dealerId, @PathVariable long itemId) {
		
		
		
		try {
		ImageUrl saved = repo.save(imageUrl);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return imageUrl;
		
	}
	
}
