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
public class FactoryTest {
  public static void main(String[] args) {
    // contoh tanpa factory pattern
    User a = new User("haqqi");
    a.setUseFile(true);
    User b = new User("fauzil");
    b.setUseFile(true);

    // contoh dengan factory pattern
    User user1 = UserFactory.create("haqqi");
    User user2 = UserFactory.create("fauzil");
    System.out.println("Use file?");
    System.out.println(user1.getUsername() + " : " + user1.getUseFile());
    System.out.println(user2.getUsername() + " : " + user2.getUseFile());
  }
}
