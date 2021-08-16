package com.algaworks.algalog.api.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.algalog.api.model.OcorrenciaDTO;
import com.algaworks.algalog.domain.model.Ocorrencia;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OcorrenciaMapper {
	
	private ModelMapper modelMapper;
	
	public OcorrenciaDTO toModel(Ocorrencia ocorrencia) {
		return modelMapper.map(ocorrencia, OcorrenciaDTO.class);
	}
	
	public List<OcorrenciaDTO> toListModel(List<Ocorrencia> ocorrencias){
		List<OcorrenciaDTO> listaDTO = new ArrayList<>();
		
		for (Ocorrencia ocorrencia : ocorrencias) {
			
			 listaDTO.add(modelMapper.map(ocorrencia, OcorrenciaDTO.class));
		}
		
		
		return listaDTO;
	}
}
