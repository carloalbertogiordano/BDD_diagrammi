package JDBC_Test;

import java.sql.*;

public class JdbcConnectionDemo {
   public static void main(String[] args) {
      String JdbcURL = "jdbc:mysql://localhost:3306/DBMuseo";
      String Username = "userMuseo";
      String password = "2001";
      Connection con = null;
      try {
         con=DriverManager.getConnection(JdbcURL, Username, password);
         //con=DriverManager.getConnection(JdbcURL);
         System.out.println("Connection is successful!!!!!!");

         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("SELECT * FROM Musei");

         while(rs.next()){
            System.out.print(rs.getString("codice"));
            System.out.print("\t");
            System.out.print(rs.getString("nome"));
            System.out.print("\n");

         }

         con.close();
         System.out.println("Now disconnected");
      }
      catch(Exception e) {
         e.printStackTrace();
      }
   }
}