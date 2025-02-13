CREATE DATABASE db_veiculos;
USE db_veiculos;

-- Tabela para Marcas
CREATE TABLE marca (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

-- Tabela para Modelos
CREATE TABLE modelo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    marca_id INT NOT NULL,
    FOREIGN KEY (marca_id) REFERENCES marca(id) ON DELETE CASCADE
);

-- Tabela para Veículos
CREATE TABLE veiculo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    modelo_id INT NOT NULL,
    ano_fabricacao INT NOT NULL,
    cor VARCHAR(50) NOT NULL,
    preco DECIMAL(10,2) CHECK (preco > 0) NOT NULL,
    quilometragem INT CHECK (quilometragem >= 0) NOT NULL,
    status_disponibilidade ENUM('DISPONIVEL', 'VENDIDO', 'RESERVADO') NOT NULL,
    FOREIGN KEY (modelo_id) REFERENCES modelo(id) ON DELETE CASCADE
);

-- Inserindo marcas
INSERT INTO marca (nome) VALUES ('Toyota');
INSERT INTO marca (nome) VALUES ('BYD');

-- Inserindo modelos com os IDs corretos de marca
INSERT INTO modelo (nome, marca_id) VALUES ('Corolla', 1);
INSERT INTO modelo (nome, marca_id) VALUES ('Dolphin', 2);

-- Inserindo veículos com os IDs corretos de modelo
INSERT INTO veiculo (modelo_id, ano_fabricacao, cor, preco, quilometragem, status_disponibilidade)
VALUES (1, 2022, 'Preto', 130000.00, 15000, 'DISPONIVEL');

INSERT INTO veiculo (modelo_id, ano_fabricacao, cor, preco, quilometragem, status_disponibilidade)
VALUES (2, 2023, 'Azul', 120000.00, 8000, 'RESERVADO');
