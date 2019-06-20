
/**
 * kondisi
 */
import java.util.Scanner;

public class kondisi {

    public static void main(String[] args) {
        float nilai;
        Scanner masukan = new Scanner(System.in);
        System.out.print("Masukan nilai yang didapat : ");
        nilai = masukan.nextFloat();
        if (nilai > 80) {
            System.out.print("Anda Mendapat Nilai A");
        } else if (nilai > 70) {
            System.out.print("Anda Mendapat Nilai B");
        } else if (nilai > 60) {
            System.out.print("Anda Mendapat Nilai C");
        } else if (nilai > 50) {
            System.out.print("Anda Mendapat Nilai D");
        } else {
            System.out.print("Anda Mendapat Nilai E");
        }
    }
}