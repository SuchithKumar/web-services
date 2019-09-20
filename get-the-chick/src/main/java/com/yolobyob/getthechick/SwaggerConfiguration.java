package com.yolobyob.getthechick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
		
	 
	
	 public static final Contact DEFAULT_CONTACT = new Contact("Suchith Kumar", "", "7019393408");
	  public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Api Documentation", "Get the chick Restful Web Services API Doc", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "BYOB 1.0", "http://www.byob.com/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/json","application/xml"));


	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PRODUCES_AND_CONSUMES); 
	}
	
}
