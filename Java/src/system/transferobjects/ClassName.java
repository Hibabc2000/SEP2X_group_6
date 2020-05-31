package system.transferobjects;

public enum ClassName
{
//  login
  CHECK_LOGIN,
  LOGIN_RESPONSE,
    // recover password function
  RECOVER_PASSWORD,
  RECOVER_PASSWORD_RESPONSE,
//  create account
  CREATE_ACCOUNT,
//  change email
  CHECK_EMAIL_CHANGE,
//  change password
  CHECK_PASSWORD_CHANGE,
// groups
  CREATE_GROUP,
  JOIN_GROUP,
  SEARCH_GROUP,
  GROUP_JOIN_UPDATE ,
 GROUP_TO_MODEL,
//remove user from client
 REMOVE_USER,
// STATIC
 STATIC_MODEL,
//Character
CHARACTER_INFO_FOR_START_GAME,
  INSERT_CHARACTER,
  CREATE_CHARACTER,
  UPDATE_CHARACTER,
  UPDATE_CHARACTER_TO_DM,

  CHARACTER,
// START GAME AS DM
  START_GAME,
  PLAYER_HAS_NOCHAR,
  PLAYER_HAS_CHAR,
  START_GAME_DM,
  ACCOUNT,
  //server command
  CLIENT_PLEASE_CREATE_A_CHARACTER,

  //load character classes
  CLASSES_LOAD;


}
