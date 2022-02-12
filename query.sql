use DBMuseo;

#1) Elencare, ordinatamente in base alla data di creazione, tutti i dipinti che sono stati creati da Dalì e tutti i dipindi creati da Botticelli. (Nome, Numero, Data di creazione)
Select D.nome, D.numero, D.dataCreazione
From Dipinto D, Artista A 
	Where D.ID_Artista = A.ID
    AND (A.nome = "Dalì" OR A.nome = "Botticelli");
    
#2) Elencare tutti i clienti che hanno visitato il "museo bellissimo" (Nome, Cognome)
Select C.nome, C.cognome
From Clienti C, Musei M, Visita V
	Where C.ID = V.ID_Cliente
    AND V.codiceMuseo = M.codice
    AND M.nome = "Museo bellissimo";

#3) Mostrare la somma delle quotazioni di tutti i dipinti (sommaQuotazioni)
Select SUM(quotazione) from Dipinto;

#4) Mostrare la somma delle quotazioni dei quadri presenti ad ogni mostra (codiceMuseo, dataOraInizio, dataOraFine, sommaQuotazioni)
Select M.codiceMuseo, M.dataOraInizio, M.dataOraFine, SUM(D.quotazione)
From MostraDipinto M, Dipinto D
	Where M.nomeDipinto = D.nome
    AND M.numeroDipinto = D.numero
    Group by M.codiceMuseo, M.dataOraInizio, M.dataOraFine;
    
#5) Mostrare gli artisti che hanno creato più di un dipinto (nome, ddnascita, #dipinti)
Select A.nome, A.ddnascita, count(*) as conta
from Artista A, Dipinto D
Where D.ID_Artista = A.ID
group by(A.ID) having conta > 2;

#6) Elencare il genere per il quale la somma delle quotazioni delle sculture che gli appartengono è la più alta (genere, #sommaQuotazioni)
Drop view if exists SommaQuotazioniSculture;
create view SommaQuotazioniSculture as (Select S.genere, SUM(S.quotazione) as somma
										from Scultura S
                                        group by S.genere
);
Select * 
from SommaQuotazioniSculture SQS
where SQS.somma = (Select MAX(somma) from SommaQuotazioniSculture);

#7) Elencare tutti i dipinti che sono stato esposti al "museo di arte" ma non al "museo delle opere" (Nome, Numero, dataOraInizio, dataOraFine)
Select Mo.nomeDipinto, Mo.numeroDipinto, Mo.dataOraInizio, Mo.dataOraFine
from MostraDipinto Mo, Musei Mu
where Mo.codiceMuseo = Mu.codice
AND Mu.nome = "Museo di arte"
AND (Mo.nomeDipinto, Mo.numeroDipinto) NOT IN (Select Mo.nomeDipinto, Mo.numeroDipinto
						from MostraDipinto Mo, Musei Mu
						where Mo.codiceMuseo = Mu.codice
						AND Mu.nome = "Museo delle opere"
                                                );

#8) Selezionare i clienti che hanno visitato tutti i musei (idCliente, nome, cognome)
Select C.ID, C.nome, C.cognome
from Clienti C
where NOT EXISTS (Select * 
			from Musei M 
			where NOT EXISTS (Select * 
			from Visita V
                        where V.ID_Cliente = C.ID
			AND V.codiceMuseo = M.codice
                 	)
		);










