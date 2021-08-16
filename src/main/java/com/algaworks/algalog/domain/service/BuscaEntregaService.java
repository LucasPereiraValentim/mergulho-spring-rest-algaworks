package com.algaworks.algalog.domain.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.exception.EntidadeNaoEncontrada;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaEntregaService {
	
	private EntregaRepository entregaRepository;
	
	public Optional<Entrega> buscar(Long entregaId) {
		
		Optional<Entrega> entrega = entregaRepository.findById(entregaId);
		
		if (!entrega.isPresent()) {
			throw new EntidadeNaoEncontrada("Entrega não encontrada");
		} else {
			return entrega;
		}
		
		 
	}
}
