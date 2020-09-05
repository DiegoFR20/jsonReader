package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.domain.Dados;

@Repository
public interface DadosRepository extends MongoRepository<Dados, String>{
}