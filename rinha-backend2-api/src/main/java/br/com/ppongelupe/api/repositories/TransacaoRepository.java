package br.com.ppongelupe.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ppongelupe.api.models.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

	List<Transacao> findTop10ByIdClienteOrderByRealizadaEmDesc(int idCliente);
	
}
