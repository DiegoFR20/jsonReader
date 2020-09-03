package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.Agenda;
import com.repository.AgendaRepository;

@Service
public class AgendaService {

	@Autowired
	private AgendaRepository repo;
	
	public List<Agenda> findAll(){
		return repo.findAll();
	}
}
