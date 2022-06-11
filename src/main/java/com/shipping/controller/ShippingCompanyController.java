package com.shipping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shipping.entities.ShippingCompany;
import com.shipping.service.ShippingCompanyService;

@RestController
@RequestMapping("/ShippingCompany")
public class ShippingCompanyController {

	@Autowired
	private ShippingCompanyService shippingCompanyService;

	@GetMapping
	public List<ShippingCompany> findAll() {
		return shippingCompanyService.findAll();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ShippingCompany> findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(shippingCompanyService.findById(id));

	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<ShippingCompany> save(@RequestBody ShippingCompany shippingCompany) {
		shippingCompanyService.save(shippingCompany);
		return ResponseEntity.ok(shippingCompany);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ShippingCompany> delete(@PathVariable("id") Long id) {
		shippingCompanyService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<ShippingCompany> update(@RequestBody ShippingCompany company){
		shippingCompanyService.update(company);
		return ResponseEntity.noContent().build();
	}

}
