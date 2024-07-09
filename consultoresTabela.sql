--drop table consultor
--select * from consultor
CREATE TABLE consultor (
  	id_consultor serial,
	nome_consultor varchar(100) NOT NULL,
	especializacao varchar(100) NOT NULL,
	experiencia varchar(100) NOT NULL,
	telefone varchar(15) NOT NULL,
	email varchar(100)  NOT NULL UNIQUE,
    senha varchar(300) NOT NULL,
	data_cadastro timestamp DEFAULT date_trunc('second', CURRENT_TIMESTAMP),
	--CHAVE PRIMÁRIA
	CONSTRAINT consultores_id_consultor_pk PRIMARY KEY(id_consultor)
);




INSERT INTO consultor (nome_consultor, especializacao, experiencia, telefone, email, senha)
VALUES
('Alice Santos', 'Consultoria Financeira', '10 anos', '21987654321', 'alice.santos@example.com', 'senha123'),
('Bruno Almeida', 'Consultoria em TI', '8 anos', '21987654322', 'bruno.almeida@example.com', 'senha123'),
('Carla Souza', 'Consultoria Jurídica', '5 anos', '21987654323', 'carla.souza@example.com', 'carla123'),
('Diego Martins', 'Consultoria de Marketing', '7 anos', '21987654324', 'diego.martins@example.com', 'diego123'),
('Elena Rocha', 'Consultoria de Recursos Humanos', '6 anos', '21987654325', 'elena.rocha@example.com', 'elena123');