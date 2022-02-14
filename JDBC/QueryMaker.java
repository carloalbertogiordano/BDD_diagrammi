package Manager;

import java.sql.*;
import java.util.ArrayList;

public class QueryMaker {

    private Connection con;

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

    public ArrayList makeQuery (String q) throws SQLException {

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(q);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        ArrayList<ArrayList> rQuery = new ArrayList<ArrayList>();  
        String colonne = "";

        ArrayList<String> nomeTabelle = new ArrayList<String>();
        for(int i = 1; i <= columnsNumber; i++){
            nomeTabelle.add(rsmd.getColumnName(i) + "\t");
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
    
    public static String toString (ArrayList a) {
        String s = "";
        for(int i = 0; i < a.size(); i++){
            s += format((ArrayList) a.get(i));
            s += "\n";
        }
        return s;
    }

    public static String format(ArrayList a) {
        String s = "";

        for (int i = 0; i < a.size(); i++){
            s += a.get(i);
            s += "\t";
        }
        return s;
    }
}
