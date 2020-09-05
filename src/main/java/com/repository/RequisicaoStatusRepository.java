package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.domain.RequisicaoStatus;

@Repository
public interface RequisicaoStatusRepository extends MongoRepository<RequisicaoStatus, Integer>{
}