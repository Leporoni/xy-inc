package com.leporonitech.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leporonitech.model.Client;
import com.leporonitech.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	// Business
	public Client register(Client client) {

		return clientRepository.save(client);

	}

	public Collection<Client> findAllCustomers() {
		return clientRepository.findAll();
	}

	public void deleteCustomer(Client client) {
		clientRepository.delete(client);
	}

	public Client searchForId(Integer id) {
		return clientRepository.findOne(id);
	}

	public Client changeCustomer(Client client) {

		return clientRepository.save(client);
	}
}
