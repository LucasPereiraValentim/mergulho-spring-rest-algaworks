package com.algaworks.algalog.domain.service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.exception.NegocioException;
import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.StatusEntrega;
import com.algaworks.algalog.domain.model.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {
	
	private EntregaRepository entregaRepository;
	
	private CRUDClienteService clienteService;
	
	@Transactional
	public Entrega solicita(Entrega entrega) {
		
		if (entrega.getCliente().getId() == null) {
			throw new NegocioException("Cliente não encontrado");
		} else {
			entrega.setStatus(StatusEntrega.PENDENTE);
			entrega.setDataPedido(OffsetDateTime.now());
			
			Cliente cliente =  clienteService.buscar(entrega.getCliente().getId());
			
			entrega.setCliente(cliente);
			
			
			
			return entregaRepository.save(entrega);
		}
	}
	
}
