package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.mapper.EntregaMapper;
import com.algaworks.algalog.api.model.EntregaDTO;
import com.algaworks.algalog.api.model.input.EntregaInputModel;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import com.algaworks.algalog.domain.service.SolicitacaoEntregaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/entregas")
public class EntregaController {
	
	private SolicitacaoEntregaService solicitacaoEntregaService;
	
	private EntregaRepository entregaRepository;
	
	private EntregaMapper entregaMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaDTO solicitar(@Valid @RequestBody EntregaInputModel entregaInputModel) {
		
		Entrega novaEntrega = entregaMapper.toEntity(entregaInputModel);
		
		Entrega entregaSolicita = solicitacaoEntregaService.solicita(novaEntrega);
		
		return entregaMapper.toDTO(entregaSolicita);
	}
	
	@GetMapping
	public List<EntregaDTO> listar(){
		return entregaMapper.toListDTO(entregaRepository.findAll());
	}
	
	@GetMapping(value = "/{entregaId}")
	public ResponseEntity<EntregaDTO> buscar(@PathVariable Long entregaId){
		
		Entrega entrega = entregaRepository.findById(entregaId).get();
		
		
		if (entrega != null) {
			return new ResponseEntity<EntregaDTO>(entregaMapper.toDTO(entrega), HttpStatus.OK);
		} else {
			return ResponseEntity.notFound().build();
		}
		 
	}
	
}
