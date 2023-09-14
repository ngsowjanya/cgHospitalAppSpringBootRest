package com.cg.hospital.config;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class HospitalConfig {
	@Value("${basePackage}")
	private String basePackage; 
	 
	@Bean    // URL :- http://localhost:4444/onlineshop/swagger-ui.html
	public Docket swaggerConfig() {
		System.out.println("============== Package Name  :- "+basePackage);
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(basePackage))
				.build()
				.apiInfo(getApiMetaData());
		}

	private ApiInfo getApiMetaData() {
		return new ApiInfo("Hospital"
				, "OnlineShop REST API"
				, "1.0", "For Learning Purpose"
				, new springfox.documentation.service.Contact("Sowjanya", "www.capgemini.com", "sowjanya@capgemini.com")
				, "API License"
				,"http:capgemini.com"
				,Collections.emptyList());
	}
}
