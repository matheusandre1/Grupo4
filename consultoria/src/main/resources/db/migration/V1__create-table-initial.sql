-- Criação das tabelas

CREATE TABLE "clientes" (
    "id_cliente" serial PRIMARY KEY,
    "nome_empresa" varchar(100) NOT NULL UNIQUE,
    "nome_responsavel" varchar(100) NOT NULL UNIQUE,
    "cnpj" varchar(14) NOT NULL UNIQUE,
    "data_cadastro" timestamp NOT NULL,
    "telefone" varchar(15) NOT NULL,
    "email" varchar(100) NOT NULL UNIQUE,
    "senha" varchar(300) NOT NULL,
    "tipo_de_usuario" varchar(9),
    "id_consultor" int NOT NULL
);

CREATE TABLE "consultores" (
    "id_consultor" serial PRIMARY KEY,
    "nome_consultor" varchar (50),
    "data_cadastro" date NOT NULL,
    "telefone" varchar(15) NOT NULL,
    "email" varchar(100) NOT NULL UNIQUE,
    "senha" varchar(300) NOT NULL,
    "especializacao" varchar(500),
    "experiencia" varchar(500),
    "tipo_de_usuario" varchar(09)
);

CREATE TABLE "consultas" (
    "id_consulta" serial PRIMARY KEY,
    "data_consulta" date NOT NULL,
    "hora_consulta" varchar(6) NOT NULL,
    "id_cliente" int NOT NULL,
    "id_consultor" int NOT NULL
);

CREATE TABLE "relatorio_de_consultoria" (
    "id_relatorio_de_consultoria" serial PRIMARY KEY,
    "id_consulta" int NOT NULL,
    "id_cliente" int NOT NULL,
    "id_consultor" int NOT NULL
);

CREATE TABLE "feedbacks" (
    "id_feedback" serial PRIMARY KEY,
    "id_cliente" int NOT NULL,
    "data_feedback" timestamp NOT NULL,
    "feedback" varchar(1000)
);

-- Adicionar chaves estrangeiras
ALTER TABLE "clientes" ADD FOREIGN KEY ("id_consultor") REFERENCES "consultores" ("id_consultor");

ALTER TABLE "consultas" ADD FOREIGN KEY ("id_cliente") REFERENCES "clientes" ("id_cliente");

ALTER TABLE "consultas" ADD FOREIGN KEY ("id_consultor") REFERENCES "consultores" ("id_consultor");

ALTER TABLE "relatorio_de_consultoria" ADD FOREIGN KEY ("id_cliente") REFERENCES "clientes" ("id_cliente");

ALTER TABLE "relatorio_de_consultoria" ADD FOREIGN KEY ("id_consultor") REFERENCES "consultores" ("id_consultor");

ALTER TABLE "relatorio_de_consultoria" ADD FOREIGN KEY ("id_consulta") REFERENCES "consultas" ("id_consulta");

ALTER TABLE "feedbacks" ADD FOREIGN KEY ("id_cliente") REFERENCES "clientes" ("id_cliente");
