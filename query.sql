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

#6) Elencare il genere per il quale la somma delle quotazioni delle sculture che gli appartengono è la più alta (genere, #sommaQuotazioni)

#7) Elencare tutti i dipinti che sono stato esposti al "museo di arte" ma non al "museo delle opere" (Nome, Numero, dataOraInizio, dataOraFine)

#8) Selezionare i clienti che hanno visitato tutti i musei












