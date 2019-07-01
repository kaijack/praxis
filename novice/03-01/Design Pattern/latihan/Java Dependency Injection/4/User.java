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
public class User {
  // *******variables area****** //
  private String username;
  private boolean useFile;
  // *****constructors area***** //
  public User(String username) {
    this.username = username;
  }
  // ********methods area******* //
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public boolean getUseFile() {
    return useFile;
  }
  public void setUseFile(boolean useFile) {
    this.useFile = useFile;
  }
  public static User create(String username) {
    User u = new User(username);
    u.setUseFile(true);
    return u;
  }
}
