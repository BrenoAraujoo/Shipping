package com.shipping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shipping.entities.ShippingCompany;
import com.shipping.repositories.ShippingCompanyRepository;

@RestController
@RequestMapping("/ShippingCompany")
public class ShippingCompanyController {
	
	@Autowired
	private ShippingCompanyRepository shippingCompanyRepository;
	@GetMapping
	public List<ShippingCompany> list (){
		return shippingCompanyRepository.findAll();
	}
	@GetMapping(value = "/{id}")
	public Optional<ShippingCompany> findById(@PathVariable("id") Long id){
		Optional<ShippingCompany> company = shippingCompanyRepository.findById(id);
		return company;
		
	}
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<ShippingCompany>add(@RequestBody ShippingCompany shippingCompany) {
		shippingCompanyRepository.save(shippingCompany);
		return ResponseEntity.ok(shippingCompany);
	}
	

}
