package br.com.ppongelupe.api.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column(name = "cliente_id", insertable = false, updatable = false, nullable = false)
	private Integer idCliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@Column(nullable = false)
	private int valor;
	
	@Column(length = 1, nullable = false, name = "tipo")
	private String tipoTransacao;

	@Column(length = 10, nullable = false)
	private String descricao;
	
	@Column(name = "realizada_em")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private LocalDateTime realizadaEm;
	
}
