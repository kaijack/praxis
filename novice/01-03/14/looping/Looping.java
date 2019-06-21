/**
 * looping
 */
public class Looping {

    public static void main(String[] args) {

        int i = 1, n = 19, t1 = 0, t2 = 1;
        System.out.print("Bilangan " + n + " Fibonacci: ");

        while (i <= n) {
            System.out.print(t1 + " , ");

            int sum = t1 + t2;
            t1 = t2;
            t2 = sum;

            i++;
        }
    }
}
