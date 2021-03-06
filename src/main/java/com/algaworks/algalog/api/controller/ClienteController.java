package com.algaworks.algalog.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import com.algaworks.algalog.domain.service.CRUDClienteService;

import lombok.AllArgsConstructor;
		
@AllArgsConstructor
@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	
	private ClienteRepository clienteRepository;
	
	private CRUDClienteService clienteService;
	
	@GetMapping()
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	@GetMapping(value = "/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
		
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		
		if (cliente.isPresent()) {
			return new ResponseEntity<Cliente>(cliente.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		return clienteService.salvar(cliente);
	}
	
	@PutMapping(value = "/{clienteId}")
	public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteId,
			@RequestBody Cliente cliente){
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		} else {
			cliente.setId(clienteId);
			cliente = clienteService.salvar(cliente);
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		}
	}
	
	@DeleteMapping(value = "/{clienteId}")
	public ResponseEntity<Void> remover(@PathVariable Long clienteId){
		
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		} else {
			clienteService.excluir(clienteId);
			return ResponseEntity.noContent().build();
		}
	}
	
	
}
