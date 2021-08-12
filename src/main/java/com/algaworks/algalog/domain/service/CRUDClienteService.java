package com.algaworks.algalog.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.exception.NegocioException;
import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.model.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CRUDClienteService {
	
	private ClienteRepository clienteRepository;
	
	@Transactional// deve ser executado dentro de uma transação
	public Cliente salvar(Cliente cliente) {
		
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream().anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if (emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastro com este E-mail");
		}
		 
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void excluir(Long id) {
		clienteRepository.deleteById(id);
	}
}
