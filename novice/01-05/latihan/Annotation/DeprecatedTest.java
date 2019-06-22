public class DeprecatedTest {
    @Deprecated
    public void Display() {
        System.out.println("DeprecatedTest()");

    }

    public static void main(String[] args) {
        DeprecatedTest d1 = new DeprecatedTest();
        d1.Display();
    }
}