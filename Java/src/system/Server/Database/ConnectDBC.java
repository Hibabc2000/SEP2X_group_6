package system.Server.Database;
import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectDBC {
  public static void main( String args[] ) {

    Connection c = null;

    try {
      Class.forName("org.postgresql.Driver");
      c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
          "postgres", "<Your Password>");

      if (c!= null) {
        System.out.println("Opened database successfully");
      }
      else {
        System.out.print("Connection Failed");
      }

    } catch ( Exception e ) {
      System.exit(0);
    }
    System.out.println("e");
  }
}