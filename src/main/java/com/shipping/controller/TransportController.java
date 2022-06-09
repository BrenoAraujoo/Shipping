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
import com.shipping.service.TransportService;

@RestController
@RequestMapping("/Transports")
public class TransportController {

	@Autowired
	private TransportService transportService;

	@GetMapping
	public ResponseEntity<List<Transport>> list() {
		List<Transport> list = transportService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Transport> findById(@PathVariable Long id){
		Transport transp = transportService.findById(id);
		return ResponseEntity.ok().body(transp);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Transport> save(@RequestBody Transport transport) {
		transport = transportService.save(transport);
		return ResponseEntity.ok().body(transport);
	}
}
