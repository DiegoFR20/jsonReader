package com.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.domain.Dados;
import com.dto.DadosDTO;
import com.services.DadosService;

@RestController
@RequestMapping(value = "/")
@CrossOrigin
public class DadosResource {

	@Autowired
	private DadosService service;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DadosDTO>> findAll() {
		
		List<Dados> dados = service.findAll();
		List<DadosDTO> listaDTO = dados.stream().map(x -> new DadosDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listaDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<DadosDTO> findById(@PathVariable String id) {
		Dados Dados = service.findById(id);

		return ResponseEntity.ok().body(new DadosDTO(Dados));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody DadosDTO DadosDTO) {
		System.out.println(DadosDTO.getAgenda());
		Dados Dados = service.fromDTO(DadosDTO);

		Dados = service.insert(Dados);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Dados.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody DadosDTO DadosDTO, @PathVariable String id) {
		Dados Dados = service.fromDTO(DadosDTO);
		Dados.setId(id);
		Dados = service.update(Dados);
		return ResponseEntity.noContent().build();
	}
}