package com.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<AgendaDTO> findById(@PathVariable Integer id) {
		Agenda agenda = service.findById(id);
		
		return ResponseEntity.ok().body(new AgendaDTO(agenda));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody AgendaDTO agendaDTO) {
		Agenda agenda = service.fromDTO(agendaDTO);
		agenda = service.insert(agenda);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(agenda.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody AgendaDTO agendaDTO, @PathVariable Integer id) {
		Agenda agenda = service.fromDTO(agendaDTO);
		agenda.setId(id);
		agenda = service.update(agenda);
		return ResponseEntity.noContent().build();
	}
}