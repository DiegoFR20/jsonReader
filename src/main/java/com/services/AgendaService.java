package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.Agenda;
import com.dto.AgendaDTO;
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
	
	public Agenda insert(Agenda agenda) {
		return repo.insert(agenda);
	}
	
	public void delete(Integer id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Agenda update(Agenda agenda) {
		Agenda newAgenda = findById(agenda.getId());
		updateData(newAgenda, agenda);
		return repo.save(newAgenda);
	}
	
	private void updateData(Agenda newAgenda, Agenda agenda) {
		newAgenda.setId(agenda.getId());
		newAgenda.setHash(agenda.getHash());
		newAgenda.setNome(agenda.getNome());
		newAgenda.setEsfera(agenda.getEsfera());
	}

	public Agenda fromDTO(AgendaDTO agendaDTO) {
		return new Agenda(agendaDTO.getId(), agendaDTO.getHash(), agendaDTO.getNome(), agendaDTO.getEsfera(), agendaDTO.getEdicao());
	}
}