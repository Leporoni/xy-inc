package com.leporonitech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leporonitech.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
