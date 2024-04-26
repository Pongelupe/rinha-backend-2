package br.com.ppongelupe.api.models.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TransacaoDTO {

	@NotNull
	@Min(1)
	private int valor;
	
	@NotBlank
	@Size(min = 1, max = 1)
	@Pattern(regexp = "c|t")
	private String tipo;
	
	@NotBlank
	@Size(min = 1, max = 10)
	private String descricao;
	
}
