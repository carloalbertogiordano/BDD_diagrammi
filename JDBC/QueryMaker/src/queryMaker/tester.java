package queryMaker;
import java.sql.SQLException;
import java.util.ArrayList;

public class tester {
    public static void main(String[] args) throws SQLException {
        QueryMaker qm = new QueryMaker("jdbc:mysql://localhost:3306/DBMuseo", "userMuseo", "2001");
        ArrayList<ArrayList> o = null;

        String q = "SELECT D.nome, D.numero, D.dataCreazione FROM Dipinto D, Artista A WHERE  D.ID_Artista = A.ID AND (A.nome = \"Dalì\" OR A.nome = \"Botticelli\")";
        o = qm.makeQuery(q);
        
        System.out.println(qm.toString(o));
    }
}
