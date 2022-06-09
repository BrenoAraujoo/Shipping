package com.shipping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shipping.entities.Transport;
import com.shipping.exceptions.EntityNotFoundException;
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
		return transportRepository.findById(id).orElseThrow(
				()->new EntityNotFoundException("Id not found: " + id));
	}


	public Transport save(Transport transport) {
		return transportRepository.save(transport);
	}
}


