package system.Server.Database;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class ConnectDBC {

  private Connection c;
  private Statement stmt;
  public ConnectDBC()
  { c = null;
     stmt = null;
  }

  public void InsertAccount(String name, String password, String email)
  {

    try {
      Class.forName("org.postgresql.Driver");
      c = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/SEP2",
              "postgres", "");
      System.out.println("Database open ok");
      System.out.println("postgrescheck1");
      stmt = c.createStatement();
      String sql = "INSERT INTO \"Users\".\"Users\" VALUES( '"+name +"', '"+password +"', '{1,2}', '"+ email +"') ";
      stmt.executeUpdate(sql);
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName()+": "+ e.getMessage() );
      System.exit(0);
    }

  }


}