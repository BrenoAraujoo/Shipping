package com.shipping.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.shipping.entities.ShippingCompany;
import com.shipping.repositories.ShippingCompanyRepository;

@Configuration
@Profile("test")
public class TestConfig  implements CommandLineRunner {
	
	@Autowired
	private ShippingCompanyRepository shippingCompanyRepository;
	
	
	
	public void run(String... args) throws Exception {
	
		ShippingCompany c1 = new ShippingCompany(null, "Altura Andaimes");
		ShippingCompany c2= new ShippingCompany(null, "DHM transportes");
		shippingCompanyRepository.save(c1);
		shippingCompanyRepository.save(c2);
	
	
	}
	
	

}
