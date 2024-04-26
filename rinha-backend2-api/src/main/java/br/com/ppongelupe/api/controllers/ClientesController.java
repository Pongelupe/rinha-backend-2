package br.com.ppongelupe.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ppongelupe.api.models.dto.SaldoDTO;
import br.com.ppongelupe.api.models.dto.TransacaoDTO;
import br.com.ppongelupe.api.services.ClientesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ClientesController {

	private final ClientesService clientesService;

	@PostMapping("/clientes/{id}/transacoes")
	public ResponseEntity<SaldoDTO> insereTransacao(@PathVariable int id, 
			@RequestBody @Valid TransacaoDTO transacao) {
		return ResponseEntity.ok(clientesService.insereTransacao(id, transacao));
	}

}
