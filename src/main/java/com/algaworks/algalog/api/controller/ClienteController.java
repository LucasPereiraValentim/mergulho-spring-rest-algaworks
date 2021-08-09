package com.algaworks.algalog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;

@RestController
public class ClienteController {

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		
		Cliente cliente = new Cliente();
		
		cliente.setId(1L);
		cliente.setNome("João");
		cliente.setTelefone("(61) 555-555");
		
		return Arrays.asList(cliente);
	}
	
}
