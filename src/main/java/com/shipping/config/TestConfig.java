package com.shipping.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.shipping.entities.ShippingCompany;
import com.shipping.entities.Transport;
import com.shipping.entities.User;
import com.shipping.repositories.ShippingCompanyRepository;
import com.shipping.repositories.TransportRepository;
import com.shipping.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ShippingCompanyRepository shippingCompanyRepository;
	@Autowired
	private TransportRepository transportRepository;
	
	@Autowired
	private UserRepository userRepository;

	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		User u1 = new User(null, "Breno");
		User u2 = new User(null, "Rafaela");
		List<User> users = Arrays.asList(u1,u2);
		
		userRepository.saveAll(users);

		ShippingCompany c1 = new ShippingCompany(null, "Altura Andaimes");
		ShippingCompany c2 = new ShippingCompany(null, "DHM transportes");
		shippingCompanyRepository.save(c1);
		shippingCompanyRepository.save(c2);

		Transport t1 = new Transport(null, 200.00, sdf.parse("2022-01-01"), "teste", c1);
		t1.setUser(u1);
		transportRepository.save(t1);
	}

}
