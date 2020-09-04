package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.Agenda;
import com.repository.AgendaRepository;
import com.services.exception.ObjectNotFoundException;

@Service
public class AgendaService {

	@Autowired
	private AgendaRepository repo;
	
	public List<Agenda> findAll(){
		return repo.findAll();
	}
	
	public Agenda findById(Integer id) {
		Optional<Agenda> agenda = repo.findById(id);
		return agenda.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}