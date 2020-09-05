package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.domain.Evento;

@Repository
public interface EventoRepository extends MongoRepository<Evento, Integer>{
}