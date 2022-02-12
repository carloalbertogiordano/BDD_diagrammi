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
	codice varchar (2) PRIMARY KEY,
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
    codiceMuseo varchar (20) NOT NULL,
    dataOraIngresso datetime NOT NULL,
    dataOraUscita datetime NOT NULL,
    FOREIGN KEY (ID_Cliente) REFERENCES Clienti(ID),
    FOREIGN KEY (codiceMuseo) REFERENCES Musei(codice),
    PRIMARY KEY(ID_Cliente, codiceMuseo, dataOraIngresso, dataOraUscita)
);

create table Artista (
	ID int PRIMARY KEY,
    nome varchar (30) NOT NULL,
    nazionalità varchar (20) NOT NULL,
    ddnascita date NOT NULL,
    ddmorte date
);

create table Dipinto (
	nome varchar (50) NOT NULL,
    numero int NOT NULL,
    altezza float NOT NULL,
    larghezza float NOT NULL,
    profondità float NOT NULL,
    quotazione long NOT NULL,
    genere varchar (30) NOT NULL,
    dataCreazione int NOT NULL,
    tecnica varchar (25) NOT NULL,
    ID_Artista int NOT NULL,
		FOREIGN KEY (ID_Artista) REFERENCES Artista(ID),
    PRIMARY KEY(nome, numero)
);

create table Scultura (
	nome varchar (50) NOT NULL,
    numero int NOT NULL,
    altezza float NOT NULL,
    larghezza float NOT NULL,
    profondità float NOT NULL,
    quotazione long NOT NULL,
    genere varchar (30) NOT NULL,
    dataCreazione int NOT NULL,
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
	nome varchar (70) NOT NULL,
    numero int NOT NULL,
    altezza float NOT NULL,
    larghezza float NOT NULL,
    profondità float NOT NULL,
    quotazione long NOT NULL,
    genere varchar (30) NOT NULL,
    dataCreazione int NOT NULL,
    descrizione varchar (1000) NOT NULL,
    ID_Artista int NOT NULL,
		FOREIGN KEY (ID_Artista) REFERENCES Artista(ID),
    PRIMARY KEY(nome, numero)
);

create table MostraDipinto (
	codiceMuseo varchar (2),
	nomeDipinto varchar (50) NOT NULL,
	numeroDipinto int NOT NULL,
	dataOraInizio datetime NOT NULL,
    dataOraFine datetime NOT NULL,
		FOREIGN KEY (codiceMuseo) REFERENCES Musei(codice),
		FOREIGN KEY (nomeDipinto, numeroDipinto) REFERENCES Dipinto(nome, numero),
    PRIMARY KEY (codiceMuseo, nomeDipinto, numeroDipinto, dataOraInizio, dataOraFine)
);

create table MostraScultura (
	codiceMuseo varchar (2),
	nomeScultura varchar (50) NOT NULL,
	numeroScultura int NOT NULL,
	dataOraInizio datetime NOT NULL,
    dataOraFine datetime NOT NULL,
		FOREIGN KEY (nomeScultura, numeroScultura) REFERENCES Scultura(nome, numero),
		FOREIGN KEY (codiceMuseo) REFERENCES Musei(codice),
    PRIMARY KEY (codiceMuseo, nomeScultura, numeroScultura, dataOraInizio, dataOraFine)
);

create table MostraAltro (
	codiceMuseo varchar (2),
	nomeAltro varchar (70) NOT NULL,
	numeroAltro int NOT NULL,
	dataOraInizio datetime NOT NULL,
    dataOraFine datetime NOT NULL,
		FOREIGN KEY (codiceMuseo) REFERENCES Musei(codice),
		FOREIGN KEY (nomeAltro, numeroAltro) REFERENCES Altro(nome, numero),
    PRIMARY KEY (codiceMuseo, nomeAltro, numeroAltro, dataOraInizio, dataOraFine)
);

create table Comporre (
	nomeScultura varchar (40) NOT NULL,
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
insert into Visita values (2, "A2", '2015-12-16 10:30:00', '2015-12-16 12:30:00');
insert into Visita values (17, "A1", '2018-11-08 17:30:00', '2018-11-08 18:29:00');
insert into Visita values (16, "A4", '2019-12-05 15:50:00', '2019-12-05 16:50:00');
insert into Visita values (33, "A3", '2020-01-12 11:00:00', '2020-01-12 13:00:00');
insert into Visita values (15, "A1", '2013-05-02 12:15:00', '2013-05-02 12:15:00');
insert into Visita values (21, "A2", '2015-12-12 11:30:00', '2015-12-12 11:30:00');
insert into Visita values (9, "A4", '2022-02-11 20:00:00', '2023-02-11 22:00:00');
insert into Visita values (35, "A1", '2019-01-21 08:40:00', '2019-01-21 15:50:00');
insert into Visita values (7, "A4", '2022-01-11 20:40:00', '2022-01-11 21:40:00');
insert into Visita values (20, "A3", '2019-08-23 11:00:00', '2019-08-23 12:00:00');
#Pittori
insert into Artista values (1, "Picasso", "Spagna", '1881-10-25', '1998-10-18');
insert into Artista values (2, "Leonardo Da Vinci", "Italia", '1452-04-15', '1519-05-2');
insert into Artista values (3, "Michelangelo", "Italia", '1475-03-06', '1564-02-18');
insert into Artista values (4, "Van Gogh", "Paesi Bassi", '1853-03-30', '1890-07-29');
insert into Artista values (5, "Rembrandt", "Olanda", '1606-07-15', '1669-10-04');
insert into Artista values (6, "Monet", "Francia", '1840-11-14', '1926-12-05');
insert into Artista values (7, "Dalì", "Spagna", '1904-05-11', '1989-01-23');
insert into Artista values (8, "Cezanne", "Francia", '1839-01-19', '1906-12-22');
insert into Artista values (9, "Goya", "Spagna", '1746-03-30', '1828-04-16');
insert into Artista values (10, "Renoir", "Francia", '1841-02-25', '1919-12-03');
insert into Artista values (11, "Hirst", "Inghilterra", '1965-05-07', null);
insert into Artista values (12, "Canova", "Italia", '1757-11-01', '1822-08-13');
insert into Artista values (13, "Yayoi Kusama", "Giappone", '1929-03-22', null);
insert into Artista values (14, "Botticelli", "Italia", '1445-03-01', '1510-05-17');
#Scultori
insert into Artista values (15, "Rodin", "Francia", '1840-11-12', '1917-11-17');
insert into Artista values (16, "Donatello", "Italia", '1380-01-01', '1466-12-13');
insert into Artista values (17, "Koons", "USA", '1955-01-21', null);
insert into Artista values (18, "Ghiberti", "Italia", '1378-01-01', '1455-12-01');
insert into Artista values (19, "Duchamp", "Francia", '1887-07-28', '1968-10-02');
insert into Artista values (20, "Andy Warhol", "USA", '1928-10-06', '1987-02-22');
insert into Artista values (21, "Brunelleschi", "Italia", '1377-01-01', '1446-04-15');
#architetto
insert into Artista values (22, "Eiffelle", "Francia", '1832-12-15', '1923-12-27');
insert into Artista values (23, "Renzo Piano", "Italia", '1937-09-14', null);
#fotografo
insert into Artista values (24, "David Bailey", "Inghilterra", '1938-01-02', null);

insert into Dipinto values ("Ragazzo con pipa", 1, 100, 81, 5, 104000000, "Periodo rosa", 1905, "Olio su tela",  1);
insert into Dipinto values ("Ragazzo con pipa", 2, 50, 40, 5, 1000, "Periodo rosa", 1903, "Olio su tela",  1);
insert into Dipinto values ("Ragazzo con pipa", 3, 50, 40, 5, 800, "Periodo rosa", 1900, "Olio su tela",  1);
insert into Dipinto values ("Gioconda", 2, 77, 53, 10, 50000000000, "Rinascimentale", 1503, "Olio su tavola di pioppo",  2);
insert into Dipinto values ("David De Rohan", 5, 17, 7, 0, 100000, "Rinascimentale", 1502, "Appunti",  3);
insert into Dipinto values ("Notte stellata", 1, 35, 57, 7, 2000, "Pittura paesaggistica", 1886, "Oleografia su tela",  4);
insert into Dipinto values ("Notte stellata", 2, 35, 57, 7, 2000, "Pittura paesaggistica", 1886, "Oleografia su tela",  4);
insert into Dipinto values ("Cristo nella tempesta sul mare di Galilea", 2, 160, 128, 20, 700000, "Periodo d'oro Olandese", 1633, "Olio su tela",  5);
insert into Dipinto values ("La Grenouillère", 1, 66, 81, 12, 400000, "Impressionismo", 1869, "Olio su tela",  6);
insert into Dipinto values ("La persistenza della memoria", 1, 24, 33, 3, 100000000, "Surrealismo", 1931, "Olio su tela",  7);
insert into Dipinto values ("I giocatori di carte", 2, 47, 57, 8, 250000000, "post-impressionismo", 1890, "Olio su tela",  8);
insert into Dipinto values ("Saturno che divora i suoi figli", 1, 146, 83, 24, 40000000, "Uscita dal neoclassicismo", 1821, "Olio su tela",  9);
insert into Dipinto values ("Bal au moulin de la Galette", 1, 131, 175, 22, 20000000, "Impressionismo", 1876, "Olio su tela",  10);
insert into Dipinto values ("Flumequine", 14, 140, 110, 0, 600000, "Astrattismo", '2007', "Digitale",  11);
insert into Dipinto values ("Venere con Amore in fasce", 3, 132, 82, 18, 700000, "Neoclassicismo", 1789, "Olio su tela", 12);
insert into Dipinto values ("Butterfly", 1, 38, 45, 8, 11100, "Pittura animale", 1988, "Concettuale",  13);
insert into Dipinto values ("Primavera", 1, 203, 314, 37, 50000000000, "Tempera su tavola", 1477, "Rinascimentale",  14);
insert into Dipinto values ("Primavera", 2, 100, 150, 37, 50000, "Tempera su tavola", 1470, "Rinascimentale",  14);
insert into Dipinto values ("Primavera", 3, 300, 600, 37, 3000000, "Tempera su tavola", 1465, "Rinascimentale",  14);
insert into Dipinto values ("Nascita di venere", 2, 172, 278, 28,55000000,"tempera su tela", 1485, "Rinascimentale",  14);
insert into Dipinto values ("Guernica", 1, 349, 776, 50, 140000, "Olio su tela", 1937, "Cubismo",  1);
insert into Dipinto values ("Salvator mundi", 1, 65, 45, 15, 450000000, "Olio su tavola", 1505, "Rinascimentale",  2);
insert into Dipinto values ("Tormento di sant'Antonio", 1, 47, 35, 13, 6000000, "Olio e tempera su tavola", 1487, "Rinascimentale",  3);
insert into Dipinto values ("Mangiatori di patate", 2, 82, 114, 14, 700000, "Olio su tela", 1885, "Realismo",  4);
insert into Dipinto values ("Impressione, levar del sole", 1, 48, 63, 14, 1000000, "Olio su tela", 1872, "Impressionismo",  6);
insert into Dipinto values ("Giraffa in fiamme", 5, 35, 27, 9, 800000, "Olio su tavola", 1937, "Surrealismo",  7);
insert into Dipinto values ("Natura morta con mele e arance", 2, 74, 93, 10, 500000, "Olio su tela", '1900', "Post-impressionismo",  "8");
insert into Dipinto values ("il 3 maggio 1808", 1, 268, 347, 38, 2000000, "Colore ad olio", '1814', "Pittura storica",  "9");
insert into Dipinto values ("La colazione dei canottieri", 1, 130, 173, 22, 600000, "olio su tela", '1880', "Impressionismo",  "10");

insert into Altro values ("Progetti dela torre Eiffelle", 134, 200, 100, 0.3, 10, "Monumento", 1887, "Copia del progetto di costruzione della torre", 22);
insert into Altro values ("Progetti di costruzione di Nemo", 20, 100, 50, 0.27, 50, "Museo", 1997, "Ristampa dei progetti per la costruzione del museo NEMO di Amsterdam", 23);
insert into Altro values ("Box of Pin Ups", 1, 30, 30, 2, 50, "Fotogrefia", 1965, "Copertina vinile", 24);
insert into Altro values ("Goodbye Baby & Amen", 1000, 15, 5, 0.15, 10, "Fotografia", 1970, "Ristampa copertina libro", 24);
insert into Altro values ("Progetto costruzione Centro culturale Jean-Marie Tjibaou", 1, 500, 250, 0.12 , 2000, "Centro culturale", 1995, "Progetti originali", 23);
insert into Altro values ("Progetti ristrutturazione porto antico di Genova", 3, 300, 300, 0.3, 50, "Porto", 1988, "Ristampa dei documenti relativi alla ristrutturazione", 23);
insert into Altro values ("Progetti ponte Dom Luís I", 2, 250, 150, 0.28, 62, "Ponte", 1869, "Stampa dei progetti originali", 22);
insert into Altro values ("Fontana", 12, 61, 48, 38, 2000, "Moderno", 1917, "Il significato concettuale ermetico di Fontana l'ha resa probabilmente il ready-made più famoso di Duchamp", 19);

insert into Scultura VALUES ("David di Michelangelo", 1, 517, 199, 199, 400000000, "classico", 1504, 5000, 23);
insert into Scultura VALUES ("Apollo e Dafne", 1, 243, 170, 80, 20000000, "classico", 1625, 800, 22);
insert into Scultura VALUES ("Il David", 1, 158, 40, 40, 7000000, "naturalistico", 1440, 400, 16);
insert into Scultura VALUES ("Arca di san Zanobi", 1, 85, 193, 50, 100000, "classico", 1442, 1000, 18);
insert into Scultura VALUES ("Crocifisso", 1, 170, 120, 40, 200000, "esistenziale", 1415, 200, 21);
insert into Scultura VALUES ("Il pensatore", 2, 200, 130, 140, 100000, "romantico", 1902, 900, 15);
insert into Scultura VALUES ("Ballon dog", 15, 300, 100, 300, 300000, "contemporaneo", 2010, 700, 17);
insert into Scultura VALUES ("Baldacchino di san Pietro", 1, 3000, 400, 400, 50000000, "barocco", 1633, 25000, 22);
insert into Scultura VALUES ("La pietà", 5, 174, 195, 69, 1000000000, "rinascimentale", 1499, 3000, 23);
insert into Scultura VALUES ("San Pietro", 1, 243, 120, 80, 100000, "classico", 1412, 2000, 21);
insert into Scultura VALUES ("San Giorgio", 1, 209, 110, 75, 150000, "classico", 1418, 1700, 16);

insert into MostraDipinto values ("A1", "Ragazzo con pipa", 1, '2022-02-01 9:00:00 ', '2022-02-03 20:00:00');
insert into MostraDipinto values ("A1", "Ragazzo con pipa", 2, '2022-02-01 9:00:00', '2022-03-03 20:00:00');
insert into MostraDipinto values ("A1", "Gioconda", 2, '2022-02-01 9:00:00', '2022-03-03 20:00:00');
insert into MostraDipinto values ("A1", "David De Rohan", 5, '2022-02-01 9:00:00', '2022-03-03 20:00:00');
insert into MostraDipinto values ("A1", "Notte stellata", 1, '2022-02-01 9:00:00', '2022-03-03 20:00:00');
insert into MostraDipinto values ("A1", "Notte stellata", 2, '2019-04-01 12:00:00', '2019-04-05 18:30:00');
insert into MostraDipinto values ("A1", "Gioconda", 2, '2019-04-01 12:00:00', '2019-04-05 18:30:00');
insert into MostraDipinto values ("A1", "Cristo nella tempesta sul mare di Galilea", 2, '2019-04-01 12:00:00', '2019-04-05 18:30:00');
insert into MostraDipinto values ("A1", "La Grenouillère", 1, '2019-04-01 12:00:00', '2019-04-05 18:30:00');
insert into MostraDipinto values ("A1", "La persistenza della memoria", 1, '2019-04-01 12:00:00', '2019-04-05 18:30:00');
insert into MostraDipinto values ("A2", "I giocatori di carte", 2, '2022-01-20 12:00:00', '2022-01-22 13:50:00');
insert into MostraDipinto values ("A2", "Saturno che divora i suoi figli", 1, '2022-01-20 12:00:00', '2022-01-22 13:50:00');
insert into MostraDipinto values ("A2", "Bal au moulin de la Galette", 1, '2022-01-20 12:00:00', '2022-01-22 13:50:00');
insert into MostraDipinto values ("A2", "Flumequine", 14, '2022-01-20 12:00:00', '2022-01-22 13:50:00');
insert into MostraDipinto values ("A2", "Venere con Amore in fasce", 3, '2022-01-20 12:00:00', '2022-01-22 13:50:00');
insert into MostraDipinto values ("A3", "Butterfly", 1, '2018-08-21 9:30:00', '2018-08-25 12:00:00');
insert into MostraDipinto values ("A3", "Primavera", 1, '2018-08-21 9:30:00', '2018-08-25 12:00:00');
insert into MostraDipinto values ("A3", "Primavera", 3, '2018-08-21 9:30:00', '2018-08-25 12:00:00');
insert into MostraDipinto values ("A3", "Nascita di venere", 2, '2018-08-21 9:30:00', '2018-08-25 12:00:00');
insert into MostraDipinto values ("A3", "Guernica", 1, '2018-08-21 9:30:00', '2018-08-25 12:00:00');
insert into MostraDipinto values ("A4", "Salvator mundi", 1, '2023-04-10 9:30:00', '2023-04-10 21:30:00');
insert into MostraDipinto values ("A4", "Tormento di sant'Antonio", 1, '2023-04-10 9:30:00', '2023-04-10 21:30:00');
insert into MostraDipinto values ("A4", "Mangiatori di patate", 2, '2023-04-10 9:30:00', '2023-04-10 21:30:00');
insert into MostraDipinto values ("A4", "Impressione, levar del sole", 1, '2023-04-10 9:30:00', '2023-04-10 21:30:00');
insert into MostraDipinto values ("A4", "Giraffa in fiamme", 5, '2023-04-10 9:30:00', '2023-04-10 21:30:00');
insert into MostraDipinto values ("A4", "Natura morta con mele e arance", 2, '2023-04-10 9:30:00', '2023-04-10 21:30:00');

insert into MostraAltro values ("A1", "Progetti dela torre Eiffelle", 134, '2022-02-1 9:00:00', '2022-02-03 20:00:00');
insert into MostraAltro values ("A1", "Progetti di costruzione di Nemo", 20, '2022-02-1 9:00:00', '2022-02-03 20:00:00');
insert into MostraAltro values ("A1", "Box of Pin Ups", 1, '2022-02-1 9:00:00', '2022-02-03 20:00:00');
insert into MostraAltro values ("A2", "Goodbye Baby & Amen", 1000, '2022-01-20 12:00:00', '2022-01-22 13:50:00');
insert into MostraAltro values ("A2", "Progetto costruzione Centro culturale Jean-Marie Tjibaou", 1, '2022-01-20 12:00:00', '2022-01-22 13:50:00');
insert into MostraAltro values ("A2", "Progetti ristrutturazione porto antico di Genova", 3, '2022-01-20 12:00:00', '2022-01-22 13:50:00');
insert into MostraAltro values ("A3", "Progetti ponte Dom Luís I", 2, '2018-08-21 9:30:00', '2018-08-25 12:00:00');
insert into MostraAltro values ("A3", "Fontana", 12, '2018-08-21 9:30:00', '2018-08-25 12:00:00');
insert into MostraAltro values ("A3", "Progetti ristrutturazione porto antico di Genova", 3, '2018-08-21 9:30:00', '2018-08-25 12:00:00');
insert into MostraAltro values ("A4", "Progetti dela torre Eiffelle", 134, '2023-04-10 9:30:00', '2023-04-10 21:30:00');
insert into MostraAltro values ("A4", "Progetti di costruzione di Nemo", 20, '2023-04-10 9:30:00', '2023-04-10 21:30:00');
insert into MostraAltro values ("A4", "Goodbye Baby & Amen", 1000, '2023-04-10 9:30:00', '2023-04-10 21:30:00');

insert into Materiali values (1, "Bronzo");
insert into Materiali values (2, "Gesso");
insert into Materiali values (3, "Marmo");
insert into Materiali values (4, "Allluminio");
insert into Materiali values (5, "Vetro Resina");
insert into Materiali values (6, "Legno");


insert into Comporre values("David di Michelangelo", 1, 3);
insert into Comporre values("Apollo e Dafne", 1, 3);
insert into Comporre values("Il David", 1, 1);
insert into Comporre values("Arca di san Zanobi", 1, 1);
insert into Comporre values("Crocifisso", 1, 3);
insert into Comporre values("Crocifisso", 1, 6);
insert into Comporre values("Il pensatore", 2, 1);
insert into Comporre values("Ballon dog", 15, 5);
insert into Comporre values("Ballon dog", 15, 4);
insert into Comporre values("Baldacchino di san Pietro", 1, 3);
insert into Comporre values("La pietà", 5, 3);

