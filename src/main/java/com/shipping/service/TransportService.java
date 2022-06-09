package com.shipping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.shipping.entities.Transport;
import com.shipping.repositories.ShippingCompanyRepository;
import com.shipping.repositories.TransportRepository;
@Service
public class TransportService {
	
	@Autowired
	private TransportRepository transportRepository;
	
	@Autowired
	private ShippingCompanyRepository company;


	public List<Transport> findAll() {
		return transportRepository.findAll();
	}
	

	public Transport findById(Long id) {
		Optional <Transport> transp  = transportRepository.findById(id);
		return transp.get();
	}


	public Transport save(@RequestBody Transport transport) {
		return transportRepository.save(transport);
	}
}


