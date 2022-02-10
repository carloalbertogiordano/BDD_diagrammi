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
    orarioChiusura time NOT NULL,
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
insert into Clienti values (0, "Mauro", "Rossi", '1950-09-19');
insert into Clienti (nome, cognome, ddnascita) values ("Maccio", "Capatonda", '1978-03-07');
insert into Clienti (nome, cognome, ddnascita) values ("Filippo", "Bianchi", '2001-04-02');
insert into Clienti (nome, cognome, ddnascita) values ("Gianluca", "Verdi", '2003-12-31');
insert into Clienti (nome, cognome, ddnascita) values ("Peppino", "Grigi", '1989-05-28');
insert into Clienti (nome, cognome, ddnascita) values ("Fausto", "Neri", '1974-10-14');
insert into Clienti (nome, cognome, ddnascita) values ("Mattia", "Blu", '1964-02-20');
insert into Clienti (nome, cognome, ddnascita) values ("Augusta", "Mazzi", '1986-06-10');
insert into Clienti (nome, cognome, ddnascita) values ("Lia", "Manfrin", '1940-07-06');
insert into Clienti (nome, cognome, ddnascita) values ("Alvaro", "Milano", '2005-08-09');
insert into Clienti (nome, cognome, ddnascita) values ("Manfredo", "Romani", '1937-11-15');
insert into Clienti (nome, cognome, ddnascita) values ("Mirella", "Trentini", '2002-03-26');
insert into Clienti (nome, cognome, ddnascita) values ("Annibale", "Bianchi", '1962-04-17');
insert into Clienti (nome, cognome, ddnascita) values ("Adelchi", "Lucciano", '1930-05-02');
insert into Clienti (nome, cognome, ddnascita) values ("Bonacata", "Rizzo", '1957-08-31');
insert into Clienti (nome, cognome, ddnascita) values ("Cora", "Castiglione", '1973-02-28');
insert into Clienti (nome, cognome, ddnascita) values ("Abbondio", "Onio", '1968-07-10');
insert into Clienti (nome, cognome, ddnascita) values ("Antonella", "Calabresi", '1963-09-19');
insert into Clienti (nome, cognome, ddnascita) values ("Gregorio", "Udinesi", '1998-06-14');
insert into Clienti (nome, cognome, ddnascita) values ("Eberardo", "Lombardo", '1919-12-20');
insert into Clienti (nome, cognome, ddnascita) values ("Giraldo", "Schiavone", '1970-04-06');
insert into Clienti (nome, cognome, ddnascita) values ("Roberto", "Calabresi", '1993-06-20');
insert into Clienti (nome, cognome, ddnascita) values ("Arnaldo", "Giordano", '1955-12-11');
insert into Clienti (nome, cognome, ddnascita) values ("Cordelia", "Zettici", '2000-03-14');
insert into Clienti (nome, cognome, ddnascita) values ("Amalia", "Bellucci", '1999-07-13');
insert into Clienti (nome, cognome, ddnascita) values ("Marco", "De Rose", '1978-03-30');
insert into Clienti (nome, cognome, ddnascita) values ("Giovanna", "Manna", '1988-08-18');
insert into Clienti (nome, cognome, ddnascita) values ("Ferdinanda", "Nanda", '1949-02-28');
insert into Clienti (nome, cognome, ddnascita) values ("Alfreda", "Genovesi", '1955-11-26');
insert into Clienti (nome, cognome, ddnascita) values ("Abelino", "Trevisani", '1980-06-17');
insert into Clienti (nome, cognome, ddnascita) values ("Mariano", "Monaldo", '1001-01-01');
insert into Clienti (nome, cognome, ddnascita) values ("Grazia", "Russo", '1983-08-21');
insert into Clienti (nome, cognome, ddnascita) values ("Clorinda", "Toscani", '1969-09-23');
insert into Clienti (nome, cognome, ddnascita) values ("Elena", "Greece", '1996-02-10');
insert into Clienti (nome, cognome, ddnascita) values ("Gerardino", "Padovano", '1981-04-19');
insert into Clienti (nome, cognome, ddnascita) values ("Taziano", "Trevisano", '1997-08-02');
insert into Clienti (nome, cognome, ddnascita) values ("Lucio", "Manfredi", '1949-03-12');
insert into Clienti (nome, cognome, ddnascita) values ("Manuele", "Mazzanti", '1946-01-01');
insert into Clienti (nome, cognome, ddnascita) values ("Agata", "Lombardi", '1989-03-16');
insert into Clienti (nome, cognome, ddnascita) values ("Rocco", "Zettici", '1996-12-20');

insert into Musei values ("A1", "Museo di Arte", "08:30:00", "20:30:00", "Via roma", 80134, "NA", 0);
insert into Musei values ("A2", "Museo Bellissimo", "09:00:00", "18:00:00", "Via bella", 84121, "SA", 0);
insert into Musei values ("A3", "Museo delle opere", "08:00:00", "19:00:00", "Via dei pioppi", 81100, "CE", 0);
insert into Musei values ("A4", "Museissimo insieme", "10:30:00", "22:30:00", "Via delle madonne", 83100, "AV", 0);

insert into Visita values (1, "A1", '2012-03-1 20:00:00', '2012-03-1 20:30:00');
insert into Visita values (2, "A1", '2011-05-3 09:00:00', '2011-05-3 10:00:00');
insert into Visita values (3, "A1", '2010-09-29 12:00:00', '2010-09-29 13:00:00');
insert into Visita values (4, "A1", '2014-12-03 15:00:00', '2014-12-03 17:00:00');
insert into Visita values (5, "A2", '2014-02-03 16:00:00', '2014-02-03 18:00:00');
insert into Visita values (6, "A2", '2015-03-04 17:00:00', '2015-03-04 17:55:00');
insert into Visita values (7, "A2", '2015-03-04 17:00:00', '2015-03-04 17:20:00');
insert into Visita values (8, "A2", '2016-04-14 09:30:00', '2016-04-14 11:30:00');
insert into Visita values (9, "A3", '2011-02-09 08:00:00', '2011-02-09 09:00:00');
insert into Visita values (10, "A3", '2012-02-09 09:00:00', '2012-02-09 11:00:00');
insert into Visita values (11, "A3", '2012-03-01 10:30:00', '2012-03-01 11:30:00');
insert into Visita values (12, "A3", '2013-06-12 12:30:00', '2013-06-12 15:40:00');
insert into Visita values (12, "A4", '2020-02-13 11:00:00', '2020-02-13 12:25:00');
insert into Visita values (13, "A4", '2020-12-02 14:20:00', '2020-12-02 17:20:00');
insert into Visita values (14, "A4", '2012-04-23 16:30:00', '2012-04-23 16:30:00');
insert into Visita values (15, "A4", '2016-02-26 18:30:00', '2016-02-26 19:00:00');
insert into Visita values (16, "A1", '2018-05-21 11:00:00', '2018-05-21 15:00:00');
insert into Visita values (17, "A2", '2017-05-16 11:30:00', '2017-05-16 13:30:00');
insert into Visita values (18, "A3", '2014-08-16 15:00:00', '2014-08-16 16:30:00');
insert into Visita values (19, "A4", '2019-11-05 12:50:00', '2019-11-05 14:50:00');
insert into Visita values (20, "A1", '2022-01-21 17:00:00', '2022-01-21 20:30:00');
insert into Visita values (21, "A1", '2010-07-11 17:00:00', '2010-07-11 18:00:00');
insert into Visita values (22, "A1", '2017-08-14 12:00:00', '2017-08-14 15:00:00');
insert into Visita values (23, "A1", '2019-11-21 9:45:00', '2019-11-21 9:55:00');
insert into Visita values (24, "A2", '2017-06-18 12:00:00', '2017-06-18 12:40:00');
insert into Visita values (25, "A2", '2017-05-20 12:00:00', '2017-05-20 15:00:00');
insert into Visita values (26, "A2", '2017-06-20 10:20:00', '2017-06-20 17:20:00');
insert into Visita values (27, "A2", '2018-07-22 14:40:00', '2018-07-22 18:00:00');
insert into Visita values (28, "A3", '2015-10-21 18:00:00', '2015-10-21 19:00:00');
insert into Visita values (29, "A3", '2015-11-11 11:00:00', '2015-11-11 13:00:00');
insert into Visita values (30, "A3", '2016-11-11 11:00:00', '2016-11-11 16:21:00');
insert into Visita values (31, "A3", '2017-01-16 14:00:00', '2017-01-16 15:00:00');
insert into Visita values (32, "A4", '2019-11-05 15:50:00', '2019-11-05 17:50:00');
insert into Visita values (33, "A4", '2022-02-23 17:10:00', '2022-02-23 22:10:00');
insert into Visita values (34, "A4", '2022-02-24 17:00:00', '2022-02-24 17:10:00');
insert into Visita values (35, "A4", '2022-02-26 16:55:00', '2022-02-26 17:10:00');
insert into Visita values (36, "A1", '2014-11-21 9:12:00', '2019-11-21 16:00:00');
insert into Visita values (37, "A2", '2018-09-12 14:23:00', '2018-09-12 17:00:00');
insert into Visita values (38, "A3", '2017-03-18 09:00:00', '2017-03-18 10:15:00');
insert into Visita values (39, "A1", '2019-03-13 8:30:00', '2019-03-13 20:30:00');
insert into Visita values (23, "A1", '2019-01-01 15:30:00', '1999-01-01 15:59:00');
insert into Visita values (15, "A1", '2019-05-01 16:30:00', '2019-05-01 16:30:00');
insert into Visita values (2, "A1", '2016-11-08 17:29:00', '2016-11-08 19:35:00');
insert into Visita values (17, "A2", '2019-10-21 17:00:00', '2019-10-21 17:59:00');
insert into Visita values (16, "A2", '2019-10-21 12:00:00', '2019-10-21 14:00:00');
insert into Visita values (33, "A2", '2022-01-12 9:00:00', '2022-01-12 12:00:00');
insert into Visita values (19, "A2", '2012-05-02 17:33:00', '2012-05-02 18:30:00');
insert into Visita values (24, "A3", '2020-07-23 16:00:00', '2020-07-23 17:30:00');
insert into Visita values (2, "A3", '2020-08-23 16:00:00', '2020-08-23 16:00:00');
insert into Visita values (5, "A3", '2020-07-23 16:00:00', '2020-07-23 16:00:00');





