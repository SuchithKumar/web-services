package com.yolobyob.getthechick;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yolobyob.getthechick.dao.CustomerDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetTheChickApplicationTests {

	@Test
	public void contextLoads() {
		
		CustomerDao dao = new CustomerDao();
		
		
		
	}

}
