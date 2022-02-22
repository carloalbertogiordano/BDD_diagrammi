USE DBMuseo;

INSERT INTO Clienti VALUES (1, "Mauro", "Rossi", '1950-09-19');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Maccio", "Capatonda", '1978-03-07');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Filippo", "Bianchi", '2001-04-02');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Gianluca", "Verdi", '2003-12-31');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Peppino", "Grigi", '1989-05-28');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Fausto", "Neri", '1974-10-14');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Mattia", "Blu", '1964-02-20');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Augusta", "Mazzi", '1986-06-10');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Lia", "Manfrin", '1940-07-06');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Alvaro", "Milano", '2005-08-09');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Manfredo", "Romani", '1937-11-15');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Mirella", "Trentini", '2002-03-26');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Annibale", "Bianchi", '1962-04-17');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Adelchi", "Lucciano", '1930-05-02');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Bonacata", "Rizzo", '1957-08-31');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Cora", "Castiglione", '1973-02-28');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Abbondio", "Onio", '1968-07-10');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Antonella", "Calabresi", '1963-09-19');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Gregorio", "Udinesi", '1998-06-14');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Eberardo", "Lombardo", '1919-12-20');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Giraldo", "Schiavone", '1970-04-06');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Roberto", "Calabresi", '1993-06-20');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Arnaldo", "Giordano", '1955-12-11');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Cordelia", "Zettici", '2000-03-14');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Amalia", "Bellucci", '1999-07-13');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Marco", "De Rose", '1978-03-30');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Giovanna", "Manna", '1988-08-18');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Ferdinanda", "Nanda", '1949-02-28');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Alfreda", "Genovesi", '1955-11-26');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Abelino", "Trevisani", '1980-06-17');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Mariano", "Monaldo", '1001-01-01');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Grazia", "Russo", '1983-08-21');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Clorinda", "Toscani", '1969-09-23');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Elena", "Greece", '1996-02-10');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Gerardino", "Padovano", '1981-04-19');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Taziano", "Trevisano", '1997-08-02');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Lucio", "Manfredi", '1949-03-12');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Manuele", "Mazzanti", '1946-01-01');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Agata", "Lombardi", '1989-03-16');
INSERT INTO Clienti (nome, cognome, ddnascita) VALUES ("Rocco", "Zettici", '1996-12-20');

INSERT INTO Musei VALUES ("A1", "Museo di Arte", "08:30:00", "20:30:00", "Via roma", 80134, "NA", 0);
INSERT INTO Musei VALUES ("A2", "Museo Bellissimo", "09:00:00", "18:00:00", "Via bella", 84121, "SA", 0);
INSERT INTO Musei VALUES ("A3", "Museo delle opere", "08:00:00", "19:00:00", "Via dei pioppi", 81100, "CE", 0);
INSERT INTO Musei VALUES ("A4", "Museissimo insieme", "10:30:00", "22:30:00", "Via delle madonne", 83100, "AV", 0);

INSERT INTO Visita VALUES (1, "A1", '2012-03-1 20:00:00', '2012-03-1 20:30:00');
INSERT INTO Visita VALUES (2, "A1", '2011-05-3 09:00:00', '2011-05-3 10:00:00');
INSERT INTO Visita VALUES (3, "A1", '2010-09-29 12:00:00', '2010-09-29 13:00:00');
INSERT INTO Visita VALUES (4, "A1", '2014-12-03 15:00:00', '2014-12-03 17:00:00');
INSERT INTO Visita VALUES (5, "A2", '2014-02-03 16:00:00', '2014-02-03 18:00:00');
INSERT INTO Visita VALUES (6, "A2", '2015-03-04 17:00:00', '2015-03-04 17:55:00');
INSERT INTO Visita VALUES (7, "A2", '2015-03-04 17:00:00', '2015-03-04 17:20:00');
INSERT INTO Visita VALUES (8, "A2", '2016-04-14 09:30:00', '2016-04-14 11:30:00');
INSERT INTO Visita VALUES (9, "A3", '2011-02-09 08:00:00', '2011-02-09 09:00:00');
INSERT INTO Visita VALUES (10, "A3", '2012-02-09 09:00:00', '2012-02-09 11:00:00');
INSERT INTO Visita VALUES (11, "A3", '2012-03-01 10:30:00', '2012-03-01 11:30:00');
INSERT INTO Visita VALUES (12, "A3", '2013-06-12 12:30:00', '2013-06-12 15:40:00');
INSERT INTO Visita VALUES (12, "A4", '2020-02-13 11:00:00', '2020-02-13 12:25:00');
INSERT INTO Visita VALUES (13, "A4", '2020-12-02 14:20:00', '2020-12-02 17:20:00');
INSERT INTO Visita VALUES (14, "A4", '2012-04-23 16:30:00', '2012-04-23 16:30:00');
INSERT INTO Visita VALUES (15, "A4", '2016-02-26 18:30:00', '2016-02-26 19:00:00');
INSERT INTO Visita VALUES (16, "A1", '2018-05-21 11:00:00', '2018-05-21 15:00:00');
INSERT INTO Visita VALUES (17, "A2", '2017-05-16 11:30:00', '2017-05-16 13:30:00');
INSERT INTO Visita VALUES (18, "A3", '2014-08-16 15:00:00', '2014-08-16 16:30:00');
INSERT INTO Visita VALUES (19, "A4", '2019-11-05 12:50:00', '2019-11-05 14:50:00');
INSERT INTO Visita VALUES (20, "A1", '2022-01-21 17:00:00', '2022-01-21 20:30:00');
INSERT INTO Visita VALUES (21, "A1", '2010-07-11 17:00:00', '2010-07-11 18:00:00');
INSERT INTO Visita VALUES (22, "A1", '2017-08-14 12:00:00', '2017-08-14 15:00:00');
INSERT INTO Visita VALUES (23, "A1", '2019-11-21 9:45:00', '2019-11-21 9:55:00');
INSERT INTO Visita VALUES (24, "A2", '2017-06-18 12:00:00', '2017-06-18 12:40:00');
INSERT INTO Visita VALUES (25, "A2", '2017-05-20 12:00:00', '2017-05-20 15:00:00');
INSERT INTO Visita VALUES (26, "A2", '2017-06-20 10:20:00', '2017-06-20 17:20:00');
INSERT INTO Visita VALUES (27, "A2", '2018-07-22 14:40:00', '2018-07-22 18:00:00');
INSERT INTO Visita VALUES (28, "A3", '2015-10-21 18:00:00', '2015-10-21 19:00:00');
INSERT INTO Visita VALUES (29, "A3", '2015-11-11 11:00:00', '2015-11-11 13:00:00');
INSERT INTO Visita VALUES (30, "A3", '2016-11-11 11:00:00', '2016-11-11 16:21:00');
INSERT INTO Visita VALUES (31, "A3", '2017-01-16 14:00:00', '2017-01-16 15:00:00');
INSERT INTO Visita VALUES (32, "A4", '2019-11-05 15:50:00', '2019-11-05 17:50:00');
INSERT INTO Visita VALUES (33, "A4", '2022-02-23 17:10:00', '2022-02-23 22:10:00');
INSERT INTO Visita VALUES (34, "A4", '2022-02-24 17:00:00', '2022-02-24 17:10:00');
INSERT INTO Visita VALUES (35, "A4", '2022-02-26 16:55:00', '2022-02-26 17:10:00');
INSERT INTO Visita VALUES (36, "A1", '2014-11-21 9:12:00', '2019-11-21 16:00:00');
INSERT INTO Visita VALUES (37, "A2", '2018-09-12 14:23:00', '2018-09-12 17:00:00');
INSERT INTO Visita VALUES (38, "A3", '2017-03-18 09:00:00', '2017-03-18 10:15:00');
INSERT INTO Visita VALUES (39, "A1", '2019-03-13 8:30:00', '2019-03-13 20:30:00');
INSERT INTO Visita VALUES (23, "A1", '2019-01-01 15:30:00', '1999-01-01 15:59:00');
INSERT INTO Visita VALUES (15, "A1", '2019-05-01 16:30:00', '2019-05-01 16:30:00');
INSERT INTO Visita VALUES (2, "A1", '2016-11-08 17:29:00', '2016-11-08 19:35:00');
INSERT INTO Visita VALUES (17, "A2", '2019-10-21 17:00:00', '2019-10-21 17:59:00');
INSERT INTO Visita VALUES (16, "A2", '2019-10-21 12:00:00', '2019-10-21 14:00:00');
INSERT INTO Visita VALUES (33, "A2", '2022-01-12 9:00:00', '2022-01-12 12:00:00');
INSERT INTO Visita VALUES (19, "A2", '2012-05-02 17:33:00', '2012-05-02 18:30:00');
INSERT INTO Visita VALUES (24, "A3", '2020-07-23 16:00:00', '2020-07-23 17:30:00');
INSERT INTO Visita VALUES (2, "A3", '2020-08-23 16:00:00', '2020-08-23 16:00:00');
INSERT INTO Visita VALUES (5, "A3", '2020-07-23 16:00:00', '2020-07-23 16:00:00');
INSERT INTO Visita VALUES (2, "A2", '2015-12-16 10:30:00', '2015-12-16 12:30:00');
INSERT INTO Visita VALUES (17, "A1", '2018-11-08 17:30:00', '2018-11-08 18:29:00');
INSERT INTO Visita VALUES (16, "A4", '2019-12-05 15:50:00', '2019-12-05 16:50:00');
INSERT INTO Visita VALUES (33, "A3", '2020-01-12 11:00:00', '2020-01-12 13:00:00');
INSERT INTO Visita VALUES (15, "A1", '2013-05-02 12:15:00', '2013-05-02 12:15:00');
INSERT INTO Visita VALUES (21, "A2", '2015-12-12 11:30:00', '2015-12-12 11:30:00');
INSERT INTO Visita VALUES (9, "A4", '2022-02-11 20:00:00', '2023-02-11 22:00:00');
INSERT INTO Visita VALUES (35, "A1", '2019-01-21 08:40:00', '2019-01-21 15:50:00');
INSERT INTO Visita VALUES (7, "A4", '2022-01-11 20:40:00', '2022-01-11 21:40:00');
INSERT INTO Visita VALUES (20, "A3", '2019-08-23 11:00:00', '2019-08-23 12:00:00');

#Pittori
INSERT INTO Artista VALUES (1, "Picasso", "Spagna", '1881-10-25', '1998-10-18');
INSERT INTO Artista VALUES (2, "Leonardo Da Vinci", "Italia", '1452-04-15', '1519-05-2');
INSERT INTO Artista VALUES (3, "Michelangelo", "Italia", '1475-03-06', '1564-02-18');
INSERT INTO Artista VALUES (4, "Van Gogh", "Paesi Bassi", '1853-03-30', '1890-07-29');
INSERT INTO Artista VALUES (5, "Rembrandt", "Olanda", '1606-07-15', '1669-10-04');
INSERT INTO Artista VALUES (6, "Monet", "Francia", '1840-11-14', '1926-12-05');
INSERT INTO Artista VALUES (7, "Dalì", "Spagna", '1904-05-11', '1989-01-23');
INSERT INTO Artista VALUES (8, "Cezanne", "Francia", '1839-01-19', '1906-12-22');
INSERT INTO Artista VALUES (9, "Goya", "Spagna", '1746-03-30', '1828-04-16');
INSERT INTO Artista VALUES (10, "Renoir", "Francia", '1841-02-25', '1919-12-03');
INSERT INTO Artista VALUES (11, "Hirst", "Inghilterra", '1965-05-07', null);
INSERT INTO Artista VALUES (12, "Canova", "Italia", '1757-11-01', '1822-08-13');
INSERT INTO Artista VALUES (13, "Yayoi Kusama", "Giappone", '1929-03-22', null);
INSERT INTO Artista VALUES (14, "Botticelli", "Italia", '1445-03-01', '1510-05-17');

#Scultori
INSERT INTO Artista VALUES (15, "Rodin", "Francia", '1840-11-12', '1917-11-17');
INSERT INTO Artista VALUES (16, "Donatello", "Italia", '1380-01-01', '1466-12-13');
INSERT INTO Artista VALUES (17, "Koons", "USA", '1955-01-21', null);
INSERT INTO Artista VALUES (18, "Ghiberti", "Italia", '1378-01-01', '1455-12-01');
INSERT INTO Artista VALUES (19, "Duchamp", "Francia", '1887-07-28', '1968-10-02');
INSERT INTO Artista VALUES (20, "Andy Warhol", "USA", '1928-10-06', '1987-02-22');
INSERT INTO Artista VALUES (21, "Brunelleschi", "Italia", '1377-01-01', '1446-04-15');

#architetto
INSERT INTO Artista VALUES (22, "Eiffelle", "Francia", '1832-12-15', '1923-12-27');
INSERT INTO Artista VALUES (23, "Renzo Piano", "Italia", '1937-09-14', null);

#fotografo
INSERT INTO Artista VALUES (24, "David Bailey", "Inghilterra", '1938-01-02', null);

#Dipinti
INSERT INTO Dipinto VALUES ("Ragazzo con pipa", 1, 100, 81, 5, 104000000, "Periodo rosa", 1905, "Olio su tela",  1, "pennello");
INSERT INTO Dipinto VALUES ("Ragazzo con pipa", 2, 50, 40, 5, 1000, "Periodo rosa", 1903, "Olio su tela",  1, "pennello");
INSERT INTO Dipinto VALUES ("Ragazzo con pipa", 3, 50, 40, 5, 800, "Periodo rosa", 1900, "Olio su tela",  1, "pennello");
INSERT INTO Dipinto VALUES ("Gioconda", 2, 77, 53, 10, 50000000000, "Rinascimentale", 1503, "Olio su tavola di pioppo",  2, "pennello");
INSERT INTO Dipinto VALUES ("David De Rohan", 5, 17, 7, 0, 100000, "Rinascimentale", 1502, "Appunti",  3, "pennello");
INSERT INTO Dipinto VALUES ("Notte stellata", 1, 35, 57, 7, 2000, "Pittura paesaggistica", 1886, "Oleografia su tela",  4, "pennello");
INSERT INTO Dipinto VALUES ("Notte stellata", 2, 35, 57, 7, 2000, "Pittura paesaggistica", 1886, "Oleografia su tela",  4, "pennello");
INSERT INTO Dipinto VALUES ("Cristo nella tempesta sul mare di Galilea", 2, 160, 128, 20, 700000, "Periodo d'oro Olandese", 1633, "Olio su tela",  5, "pennello");
INSERT INTO Dipinto VALUES ("La Grenouillère", 1, 66, 81, 12, 400000, "Impressionismo", 1869, "Olio su tela",  6, "pennello");
INSERT INTO Dipinto VALUES ("La persistenza della memoria", 1, 24, 33, 3, 100000000, "Surrealismo", 1931, "Olio su tela",  7, "pennello");
INSERT INTO Dipinto VALUES ("I giocatori di carte", 2, 47, 57, 8, 250000000, "post-impressionismo", 1890, "Olio su tela",  8, "pennello");
INSERT INTO Dipinto VALUES ("Saturno che divora i suoi figli", 1, 146, 83, 24, 40000000, "Uscita dal neoclassicismo", 1821, "Olio su tela",  9, "pennello");
INSERT INTO Dipinto VALUES ("Bal au moulin de la Galette", 1, 131, 175, 22, 20000000, "Impressionismo", 1876, "Olio su tela",  10, "pennello");
INSERT INTO Dipinto VALUES ("Flumequine", 14, 140, 110, 0, 600000, "Astrattismo", '2007', "Digitale",  11, "pennello");
INSERT INTO Dipinto VALUES ("Venere con Amore in fasce", 3, 132, 82, 18, 700000, "Neoclassicismo", 1789, "Olio su tela", 12, "pennello");
INSERT INTO Dipinto VALUES ("Butterfly", 1, 38, 45, 8, 11100, "Pittura animale", 1988, "Concettuale",  13, "pennello");
INSERT INTO Dipinto VALUES ("Primavera", 1, 203, 314, 37, 50000000000, "Tempera su tavola", 1477, "Rinascimentale",  14, "pennello");
INSERT INTO Dipinto VALUES ("Primavera", 2, 100, 150, 37, 50000, "Tempera su tavola", 1470, "Rinascimentale",  14, "pennello");
INSERT INTO Dipinto VALUES ("Primavera", 3, 300, 600, 37, 3000000, "Tempera su tavola", 1465, "Rinascimentale",  14, "pennello");
INSERT INTO Dipinto VALUES ("Nascita di venere", 2, 172, 278, 28,55000000,"tempera su tela", 1485, "Rinascimentale",  14, "pennello");
INSERT INTO Dipinto VALUES ("Guernica", 1, 349, 776, 50, 140000, "Olio su tela", 1937, "Cubismo",  1, "pennello");
INSERT INTO Dipinto VALUES ("Salvator mundi", 1, 65, 45, 15, 450000000, "Olio su tavola", 1505, "Rinascimentale",  2, "pennello");
INSERT INTO Dipinto VALUES ("Tormento di sant'Antonio", 1, 47, 35, 13, 6000000, "Olio e tempera su tavola", 1487, "Rinascimentale",  3, "pennello");
INSERT INTO Dipinto VALUES ("Mangiatori di patate", 2, 82, 114, 14, 700000, "Olio su tela", 1885, "Realismo",  4, "pennello");
INSERT INTO Dipinto VALUES ("Impressione, levar del sole", 1, 48, 63, 14, 1000000, "Olio su tela", 1872, "Impressionismo",  6, "pennello");
INSERT INTO Dipinto VALUES ("Giraffa in fiamme", 5, 35, 27, 9, 800000, "Olio su tavola", 1937, "Surrealismo",  7, "pennello");
INSERT INTO Dipinto VALUES ("Natura morta con mele e arance", 2, 74, 93, 10, 500000, "Olio su tela", '1900', "Post-impressionismo",  "8", "pennello");
INSERT INTO Dipinto VALUES ("il 3 maggio 1808", 1, 268, 347, 38, 2000000, "Colore ad olio", '1814', "Pittura storica",  "9", "pennello");
INSERT INTO Dipinto VALUES ("La colazione dei canottieri", 1, 130, 173, 22, 600000, "olio su tela", '1880', "Impressionismo",  "10", "pennello");

#Altro 
INSERT INTO Altro VALUES ("Progetti dela torre Eiffelle", 134, 200, 100, 0.3, 10, "Monumento", 1887, "Copia del progetto di costruzione della torre", 22, "Copia stampata");
INSERT INTO Altro VALUES ("Progetti di costruzione di Nemo", 20, 100, 50, 0.27, 50, "Museo", 1997, "Ristampa dei progetti per la costruzione del museo NEMO di Amsterdam", 23, "Copia stampata");
INSERT INTO Altro VALUES ("Box of Pin Ups", 1, 30, 30, 2, 50, "Fotogrefia", 1965, "Copertina vinile", 24, "Fotocamera");
INSERT INTO Altro VALUES ("Goodbye Baby & Amen", 1000, 15, 5, 0.15, 10, "Fotografia", 1970, "Ristampa copertina libro", 24, "Fotocamera");
INSERT INTO Altro VALUES ("Progetto costruzione Centro culturale Jean-Marie Tjibaou", 1, 500, 250, 0.12 , 2000, "Centro culturale", 1995, "Progetti originali", 23, "Matita");
INSERT INTO Altro VALUES ("Progetti ristrutturazione porto antico di Genova", 3, 300, 300, 0.3, 50, "Porto", 1988, "Ristampa dei documenti relativi alla ristrutturazione", 23, "Copia stampata");
INSERT INTO Altro VALUES ("Progetti ponte Dom Luís I", 2, 250, 150, 0.28, 62, "Ponte", 1869, "Stampa dei progetti originali", 22, "Copia stampata");
INSERT INTO Altro VALUES ("Fontana", 12, 61, 48, 38, 2000, "Moderno", 1917, "Il significato concettuale ermetico di Fontana l'ha resa probabilmente il ready-made più famoso di Duchamp", 19, "Gabinetto");

#Scultura
INSERT INTO Scultura VALUES ("David di Michelangelo", 1, 517, 199, 199, 400000000, "classico", 1504, 5000, 23, "Scalpello");
INSERT INTO Scultura VALUES ("Apollo e Dafne", 1, 243, 170, 80, 20000000, "classico", 1625, 800, 22, "Scalpello");
INSERT INTO Scultura VALUES ("Il David", 1, 158, 40, 40, 7000000, "naturalistico", 1440, 400, 16, "Scalpello");
INSERT INTO Scultura VALUES ("Arca di san Zanobi", 1, 85, 193, 50, 100000, "classico", 1442, 1000, 18, "Stampo");
INSERT INTO Scultura VALUES ("Crocifisso", 1, 170, 120, 40, 200000, "esistenziale", 1415, 200, 21, "Scalpello e sega");
INSERT INTO Scultura VALUES ("Il pensatore", 2, 200, 130, 140, 100000, "romantico", 1902, 900, 15, "Stampo");
INSERT INTO Scultura VALUES ("Ballon dog", 15, 300, 100, 300, 300000, "contemporaneo", 2010, 700, 17, "Stampo");
INSERT INTO Scultura VALUES ("Baldacchino di san Pietro", 1, 3000, 400, 400, 50000000, "barocco", 1633, 25000, 22, "Scalpello");
INSERT INTO Scultura VALUES ("La pietà", 5, 174, 195, 69, 10000, "rinascimentale", 1499, 3000, 23, "Scalpello");
INSERT INTO Scultura VALUES ("San Pietro", 1, 243, 120, 80, 100000, "classico", 1412, 2000, 21, "Scalpello");
INSERT INTO Scultura VALUES ("San Giorgio", 1, 209, 110, 75, 150000, "classico", 1418, 1700, 16, "Scalpello");

#Mostre di dipinti
INSERT INTO MostraDipinto VALUES ("A1", "Ragazzo con pipa", 1, '2022-02-01 9:00:00 ', '2022-02-03 20:00:00');
INSERT INTO MostraDipinto VALUES ("A1", "Ragazzo con pipa", 2, '2022-02-01 9:00:00', '2022-03-03 20:00:00');
INSERT INTO MostraDipinto VALUES ("A1", "Gioconda", 2, '2022-02-01 9:00:00', '2022-03-03 20:00:00');
INSERT INTO MostraDipinto VALUES ("A1", "David De Rohan", 5, '2022-02-01 9:00:00', '2022-03-03 20:00:00');
INSERT INTO MostraDipinto VALUES ("A1", "Notte Stellata", 1, '2022-02-01 9:00:00', '2022-03-03 20:00:00');
INSERT INTO MostraDipinto VALUES ("A1", "Notte Stellata", 2, '2019-04-01 12:00:00', '2019-04-05 18:30:00');
INSERT INTO MostraDipinto VALUES ("A1", "Gioconda", 2, '2019-04-01 12:00:00', '2019-04-05 18:30:00');
INSERT INTO MostraDipinto VALUES ("A1", "Cristo nella tempesta sul mare di Galilea", 2, '2019-04-01 12:00:00', '2019-04-05 18:30:00');
INSERT INTO MostraDipinto VALUES ("A1", "La Grenouillère", 1, '2019-04-01 12:00:00', '2019-04-05 18:30:00');
INSERT INTO MostraDipinto VALUES ("A1", "La persistenza della memoria", 1, '2019-04-01 12:00:00', '2019-04-05 18:30:00');
INSERT INTO MostraDipinto VALUES ("A2", "I giocatori di carte", 2, '2022-01-20 12:00:00', '2022-01-22 13:50:00');
INSERT INTO MostraDipinto VALUES ("A2", "Saturno che divora i suoi figli", 1, '2022-01-20 12:00:00', '2022-01-22 13:50:00');
INSERT INTO MostraDipinto VALUES ("A2", "Bal au moulin de la Galette", 1, '2022-01-20 12:00:00', '2022-01-22 13:50:00');
INSERT INTO MostraDipinto VALUES ("A2", "Flumequine", 14, '2022-01-20 12:00:00', '2022-01-22 13:50:00');
INSERT INTO MostraDipinto VALUES ("A2", "Venere con Amore in fasce", 3, '2022-01-20 12:00:00', '2022-01-22 13:50:00');
INSERT INTO MostraDipinto VALUES ("A3", "Butterfly", 1, '2018-08-21 9:30:00', '2018-08-25 12:00:00');
INSERT INTO MostraDipinto VALUES ("A3", "Primavera", 1, '2018-08-21 9:30:00', '2018-08-25 12:00:00');
INSERT INTO MostraDipinto VALUES ("A3", "Primavera", 3, '2018-08-21 9:30:00', '2018-08-25 12:00:00');
INSERT INTO MostraDipinto VALUES ("A3", "Nascita di venere", 2, '2018-08-21 9:30:00', '2018-08-25 12:00:00');
INSERT INTO MostraDipinto VALUES ("A3", "Guernica", 1, '2018-08-21 9:30:00', '2018-08-25 12:00:00');
INSERT INTO MostraDipinto VALUES ("A4", "Salvator mundi", 1, '2023-04-10 9:30:00', '2023-04-10 21:30:00');
INSERT INTO MostraDipinto VALUES ("A4", "Tormento di sant'Antonio", 1, '2023-04-10 9:30:00', '2023-04-10 21:30:00');
INSERT INTO MostraDipinto VALUES ("A4", "Mangiatori di patate", 2, '2023-04-10 9:30:00', '2023-04-10 21:30:00');
INSERT INTO MostraDipinto VALUES ("A4", "Impressione, levar del sole", 1, '2023-04-10 9:30:00', '2023-04-10 21:30:00');
INSERT INTO MostraDipinto VALUES ("A4", "Giraffa in fiamme", 5, '2023-04-10 9:30:00', '2023-04-10 21:30:00');
INSERT INTO MostraDipinto VALUES ("A4", "Natura morta con mele e arance", 2, '2023-04-10 9:30:00', '2023-04-10 21:30:00');

#Mostra di sculture
INSERT INTO MostraScultura VALUES("A1", "David di Michelangelo", 1, '2022-04-15 10:00:00', '2011-04-20 20:30:00');
INSERT INTO MostraScultura VALUES("A1", "La pietà", 5,'2022-04-15 10:00:00', '2011-04-20 20:30:00');
INSERT INTO MostraScultura VALUES("A1", "Apollo e Dafne", 1, '2010-06-18 10:00:00', '2010-07-18 20:30:00');
INSERT INTO MostraScultura VALUES("A1", "Baldacchino di san Pietro", 1, '2010-06-18 10:00:00', '2010-07-18 20:30:00');
INSERT INTO MostraScultura VALUES("A1", "Il David", 1, '2010-06-18 10:00:00', '2010-07-18 20:30:00');
INSERT INTO MostraScultura VALUES("A1", "San Giorgio", 1, '2010-06-18 10:00:00', '2010-07-18 20:30:00');

INSERT INTO MostraScultura VALUES("A2", "Arca di san Zanobi", 1, '2018-10-01 10:30:00', '2018-10-07 19:30:00');
INSERT INTO MostraScultura VALUES("A2", "Crocifisso", 1, '2018-10-01 10:30:00', '2018-10-07 19:30:00');
INSERT INTO MostraScultura VALUES("A2", "Ballon dog", 15, '2023-12-27 12:30:00', '2024-01-02 18:00:00');
INSERT INTO MostraScultura VALUES("A2", "Il pensatore", 2, '2020-02-07: 10:00:00', '2020-02-07: 10:00:00');
INSERT INTO MostraScultura VALUES("A2", "Il David", 1, '2020-02-07: 10:00:00', '2020-02-07: 10:00:00');
INSERT INTO MostraScultura VALUES("A2", "San Giorgio", 1, '2020-02-07: 10:00:00', '2020-02-07: 10:00:00');

INSERT INTO MostraScultura VALUES("A3", "David di Michelangelo", 1, '2006-05-01 13:00:00', '2006-06-01 20:00:00');
INSERT INTO MostraScultura VALUES("A3", "San Pietro", 1, '2006-06-28 13:00:00', '2006-07-01 20:30:00');
INSERT INTO MostraScultura VALUES("A3", "Baldacchino di san Pietro", 1, '2006-06-28 13:00:00', '2006-07-01 20:30:00');
INSERT INTO MostraScultura VALUES("A3", "Ballon dog", 15, '2024-01-05 13:30:00', '2024-01-10 20:00:00');
INSERT INTO MostraScultura VALUES("A3", "San Giorgio", 1, '2022-08-15 11:00:00', '2022-08-31 20:00:00');
INSERT INTO MostraScultura VALUES("A3", "Crocifisso", 1, '2022-08-15 11:00:00', '2022-08-31 20:00:00');

INSERT INTO MostraScultura VALUES("A4", "Baldacchino di san Pietro", 1, '2025-01-01 10:30:00', '2025-01-31 20:00:00');
INSERT INTO MostraScultura VALUES("A4", "David di Michelangelo", 1, '2022-06-10 10:00:00', '2022-06-12 20:00:00');
INSERT INTO MostraScultura VALUES("A4", "Apollo e Dafne", 1, '2022-06-10 10:00:00', '2022-06-12 20:00:00');
INSERT INTO MostraScultura VALUES("A4", "La pietà", 5, '2022-06-10 10:00:00', '2022-06-12 20:00:00');
INSERT INTO MostraScultura VALUES("A4", "San Pietro", 1, '2022-06-10 10:00:00', '2022-06-12 20:00:00');
INSERT INTO MostraScultura VALUES("A4", "Arca di san Zanobi", 1, '2022-06-10 10:00:00', '2022-06-12 20:00:00');

#Mostra di altro 
INSERT INTO MostraAltro VALUES ("A1", "Progetti dela torre Eiffelle", 134, '2022-02-1 9:00:00', '2022-02-03 20:00:00');
INSERT INTO MostraAltro VALUES ("A1", "Progetti di costruzione di Nemo", 20, '2022-02-1 9:00:00', '2022-02-03 20:00:00');
INSERT INTO MostraAltro VALUES ("A1", "Box of Pin Ups", 1, '2022-02-1 9:00:00', '2022-02-03 20:00:00');
INSERT INTO MostraAltro VALUES ("A2", "Goodbye Baby & Amen", 1000, '2022-01-20 12:00:00', '2022-01-22 13:50:00');
INSERT INTO MostraAltro VALUES ("A2", "Progetto costruzione Centro culturale Jean-Marie Tjibaou", 1, '2022-01-20 12:00:00', '2022-01-22 13:50:00');
INSERT INTO MostraAltro VALUES ("A2", "Progetti ristrutturazione porto antico di Genova", 3, '2022-01-20 12:00:00', '2022-01-22 13:50:00');
INSERT INTO MostraAltro VALUES ("A3", "Progetti ponte Dom Luís I", 2, '2018-08-21 9:30:00', '2018-08-25 12:00:00');
INSERT INTO MostraAltro VALUES ("A3", "Fontana", 12, '2018-08-21 9:30:00', '2018-08-25 12:00:00');
INSERT INTO MostraAltro VALUES ("A3", "Progetti ristrutturazione porto antico di Genova", 3, '2018-08-21 9:30:00', '2018-08-25 12:00:00');
INSERT INTO MostraAltro VALUES ("A4", "Progetti dela torre Eiffelle", 134, '2023-04-10 9:30:00', '2023-04-10 21:30:00');
INSERT INTO MostraAltro VALUES ("A4", "Progetti di costruzione di Nemo", 20, '2023-04-10 9:30:00', '2023-04-10 21:30:00');
INSERT INTO MostraAltro VALUES ("A4", "Goodbye Baby & Amen", 1000, '2023-04-10 9:30:00', '2023-04-10 21:30:00');

#Materiali
INSERT INTO Materiali VALUES (1, "Bronzo");
INSERT INTO Materiali VALUES (2, "Gesso");
INSERT INTO Materiali VALUES (3, "Marmo");
INSERT INTO Materiali VALUES (4, "Allluminio");
INSERT INTO Materiali VALUES (5, "Vetro Resina");
INSERT INTO Materiali VALUES (6, "Legno");

#Comporre
INSERT INTO Comporre VALUES ("David di Michelangelo", 1, 3);
INSERT INTO Comporre VALUES ("Apollo e Dafne", 1, 3);
INSERT INTO Comporre VALUES ("Il David", 1, 1);
INSERT INTO Comporre VALUES ("Arca di san Zanobi", 1, 1);
INSERT INTO Comporre VALUES ("Crocifisso", 1, 3);
INSERT INTO Comporre VALUES ("Crocifisso", 1, 6);
INSERT INTO Comporre VALUES ("Il pensatore", 2, 1);
INSERT INTO Comporre VALUES ("Ballon dog", 15, 5);
INSERT INTO Comporre VALUES ("Ballon dog", 15, 4);
INSERT INTO Comporre VALUES ("Baldacchino di san Pietro", 1, 3);
INSERT INTO Comporre VALUES ("La pietà", 5, 3);
