package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.domain.Recolhimento;

@Repository
public interface RecolhimentoRepository extends MongoRepository<Recolhimento, Integer>{
}