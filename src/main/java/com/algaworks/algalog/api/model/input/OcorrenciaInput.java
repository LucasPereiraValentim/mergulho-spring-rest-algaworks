package com.algaworks.algalog.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaInput {
	
	@NotBlank(message = "Descrição não pode ser vázia")
	private String descricao;
}
