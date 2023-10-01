package ShiftCipher;

import java.util.Scanner;
import static Methods.MethodsForMain.*;

public class Shift {
    static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public static void shiftDecrypter() {
        Scanner input = new Scanner(System.in);

        //ask for ciphertext
        System.out.print("Input your ciphertext: ");
        String ciphertext = input.nextLine();
        ciphertext = removeNumbers(ciphertext);

        System.out.print("Input the shift a-(example: b would be a to the left one): ");
        String shift = input.nextLine();
        shift = removeNumbers(shift);

        //decrypt
        decrypt(ciphertext, shift);
    }

    /**
     * A void method that decrypts shift cipher ciphertext.
     * @param ciphertext a String that represents the ciphertext
     * @param shift a String that represents the letter a is equivalent to
     */
    static void decrypt(String ciphertext, String shift) {
        //figure out what # shift
        int numShift = alphabet.indexOf(shift);

        String key = makeKey(numShift);
        String plaintext = "";

        //make ciphertext into an array
        String[] ciphertextArray = new String[ciphertext.length()];
        for(int i = 0; i < ciphertext.length(); i++) {
            ciphertextArray[i] = ciphertext.substring(i, i+1);
        }

        //decrypt letter by letter
        for (String letter : ciphertextArray) {
            int indexOfLetter = key.indexOf(letter);
            plaintext += alphabet.substring(indexOfLetter, indexOfLetter+1);
        }

        //inform user
        System.out.println("The ciphertext: " + ciphertext);
        System.out.println("with a-" + shift);
        System.out.println("decrypts to: " + plaintext);
    }
}
