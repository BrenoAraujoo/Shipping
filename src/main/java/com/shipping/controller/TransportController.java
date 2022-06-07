package com.shipping.controller;

import java.util.List;

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

import com.shipping.entities.Transport;
import com.shipping.repositories.TransportRepository;

@RestController
@RequestMapping("/Transports")
public class TransportController {
	
	@Autowired
	private TransportRepository transportRepository;
	@GetMapping
	public ResponseEntity<List<Transport>> list(){
		List<Transport> list = transportRepository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Transport add(@RequestBody Transport transport) {
		return transportRepository.save(transport);
	}
	
}
