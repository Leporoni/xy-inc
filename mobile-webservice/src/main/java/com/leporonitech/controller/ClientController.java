package com.leporonitech.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leporonitech.model.Client;
import com.leporonitech.service.ClientService;

@RestController
public class ClientController {

	@Autowired
	ClientService clientService;
	
	// End points
	
	@RequestMapping(method = RequestMethod.GET, value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Client>> findAllCustomers() {

		Collection<Client> customersFound = clientService.findAllCustomers();
		return new ResponseEntity<>(customersFound, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> searchCustomersForId(@PathVariable Integer id) {

		Client customersFound = clientService.searchForId(id);
		return new ResponseEntity<>(customersFound, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/customer", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> customerRegistration(@RequestBody Client client) {

		Client registeredCustomer = clientService.register(client);
		return new ResponseEntity<>(registeredCustomer, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/customer", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> changeCustomer(@RequestBody Client client) {

		Client customerChanged = clientService.register(client);
		return new ResponseEntity<>(customerChanged, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/customer/{id}")
	public ResponseEntity<Client> deleteCustomer(@PathVariable Integer id) {

		Client customerFound = clientService.searchForId(id);
		if (customerFound == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		clientService.deleteCustomer(customerFound);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	

}
