package br.com.ppongelupe.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ppongelupe.api.models.Cliente;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

}
