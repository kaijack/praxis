
/**
 * basicdata
 */
import java.util.Scanner;

public class basicdata {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String nama;

        Scanner input_program = new Scanner(System.in);
        System.out.print("Masukan Nama Anda: ");
        nama = input_program.nextLine();
        System.out.println("Nama Anda : " + nama);
    }

}