CREATE UNLOGGED TABLE cliente (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	limite INTEGER NOT NULL,
	saldo INTEGER NOT NULL DEFAULT 0
);

CREATE UNLOGGED TABLE transacao (
	id SERIAL PRIMARY KEY,
	cliente_id INTEGER NOT NULL,
	valor INTEGER NOT NULL,
	tipo CHAR(1) NOT NULL,
	descricao VARCHAR(10) NOT NULL,
	realizada_em TIMESTAMP NOT NULL DEFAULT NOW(),
	CONSTRAINT fk_clientes_transacoes_id
		FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);


DO $$
BEGIN
	INSERT INTO cliente (nome, limite)
	VALUES
		('karl marx', 1000 * 100),
		('friedrich engels', 800 * 100),
		('lenin', 10000 * 100),
		('che guevara', 100000 * 100),
		('mao zedong', 5000 * 100);

END;
$$;
