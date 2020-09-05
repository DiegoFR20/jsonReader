package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.domain.Obrigacao;

@Repository
public interface ObrigacaoRepository extends MongoRepository<Obrigacao, Integer>{
}