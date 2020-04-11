package login;

public class Account
{

  private String username;
  private String password;
  private String email;
  private User user;
  //private User userPlayer;
  //private User userDM;
  public Account(String un, String pass, String ema)
  {
    username=un;
    password=pass;
    email=ema;
    user = new DM(un);


  }
  public void setUserToDm()
  {if(!(user instanceof DM))
  {user = new DM(username);}

  }
  public void setUserToPlayer()
  { if(!(user instanceof Player) )
  {user = new Player(username);}
  }

  public String getUsername()
  {
    return username;

  }
  public void setPassword(String newpas)
  {
    password=newpas;
  }

  public String getPassword()
  {
    return password;
  }

  public String getEmail()
  {return email;
  }
  public void changeEmail(String newMail)
  {
    email= newMail;
  }
  public void changePassword(String newPass)
  {
    password= newPass;
  }

  public Player getPlayer()
  {
    return (Player)user;
  }
  public DM getDM()
  {
    return (DM)user;
  }

  public User getUser()
  {
    return user;
  }
}
