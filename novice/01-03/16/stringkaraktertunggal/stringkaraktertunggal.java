/**
 * stringkaraktertunggal
 */
public class stringkaraktertunggal {

    public static void main(String[] args) {

        // variable initialization
        String s = "yanghilangsilihberganti";
        System.out.println("Original message: " + s);
        String message = "";
        int shift = 1;

        // loop iterating over characters
        for (char c : s.toCharArray()) {

            int i = (int) c;
            i += shift;
            char character = (char) i;
            message += character;

        }

        // printing
        System.out.println("Encrypted message: " + message);

    }
}