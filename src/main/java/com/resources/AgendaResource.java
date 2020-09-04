package com.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.domain.Agenda;
import com.dto.AgendaDTO;
import com.services.AgendaService;

@RestController
@RequestMapping(value = "/agendas")
public class AgendaResource {

	@Autowired
	private AgendaService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AgendaDTO>> findAll() {
		List<Agenda> agendaLista = service.findAll();
		List<AgendaDTO> listaDTO = agendaLista.stream().map(x -> new AgendaDTO(x)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listaDTO);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<AgendaDTO> findById(@PathVariable Integer id) {
		Agenda agenda = service.findById(id);
		
		
				
		return ResponseEntity.ok().body(new AgendaDTO(agenda));
	}
}