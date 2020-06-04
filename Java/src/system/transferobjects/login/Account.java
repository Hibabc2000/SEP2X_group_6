package system.transferobjects.login;

import java.io.Serializable;

/**
 * @author Oliver Izsák, 293131
 * @version 1.1.0
 * this class is the Account stores information about the User's account.
 */
public class Account implements Serializable
{

  private String username;
  private String password;
  private String email;
  private User user;

  public Account(String un, String pass, String ema)
  {
    username = un;
    password = pass;
    email = ema;
  }
  /**
   * Sets the user to instance of DM if it is not already set to DM.
   */
  public void setUserToDm()
  {
    if (!(user instanceof DM))
    {
      user = new DM(username);
    }

  }
  /**
   * Sets the user to instance of Player if it is not already set to Player
   */
  public void setUserToPlayer()
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
