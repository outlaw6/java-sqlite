import java.sql.*;

public class UbacujPodatke
{
  public static void main( String args[] )
  {
    Connection c = null;
    Statement stmt = null;
    
    
    try {
        
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      c.setAutoCommit(false);
      
      
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      
      String sql = "INSERT INTO KATALOG (SIFRA,NAZIV,CIJENA,ZALIHA) " +
                   "VALUES (040980, 'Casa plasticna', 3.3, 23 );"; 
      stmt.executeUpdate(sql);



      stmt.close();
      c.commit();
      c.close();
    } catch ( Exception e ) 
    {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Records created successfully");
  }
}