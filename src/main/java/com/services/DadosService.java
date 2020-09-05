package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.Dados;
import com.dto.DadosDTO;
import com.repository.DadosRepository;
import com.services.exception.ObjectNotFoundException;

@Service
public class DadosService {

	@Autowired
	private DadosRepository repo;
	
	public List<Dados> findAll(){
		return repo.findAll();
	}
	
	public Dados findById(String id) {
		Optional<Dados> Dados = repo.findById(id);
		return Dados.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Dados insert(Dados Dados) {
		return repo.insert(Dados);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Dados update(Dados Dados) {
		Dados newDados = findById(Dados.getId());
		updateData(newDados, Dados);
		return repo.save(newDados);
	}
	
	private void updateData(Dados newDados, Dados Dados) {
		newDados.setId(Dados.getId());
		newDados.setVersao(Dados.getVersao());
		newDados.setRequisicaoStatus(Dados.getRequisicaoStatus());
		newDados.setAgenda(Dados.getAgenda());
	}

	public Dados fromDTO(DadosDTO DadosDTO) {
		return new Dados(DadosDTO.getVersao(), DadosDTO.getRequisicaoStatus(), DadosDTO.getAgenda());
	}
}