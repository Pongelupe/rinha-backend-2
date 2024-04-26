package br.com.ppongelupe.api.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaldoDTO {

	private int limite;

	private int saldo;
	
}
