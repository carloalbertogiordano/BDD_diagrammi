DROP DATABASE IF EXISTS DBMuseo;
CREATE DATABASE DBMuseo;
USE DBMuseo;


CREATE TABLE Clienti(
	ID INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR (20) NOT NULL,
    cognome VARCHAR  (20) NOT NULL,
    ddnascita DATE NOT NULL
);

CREATE TABLE Musei(
	codice VARCHAR (2) PRIMARY KEY,
    nome VARCHAR (20) NOT NULL,
    orarioApertura TIME NOT NULL,
    orarioChiusura TIME  NOT NULL,
    via VARCHAR (20) NOT NULL,
    CAP INT NOT NULL,
    provincia VARCHAR (2) NOT NULL,
    numeroVisite INT NOT NULL
);

CREATE TABLE Visita (
	ID_Cliente INT NOT NULL,
    codiceMuseo VARCHAR (20) NOT NULL,
    dataOraIngresso DATETIME NOT NULL,
    dataOraUscita DATETIME NOT NULL,
    FOREIGN KEY (ID_Cliente) REFERENCES Clienti(ID),
    FOREIGN KEY (codiceMuseo) REFERENCES Musei(codice),
    PRIMARY KEY(ID_Cliente, codiceMuseo, dataOraIngresso, dataOraUscita)
);

CREATE TABLE Artista (
	ID INT PRIMARY KEY,
    nome VARCHAR (30) NOT NULL,
    nazionalità VARCHAR(20) NOT NULL,
    ddnascita DATE NOT NULL,
    ddmorte DATE
);

CREATE TABLE Dipinto (
	nome VARCHAR (50) NOT NULL,
    numero INT NOT NULL,
    altezza FLOAT NOT NULL,
    larghezza FLOAT  NOT NULL,
    profondità FLOAT  NOT NULL,
    quotazione LONG NOT NULL,
    genere VARCHAR (30) NOT NULL,
    dataCreazione INT NOT NULL,
    tecnica VARCHAR (25) NOT NULL,
    ID_Artista INT NOT NULL,
    strumento varchar (20) NOT NULL,
	FOREIGN KEY (ID_Artista) REFERENCES Artista(ID),
    PRIMARY KEY(nome, numero)
);

CREATE TABLE Scultura (
	nome VARCHAR (50) NOT NULL,
    numero INT NOT NULL,
    altezza FLOAT NOT NULL,
    larghezza FLOAT NOT NULL,
    profondità FLOAT  NOT NULL,
    quotazione LONG NOT NULL,
    genere VARCHAR (30) NOT NULL,
    dataCreazione INT NOT NULL,
    peso INT NOT NULL,
    ID_Artista INT NOT NULL,
	strumento varchar (20) NOT NULL,
	FOREIGN KEY (ID_Artista) REFERENCES Artista(ID),
    PRIMARY KEY(nome, numero)
);

CREATE TABLE Materiali (
	ID INT PRIMARY KEY,
    nome VARCHAR (20) NOT NULL
);

CREATE TABLE Altro (
	nome VARCHAR (70) NOT NULL,
    numero INT NOT NULL,
    altezza FLOAT NOT NULL,
    larghezza FLOAT NOT NULL,
    profondità FLOAT NOT NULL,
    quotazione LONG NOT NULL,
    genere VARCHAR (30) NOT NULL,
    dataCreazione INT NOT NULL,
    descrizione VARCHAR (1000) NOT NULL,
    ID_Artista INT NOT NULL,
	strumento varchar (20) NOT NULL,
	FOREIGN KEY (ID_Artista) REFERENCES Artista(ID),
    PRIMARY KEY(nome, numero)
);

CREATE TABLE MostraDipinto (
	codiceMuseo VARCHAR (2),
	nomeDipinto VARCHAR (50) NOT NULL,
	numeroDipinto INT NOT NULL,
	dataOraInizio DATETIME NOT NULL,
    dataOraFine DATETIME NOT NULL,
	FOREIGN KEY (codiceMuseo) REFERENCES Musei(codice),
	FOREIGN KEY (nomeDipinto, numeroDipinto) REFERENCES Dipinto(nome, numero),
    PRIMARY KEY (codiceMuseo, nomeDipinto, numeroDipinto, dataOraInizio, dataOraFine)
);

CREATE TABLE MostraScultura (
	codiceMuseo VARCHAR (2),
	nomeScultura VARCHAR (50) NOT NULL,
	numeroScultura INT NOT NULL,
	dataOraInizio DATETIME NOT NULL,
    dataOraFine DATETIME NOT NULL,
	FOREIGN KEY (nomeScultura, numeroScultura) REFERENCES Scultura(nome, numero),
	FOREIGN KEY (codiceMuseo) REFERENCES Musei(codice),
    PRIMARY KEY (codiceMuseo, nomeScultura, numeroScultura, dataOraInizio, dataOraFine)
);

CREATE TABLE MostraAltro (
	codiceMuseo VARCHAR (2),
	nomeAltro VARCHAR (70) NOT NULL,
	numeroAltro INT NOT NULL,
	dataOraInizio DATETIME NOT NULL,
    dataOraFine DATETIME NOT NULL,
	FOREIGN KEY (codiceMuseo) REFERENCES Musei(codice),
	FOREIGN KEY (nomeAltro, numeroAltro) REFERENCES Altro(nome, numero),
    PRIMARY KEY (codiceMuseo, nomeAltro, numeroAltro, dataOraInizio, dataOraFine)
);

CREATE TABLE Comporre (
	nomeScultura VARCHAR (40) NOT NULL,
    numeroScultura INT NOT NULL,
    ID_Materiale INT NOT NULL,
	FOREIGN KEY (nomeScultura, numeroScultura) REFERENCES Scultura(nome, numero),
	FOREIGN KEY (ID_Materiale) REFERENCES Materiali(ID),
	PRIMARY KEY (nomeScultura, numeroScultura, ID_Materiale)
);