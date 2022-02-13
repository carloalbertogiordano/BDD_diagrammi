USE DBMuseo;

#1) Elencare, ordinatamente in base alla data di creazione, tutti i dipinti che sono stati creati da Dalì e tutti i dipindi creati da Botticelli. (Nome, Numero, Data di creazione)
SELECT D.nome, D.numero, D.dataCreazione
FROM Dipinto D, Artista A 
	WHERE  D.ID_Artista = A.ID
    AND (A.nome = "Dalì" OR A.nome = "Botticelli");
    
#2) Elencare tutti i clienti che hanno visitato il "museo bellissimo" (Nome, Cognome)
SELECT C.nome, C.cognome
FROM Clienti C, Musei M, Visita V
	WHERE C.ID = V.ID_Cliente
    AND V.codiceMuseo = M.codice
    AND M.nome = "Museo bellissimo";

#3) Mostrare la somma delle quotazioni di tutti i dipinti (sommaQuotazioni)
SELECT SUM(quotazione) FROM Dipinto;

#4) Mostrare la somma delle quotazioni dei quadri presenti ad ogni mostra (codiceMuseo, dataOraInizio, dataOraFine, sommaQuotazioni)
SELECT M.codiceMuseo, M.dataOraInizio, M.dataOraFine, SUM(D.quotazione)
FROM MostraDipinto M, Dipinto D
	WHERE M.nomeDipinto = D.nome
    AND M.numeroDipinto = D.numero
    GROUP BY M.codiceMuseo, M.dataOraInizio, M.dataOraFine;
    
#5) Mostrare gli artisti che hanno creato più di un dipinto (nome, ddnascita, #dipinti)
SELECT A.nome, A.ddnascita, count(*) as conta
FROM Artista A, Dipinto D
	WHERE D.ID_Artista = A.ID
	GROUP BY A.ID HAVING conta > 2;

#6) Elencare il genere per il quale la somma delle quotazioni delle sculture che gli appartengono è la più alta (genere, #sommaQuotazioni)
DROP VIEW IF EXISTS SommaQuotazioniSculture;
CREATE VIEW SommaQuotazioniSculture AS (SELECT S.genere, SUM(S.quotazione) AS somma
										FROM Scultura S
                                        GROUP BY S.genere
);

SELECT * 
FROM SommaQuotazioniSculture SQS
	WHERE SQS.somma = (SELECT MAX(somma) FROM SommaQuotazioniSculture);

#7) Elencare tutti i dipinti che sono stato esposti al "museo di arte" ma non al "museo delle opere" (Nome, Numero, dataOraInizio, dataOraFine)
SELECT Mo.nomeDipinto, Mo.numeroDipinto, Mo.dataOraInizio, Mo.dataOraFine
FROM MostraDipinto Mo, Musei Mu
	WHERE  Mo.codiceMuseo = Mu.codice
	AND Mu.nome = "Museo di arte"
	AND (Mo.nomeDipinto, Mo.numeroDipinto) NOT IN (
		SELECT Mo.nomeDipinto, Mo.numeroDipinto
		FROM MostraDipinto Mo, Musei Mu
			WHERE Mo.codiceMuseo = Mu.codice
			AND Mu.nome = "Museo delle opere"
            );

#8) Selezionare i clienti che hanno visitato tutti i musei (idCliente, nome, cognome)
SELECT C.ID, C.nome, C.cognome
FROM Clienti C
WHERE NOT EXISTS (
	SELECT * 
	FROM Musei M 
		WHERE NOT EXISTS (
			SELECT * 
			FROM Visita V
				WHERE V.ID_Cliente = C.ID
				AND V.codiceMuseo = M.codice
				)
		);