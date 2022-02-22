package queryMaker;

import java.sql.*;
import java.util.ArrayList;

public class QueryMaker {

    private Connection con;

    /*
     * Costruttore della classe a cui vengono passate le string URL, USER, PASS per poi inizializzare i driver di connessione
     * */
    public QueryMaker (String url, String user, String pass) {
        String JdbcURL = url;
        String Username = user;
        String password = pass;
        try {
            con=DriverManager.getConnection(JdbcURL, Username, password);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("Connection is successful!!!!!!");
    }

    /*
     * Passiamo la stringa contenente la query. Si crea lo statement e viene eseguita la query memorizzando il risulato in una variabile
     * di tipo ResultSetMetaData. Salviamo il numero di colonne restituite dalla query. Il primo elemento dell'arrayList più esterno saranno 
     * le intestazioni delle tabelle, date dal metodo getColumnName. Successivamente verranno inserti all'interno dell'arrsylist più esterno 
     * tutti gli arrayList che risultano dalla Query.
     * */
    public ArrayList makeQuery (String q) throws SQLException {

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(q);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        ArrayList<ArrayList> rQuery = new ArrayList<ArrayList>();  
        String colonne = "";

        ArrayList<String> nomeTabelle = new ArrayList<String>();
        for(int i = 1; i <= columnsNumber; i++){
            nomeTabelle.add(rsmd.getColumnName(i));
        }
        rQuery.add(nomeTabelle);

        while(rs.next()){
            ArrayList<String> tupla = new ArrayList<String>();
            for(int i = 1; i <= columnsNumber; i++){
                tupla.add(rs.getString(i));
            }
            rQuery.add(tupla);
        }

        return rQuery;
    }
    
    /*
     * Questo metodo ci permette di effettuare un inserimento all'interno del database.
     * Abbiamo bisogno di un metodo separato in quanto le query di inserimento non restituiscono nessun valore
     * */
    public void makeInsertion (String q) throws SQLException {
    	Statement st = con.createStatement();
        st.execute(q);
    }
}
