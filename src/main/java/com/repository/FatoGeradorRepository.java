package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.domain.FatoGerador;

@Repository
public interface FatoGeradorRepository extends MongoRepository<FatoGerador, Integer>{
}