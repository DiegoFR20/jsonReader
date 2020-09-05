package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.domain.Edicao;

@Repository
public interface EdicaoRepository extends MongoRepository<Edicao, Integer>{
}