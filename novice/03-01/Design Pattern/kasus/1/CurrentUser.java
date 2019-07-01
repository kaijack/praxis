/**
 * DO NOT REMOVE THIS LICENSE
 * 
 * This source code is created by Muhammad Fauzil Haqqi.
 * You can use and modify this source code freely but
 * you are forbidden to change or remove this license.
 * 
 * Nick          : Haqqi
 * YM            : fauzil.haqqi
 * Email & GTalk : me@haqqi.net
 * Site          : http://haqqi.net
 * Company       : http://mimicreative.net
 */


/**
 *
 * @author Haqqi
 */
public class CurrentUser {
  // *******variables area****** //
  private static User activeUser = null;
  // *****constructors area***** //
  // untuk mencegah pembuatan object
  private CurrentUser() {}
  // ********methods area******* //
  public static User user() {
    return activeUser;
  }

  public static void login(String username, String password) {
    activeUser = new User(username, password);
  }
  
  public static void logout() {
    activeUser = null;
  }

  public static boolean isLoggedIn() {
    if(activeUser == null) {
      return false;
    } else {
      return true;
    }
  }
}
