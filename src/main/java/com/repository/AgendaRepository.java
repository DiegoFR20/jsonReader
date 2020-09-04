package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.domain.Agenda;

@Repository
public interface AgendaRepository extends MongoRepository<Agenda, Integer>{
}