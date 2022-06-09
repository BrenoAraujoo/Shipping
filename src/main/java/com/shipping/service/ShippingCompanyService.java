package com.shipping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.shipping.entities.ShippingCompany;
import com.shipping.repositories.ShippingCompanyRepository;
@Service
public class ShippingCompanyService {

	
	@Autowired
	private ShippingCompanyRepository shippingCompany;


	public List<ShippingCompany> findAll() {
		return shippingCompany.findAll();
	}
	

	public ShippingCompany findById(Long id) {
		Optional <ShippingCompany> company  = shippingCompany.findById(id);
		return company.get();
	}


	public ShippingCompany save(@RequestBody ShippingCompany company) {
		return shippingCompany.save(company);
	}
}


