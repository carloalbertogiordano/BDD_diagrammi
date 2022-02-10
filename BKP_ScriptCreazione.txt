drop database if exists DBMuseo;
create database DBMuseo;
use DBMuseo;


create table Clienti(
	ID int AUTO_INCREMENT PRIMARY KEY,
    nome varchar (20) NOT NULL,
    cognome varchar (20) NOT NULL,
    ddnascita date NOT NULL
);

create table Musei(
	codice varchar (20) PRIMARY KEY,
    nome varchar (20) NOT NULL,
    orarioApertura time NOT NULL,
    orarioChiusura varchar (20) NOT NULL,
    via varchar (20) NOT NULL,
    CAP int NOT NULL,
    provincia varchar (2) NOT NULL,
    numeroVisite int NOT NULL
);

create table Visita (
	ID_Cliente int NOT NULL,
    codice_Museo varchar (20) NOT NULL,
    dataOraIngresso datetime NOT NULL,
    dataOraUscita datetime NOT NULL,
    FOREIGN KEY (ID_Cliente) REFERENCES Clienti(ID),
    FOREIGN KEY (codice_Museo) REFERENCES Musei(codice),
    PRIMARY KEY(ID_Cliente, codice_Museo, dataOraIngresso, dataOraUscita)
);

create table Artista (
	ID int PRIMARY KEY,
    nome varchar (30) NOT NULL,
	ddnascita date NOT NULL,
    nazionalità varchar (20) NOT NULL,
    ddmorte int
);

create table Dipinto (
	nome varchar (20) NOT NULL,
    numero int NOT NULL,
    altezza float NOT NULL,
    larghezza float NOT NULL,
    profondità float NOT NULL,
    quotazione long NOT NULL,
    genere varchar (20) NOT NULL,
    dataCreazione date NOT NULL,
    tecnica varchar (15) NOT NULL,
    ID_Artista int NOT NULL,
		FOREIGN KEY (ID_Artista) REFERENCES Artista(ID),
    PRIMARY KEY(nome, numero)
);

create table Scultura (
	nome varchar (20) NOT NULL,
    numero int NOT NULL,
    altezza float NOT NULL,
    larghezza float NOT NULL,
    profondità float NOT NULL,
    quotazione long NOT NULL,
    genere varchar (20) NOT NULL,
    dataCreazione date NOT NULL,
	peso int NOT NULL,
    ID_Artista int NOT NULL,
		FOREIGN KEY (ID_Artista) REFERENCES Artista(ID),
    PRIMARY KEY(nome, numero)
);

create table Materiali (
	ID int PRIMARY KEY,
    nome varchar (20) NOT NULL
);

create table Altro (
	nome varchar (20) NOT NULL,
    numero int NOT NULL,
    altezza float NOT NULL,
    larghezza float NOT NULL,
    profondità float NOT NULL,
    quotazione long NOT NULL,
    genere varchar (20) NOT NULL,
    dataCreazione date NOT NULL,
	descrizione varchar (1000) NOT NULL,
    ID_Artista int NOT NULL,
		FOREIGN KEY (ID_Artista) REFERENCES Artista(ID),
    PRIMARY KEY(nome, numero)
);

create table MostraDipinto (
	codiceMuseo varchar (20),
	nomeDipinto varchar (20) NOT NULL,
	numeroDipinto int NOT NULL,
	dataOraInizio datetime NOT NULL,
    dataOraFine datetime NOT NULL,
		FOREIGN KEY (codiceMuseo) REFERENCES Musei(codice),
		FOREIGN KEY (nomeDipinto, numeroDipinto) REFERENCES Dipinto(nome, numero),
    PRIMARY KEY (codiceMuseo, nomeDipinto, numeroDipinto, dataOraInizio, dataOraFine)
);

create table MostraScultura (
	codiceMuseo varchar (20),
	nomeScultura varchar (20) NOT NULL,
	numeroScultura int NOT NULL,
	dataOraInizio datetime NOT NULL,
    dataOraFine datetime NOT NULL,
		FOREIGN KEY (nomeScultura, numeroScultura) REFERENCES Scultura(nome, numero),
		FOREIGN KEY (codiceMuseo) REFERENCES Musei(codice),
    PRIMARY KEY (codiceMuseo, nomeScultura, numeroScultura, dataOraInizio, dataOraFine)
);

create table MostraAltro (
	codiceMuseo varchar (20),
	nomeAltro varchar (20) NOT NULL,
	numeroAltro int NOT NULL,
	dataOraInizio datetime NOT NULL,
    dataOraFine datetime NOT NULL,
		FOREIGN KEY (codiceMuseo) REFERENCES Musei(codice),
		FOREIGN KEY (nomeAltro, numeroAltro) REFERENCES Altro(nome, numero),
    PRIMARY KEY (codiceMuseo, nomeAltro, numeroAltro, dataOraInizio, dataOraFine)
);

create table Comporre (
	nomeScultura varchar (20) NOT NULL,
    numeroScultura int NOT NULL,
	ID_Materiale int NOT NULL,
		FOREIGN KEY (nomeScultura, numeroScultura) REFERENCES Scultura(nome, numero),
		FOREIGN KEY (ID_Materiale) REFERENCES Materiali(ID),
	PRIMARY KEY (nomeScultura, numeroScultura, ID_Materiale)
);








