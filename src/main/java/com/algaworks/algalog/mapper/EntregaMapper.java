package com.algaworks.algalog.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.algalog.api.model.EntregaDTO;
import com.algaworks.algalog.api.model.input.EntregaInputModel;
import com.algaworks.algalog.domain.model.Entrega;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EntregaMapper {
	
	private ModelMapper modelMapper;
	
	public EntregaDTO toDTO(Entrega entrega) {
		return modelMapper.map(entrega, EntregaDTO.class);
	}
	
	public List<EntregaDTO> toListDTO(List<Entrega> entregas){
		List<EntregaDTO> listaDTO = new ArrayList<>();
		
		for (Entrega entrega : entregas) {
			this.toDTO(entrega);
			
			listaDTO.add(this.toDTO(entrega));
			
		}
		
		
		return listaDTO;
	}
	
	
	public Entrega toEntity(EntregaInputModel entregaInput) {
		return modelMapper.map(entregaInput, Entrega.class);
	}
	
}
