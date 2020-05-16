package system.Server.Database;

public class TestDtbs
{
  public static void main(String[] args)
  {
    ConnectDBC db = new ConnectDBC();
    String mézga ="Schrödinger01";
    String géza = "passwrod1";
    String EMAIL ="Kiolmoi@gmail.com";
    db.InsertAccount(mézga,géza,EMAIL);
  }
}
