CREATE TABLE projetos (
                          id SERIAL PRIMARY KEY,
                          nome VARCHAR(255) NOT NULL,
                          data_criacao DATE NOT NULL
);

CREATE TABLE funcionarios (
                              id SERIAL PRIMARY KEY,
                              nome VARCHAR(255) NOT NULL,
                              cpf VARCHAR(14) NOT NULL UNIQUE,
                              email VARCHAR(255) NOT NULL UNIQUE,
                              salario DECIMAL(10, 2) NOT NULL
);

CREATE TABLE projeto_funcionario (
                                     projeto_id INT REFERENCES projetos(id) ON DELETE CASCADE,
                                     funcionario_id INT REFERENCES funcionarios(id) ON DELETE CASCADE,
                                     PRIMARY KEY (projeto_id, funcionario_id)
);