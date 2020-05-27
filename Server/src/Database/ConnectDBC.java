package Database;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class ConnectDBC {

  private Connection connection;
  private Statement stmt;
  public ConnectDBC()
  { connection = null;
     stmt = null;
  }

  public void InsertAccount(String name, String password, String email)
  {

    try {
      Class.forName("org.postgresql.Driver");
      connection = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/SEP2",
              "postgres", "");
      System.out.println("Database open ok");
      System.out.println("postgrescheck1");
      stmt = connection.createStatement();
      String sql = "INSERT INTO \"Characters\".\"Users\" VALUES( '"+name +"', '"+password +"', '{1,2}', '"+ email +"') ";
      stmt.executeUpdate(sql);
      stmt.close();
      connection.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName()+": "+ e.getMessage() );
      System.exit(0);
    }

  }


}