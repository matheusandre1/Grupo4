-- Drop das tabelas, caso existam
DROP TABLE IF EXISTS "feedbacks";
DROP TABLE IF EXISTS "relatorio_de_consultoria";
DROP TABLE IF EXISTS "consultas";
DROP TABLE IF EXISTS "clientes";
DROP TABLE IF EXISTS "consultores" CASCADE;

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
    "consultor_id" int NOT NULL
);

CREATE TABLE "consultores" (
    "id_consultor" serial PRIMARY KEY,
    "data_cadastro" date NOT NULL,
    "telefone" varchar(15) NOT NULL,
    "email" varchar(100) NOT NULL UNIQUE,
    "senha" varchar(300) NOT NULL,
    "data_de_nascimento" date NOT NULL,
    "especializacao" varchar(500),
    "experiencia" varchar(500)
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
    "consulta_id" int NOT NULL,
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
ALTER TABLE "clientes" ADD FOREIGN KEY ("consultor_id") REFERENCES "consultores" ("id_consultor");

ALTER TABLE "consultas" ADD FOREIGN KEY ("id_cliente") REFERENCES "clientes" ("id_cliente");

ALTER TABLE "consultas" ADD FOREIGN KEY ("id_consultor") REFERENCES "consultores" ("id_consultor");

ALTER TABLE "relatorio_de_consultoria" ADD FOREIGN KEY ("id_cliente") REFERENCES "clientes" ("id_cliente");

ALTER TABLE "relatorio_de_consultoria" ADD FOREIGN KEY ("id_consultor") REFERENCES "consultores" ("id_consultor");

ALTER TABLE "relatorio_de_consultoria" ADD FOREIGN KEY ("consulta_id") REFERENCES "consultas" ("id_consulta");

ALTER TABLE "feedbacks" ADD FOREIGN KEY ("id_cliente") REFERENCES "clientes" ("id_cliente");
