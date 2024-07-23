-- Criação das tabelas

CREATE TABLE "usuarios" (
    "id_usuario" serial PRIMARY KEY,
    "usuario" varchar(100) NOT NULL UNIQUE,
    "senha" varchar(100) NOT NULL
);

CREATE TABLE "clientes" (
    "id_cliente" serial PRIMARY KEY,
    "nome_empresa" varchar(100) NOT NULL UNIQUE,
    "nome_responsavel" varchar(100) NOT NULL,
    "cnpj" varchar(18) NOT NULL UNIQUE,
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
    "foto_nome" varchar(100),
    "data_cadastro" timestamp NOT NULL,
    "telefone" varchar(15) NOT NULL,
    "email" varchar(100) NOT NULL UNIQUE,
    "senha" varchar(300) NOT NULL,
    "especializacao" varchar(500),
    "experiencia" varchar(1000),
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


--Criando usuarios consultores

INSERT INTO "consultores" (
    "nome_consultor",
    "foto_nome",
    "data_cadastro",
    "telefone",
    "email",
    "senha",
    "especializacao",
    "experiencia",
    "tipo_de_usuario"

) VALUES (
    'João Victor',                      -- nome_consultor
    'joaovictor.jpg',                   -- foto_nome
    NOW(),                              -- data_cadastro (data e hora atuais)
    '(41) 98652-3587',                   -- telefone
    'joao.silva@tc.com',                 -- email
    '12345',                             -- senha (não esqueça de fazer hash de senhas na prática)
    'Segurança Da Informação',           -- especializacao
    'Com mais de 5 anos de experiência em cibersegurança, tenho atuado como consultor especializado em proteger dados e sistemas críticos contra ameaças digitais. Minha experiência inclui a implementação de políticas de segurança robustas, realização de auditorias de segurança e desenvolvimento de estratégias de resposta a incidentes. Trabalhei com diversas indústrias, oferecendo soluções personalizadas para mitigar riscos e garantir conformidade com regulamentações. Sou apaixonado por identificar vulnerabilidades e fortalecer a segurança das organizações, assegurando a integridade e confidencialidade da informação.consultor.',
    'consultor'),                        -- tipo_de_usuario

    ('Fernando Lima',              -- nome_consultor
     'fernandolima.jpg',           -- foto_nome
     NOW(),                        -- data_cadastro
     '(31) 98774-5632',            -- telefone
     'fernando.lima@tc.com',       -- email
     '12345',                      -- senha (não esqueça de fazer hash de senhas na prática)
     'Desenvolvimento de Software',-- especializacao
     'Com 5 anos de experiência em desenvolvimento de software, sou especializado em criar soluções inovadoras e eficientes para atender às necessidades dos clientes. Minha expertise abrange o desenvolvimento de aplicativos web e móveis, implementação de APIs e integração de sistemas. Trabalho com uma variedade de linguagens de programação e frameworks, garantindo a entrega de código limpo e escalável. Sou apaixonado por resolver problemas complexos e colaborar com equipes para transformar ideias em produtos de alta qualidade que impulsionam o sucesso dos negócios.',       -- experiencia
     'consultor'),                 -- tipo_de_usuario

    ('Roberta Cristina',           -- nome_consultor
     'robertacristina.jpg',        -- foto_nome
     NOW(),                        -- data_cadastro
     '(21) 98741-2365',            -- telefone
     'roberta.cristina@tc.com',    -- email
     '12345',                      -- senha (não esqueça de fazer hash de senhas na prática)
     'Infraestrutura de TI',       -- especializacao
     'Com mais de 7 anos de experiência em infraestrutura de TI, especializo-me em projetar e otimizar ambientes tecnológicos para garantir desempenho e escalabilidade. Minha expertise inclui a implementação de soluções de rede, gerenciamento de servidores e armazenamento, e a integração de sistemas para atender às necessidades de negócios. Tenho um histórico comprovado em otimização de recursos, resolução de problemas complexos e suporte contínuo para garantir a disponibilidade e segurança dos sistemas. Comprometido com a inovação e a eficiência, trabalho para criar infraestruturas robustas que impulsionam o sucesso das organizações.',       -- experiencia
     'consultor'),

     ('Rafael Santos',             -- nome_consultor
      'rafaelsantos.jpg',          -- foto_nome
      NOW(),                       -- data_cadastro
      '(72) 98752-369',            -- telefone
      'rafaelsantos@tc.com',       -- email
      '12345',             -- senha (não esqueça de fazer hash de senhas na prática)
      'Big Data e Análise de Dados', -- especializacao
      'Com 8 anos de experiência em Big Data e análise de dados, especializo-me em transformar grandes volumes de dados em insights acionáveis que impulsionam a tomada de decisões estratégicas. Minha expertise inclui a implementação de soluções de processamento de dados, análise preditiva e visualização avançada, utilizando ferramentas como Hadoop, Spark e ferramentas de BI. Trabalhei com diversas indústrias para otimizar processos, identificar tendências e fornecer recomendações baseadas em dados que agregam valor e impulsionam o crescimento dos negócios.',       -- experiencia
      'consultor'),                  -- tipo_de_usuario

      ('Jéssica Batista',           -- nome_consultor
       'jessicabatista.jpg',        -- foto_nome
       NOW(),                       -- data_cadastro
       'Jéssica Batista',           -- telefone
       'jessica.batista@tc.com',    -- email
       '12345',                     -- senha (não esqueça de fazer hash de senhas na prática)
       'Inteligência Artificial e Machine Learning', -- especializacao
       'Com 7 anos de experiência em engenharia de Inteligência Artificial, sou especialista em projetar e implementar soluções baseadas em IA para resolver problemas complexos e otimizar processos. Minha expertise abrange o desenvolvimento de modelos de machine learning, processamento de linguagem natural e análise preditiva. Tenho um histórico comprovado na construção de sistemas inteligentes que melhoram a eficiência operacional e proporcionam insights valiosos. Trabalho com tecnologias avançadas e frameworks para entregar soluções inovadoras que atendem às necessidades específicas dos negócios.',      -- experiencia
       'consultor'),                -- tipo_de_usuario

       ('Jhonatan Barros',          -- nome_consultor
       'jhonatanbarros.jpg',        -- foto_nome
       NOW(),                       -- data_cadastro
       '(42) 98725-8746',           -- telefone
       'jhonatanbarros@tc.com',     -- email
       '12345',                     -- senha (não esqueça de fazer hash de senhas na prática)
       'Computação em Nuvem',       -- especializacao
       'Com uma sólida experiência de 6 anos em computação em nuvem, sou especialista em arquitetar e gerenciar soluções em ambientes de nuvem para otimizar desempenho e reduzir custos. Tenho um histórico de sucesso na migração de sistemas para a nuvem, implementação de estratégias de alta disponibilidade e segurança, e integração de serviços de nuvem com infraestruturas existentes. Minha abordagem é focada em criar soluções escaláveis e flexíveis que atendam às necessidades de negócios em constante evolução, garantindo eficiência e inovação contínua.',       -- experiencia
       'consultor'),                -- tipo_de_usuario

        ('Vanessa Delgado',         -- nome_consultor
        'vanessadelgado.jpg',       -- foto_nome
        NOW(),                      -- data_cadastro
        '(41) 98745-2365',          -- telefone
        'vanessa.delgado@tc.com',   -- email
        '12345',                    -- senha (não esqueça de fazer hash de senhas na prática)
        'Consultoria em ERP',       -- especializacao
        'Com 6 anos de experiência em consultoria de ERP, sou especialista em otimizar e integrar sistemas empresariais para melhorar a eficiência e a gestão organizacional. Minha expertise inclui a implementação de soluções ERP, customização de módulos e treinamento de equipes para garantir uma adoção eficaz. Trabalhei com diversas indústrias para mapear processos, identificar necessidades e configurar sistemas que alinham operações e suportam o crescimento dos negócios. Comprometido com a excelência, ofereço soluções personalizadas que aumentam a produtividade e a visibilidade dos processos empresariais.',       -- experiencia
        'consultor'),               -- tipo_de_usuario

        ('Lázaro de Souza',         -- nome_consultor
        'lazarodesouza.jpg',        -- foto_nome
        NOW(),                      -- data_cadastro
        '(31) 98745-2365',          -- telefone
        'lazaro.de.souza@tc.com',   -- email
        '12345',                    -- senha (não esqueça de fazer hash de senhas na prática)
        'Desenvolvimento de Software',  -- especializacao
        'Com 8 anos de experiência em gerenciamento de projetos de TI, sou especialista em liderar e coordenar iniciativas tecnológicas para garantir a entrega bem-sucedida dentro do prazo e do orçamento. Minha expertise inclui planejamento estratégico, gerenciamento de riscos e comunicação eficaz com equipes multifuncionais. Tenho um histórico de sucesso na implementação de soluções tecnológicas que atendem às metas de negócios e melhoram a eficiência operacional. Comprometido com a excelência, trabalho para assegurar que projetos complexos sejam concluídos com qualidade e alinhados aos objetivos organizacionais.',       -- experiencia
        'consultor'),               -- tipo_de_usuario

        ('Daiane Amaral',           -- nome_consultor
        'daianeamaral.jpg',         -- foto_nome
        NOW(),                      -- data_cadastro
        '(41) 98756-3258',          -- telefone
        'daiane.amaral@tc.com',     -- email
        '12345',                    -- senha (não esqueça de fazer hash de senhas na prática)
        'DevOps e Automação',       -- especializacao
        'Com 6 anos de experiência em DevOps e automação, sou especializado em otimizar o ciclo de vida do desenvolvimento de software através da integração contínua e entrega contínua (CI/CD). Minha expertise inclui a implementação de pipelines de automação, gerenciamento de ambientes de infraestrutura como código e otimização de processos de deployment. Tenho um histórico de sucesso em melhorar a colaboração entre equipes de desenvolvimento e operações, reduzindo o tempo de entrega e aumentando a qualidade do software. Trabalho para criar soluções escaláveis e robustas que impulsionam a eficiência e a inovação.',       -- experiencia
        'consultor');