use DBMuseo;

Select D.nome, D.numero, D.dataCreazione
From Dipinto D, Artista A 
	Where D.ID_Artista = A.ID
    AND (A.nome = "Dalì" OR A.nome = "Botticelli");
    
Select C.nome, C.cognome
From Clienti C, Musei M, Visita V
	Where C.ID = V.ID_Cliente
    AND V.codiceMuseo = M.codice
    AND M.nome = "Museo bellissimo";
    
Select SUM(quotazione) from Dipinto;

Select M.codiceMuseo, M.dataOraInizio, M.dataOraFine, SUM(D.quotazione)
From MostraDipinto M, Dipinto D
	Where M.nomeDipinto = D.nome
    AND M.numeroDipinto = D.numero
    Group by M.codiceMuseo, M.dataOraInizio, M.dataOraFine;
