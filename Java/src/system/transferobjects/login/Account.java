package system.transferobjects.login;

import java.io.Serializable;

public class Account implements Serializable
{

  private String username;
  private String password;
  private String email;
  private User user;

  //private User userPlayer;
  //private User userDM;
  public Account(String un, String pass, String ema)
  {
    username = un;
    password = pass;
    email = ema;
  }
  /**
   * Sets the user to instance of DM
   */
  public void setUserToDm()           // if the user is not instance of DM then creates a new DM instance.
  {
    if (!(user instanceof DM))          // This means if the user keeps switching between player and DM new instances get created everytime.
    {
      user = new DM(username);
    }          // this needs to be talked about, if we are fine with this or not.

  }
  /**
   * Sets the user to instance of Player.
   */
  public void setUserToPlayer()                //same thing
  {
    if (!(user instanceof Player))
    {
      user = new Player(username);
    }
  }
  /**
   * Returns the username .
   * @return variable String username.
   */
  public String getUsername()
  {
    return username;

  }
  /**
   * Sets a password.
   * @param newpas String containing the password.
   */
  public void setPassword(String newpas)
  {
    password = newpas;
  }

  /**
   * Returns the password.
   * @return variable String password.
   */

  public String getPassword()
  {
    return password;
  }
  /**
   * Returns the email.
   * @return  variable String email,
   */

  public String getEmail()
  {
    return email;
  }

  /**
   * Changes the email.
   * @param newMail String containing the new email.
   */
  public void changeEmail(String newMail)
  {
    email = newMail;
  }


  /**
   * Returns an instance of Player.
   * @return  the user as a Player.
   */
  public Player getPlayer()
  {
    return (Player) user;
  }
  /**
   * Returns an instance of DM.
   * @return  the user as a DM.
   */

  public DM getDM()
  {
    return (DM) user;
  }
  /**
   * Returns an the User.
   * @return  the user as User.
   */

  public User getUser()
  {
    return user;
  }
}
