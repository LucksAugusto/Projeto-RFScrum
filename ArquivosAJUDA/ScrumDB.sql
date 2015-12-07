CREATE DATABASE ScrumDB
GO
USE ScrumDB

DROP DATABASE ScrumDB

CREATE TABLE ProductOwner (
	idPO INT NOT NULL,
	nome VARCHAR(100) NOT NULL UNIQUE,
	empresa VARCHAR(200) NOT NULL,
	CNPJ VARCHAR(18) NOT NULL,
	endereco VARCHAR(200) NOT NULL,
	dataIng DATE NOT NULL
	PRIMARY KEY(idPO)
	)

CREATE TABLE Programador (
	idProg INT NOT NULL,
	nome VARCHAR(100) NOT NULL UNIQUE,
	RG VARCHAR(100) NOT NULL, 
	salario DECIMAL(7,2) NOT NULL,
	endereço VARCHAR(200) NOT NULL,
	dataContrato DATE NOT NULL,
	experiencia BIT DEFAULT(0) NOT NULL
	PRIMARY KEY(idProg)
	)

CREATE TABLE Projeto (
	codProj INT NOT NULL,
	nomeProj VARCHAR(150) NOT NULL,
	productOwner INT NOT NULL,
	PRIMARY KEY(codProj),
	FOREIGN KEY(productOwner) REFERENCES ProductOwner(idPO)	
	)

CREATE TABLE ProjProg (
	projeto INT NOT NULL,
	programador INT NOT NULL,
	scrumMaster BIT DEFAULT(0) NOT NULL,
	PRIMARY KEY(projeto,programador),
	FOREIGN KEY(projeto) REFERENCES Projeto(codProj),
	FOREIGN KEY(programador) REFERENCES Programador(idProg)
	)

CREATE TABLE ProductBacklog (
	idPB INT NOT NULL,
	projeto INT NOT NULL,
	prioridade CHAR(1) NOT NULL,
	categoria VARCHAR(160) NOT NULL,
	descricao VARCHAR(250) NOT NULL,
	estoria VARCHAR(750) NOT NULL,
	PRIMARY KEY(idPB, projeto),
	FOREIGN KEY(projeto) REFERENCES Projeto(codProj)
	)

CREATE TABLE Tasks (
	nomeTask VARCHAR(25) NOT NULL,
	idProjeto INT NOT NULL,
	categoriaTask VARCHAR(50) NOT NULL,
	descricaoTask VARCHAR(250) NOT NULL,
	pontoTask INT NOT NULL,
	estadoTask BIT DEFAULT(0) NOT NULL,
	numSprint INT
	PRIMARY KEY(nomeTask),
	FOREIGN KEY(idProjeto) REFERENCES Projeto(codProj)
	)

INSERT INTO ProductOwner(idPO, nome, empresa, CNPJ, endereco, dataIng) VALUES (1,'Jesus', 'Google', '123456', 'Rua dos DAHR', '1980-01-15')
INSERT INTO ProductOwner(idPO, nome, empresa, CNPJ, endereco, dataIng) VALUES (2,'Tio', 'San', '654321', 'DAHR das rua', '1999-09-27')

SELECT * FROM ProductOwner