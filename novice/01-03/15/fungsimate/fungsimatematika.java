/**
 * fungsimatematika
 */
public class fungsimatematika {

    public static void main(String[] args) {

        /** Akan mengembalikan nilai 0 <= angka random < 5 */
        System.out.println("Angka random integer antara 0 dan 5 adalah " + (int) (Math.random() * 5));

        /** Akan mengembalikan nilai 5 <= angka random < (5+10) */
        System.out.println("Angka random integer antara 5 dan 15 adalah " + (5 + (int) (Math.random() * 10)));

    }
}