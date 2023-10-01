package Methods;

import java.util.Scanner;
import static ShiftCipher.Shift.*;
import static VigenereCipher.Vigenere.*;

public class MethodsForMain {
    static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    /**
     * Prints instructions for the use of Cipher Decrypter.
     * <p><p>"Welcome to Cipher Decrypter!"
     * <p>"We can decrypt:
     * <p>-Other shift ciphers
     * <p>-Vigenere cipher"
     */
    public static void instructions() {
        System.out.println("Welcome to Cipher Decrypter!");
        System.out.println("We can decrypt:" +
                "\n-Shift ciphers" +
                "\n-Vigenere Cipher");
    }

    /**
     * Asks user which cipher they would like to decrypt. Runs that cipher's decrypter method. If
     * the user is done, returns true and ends the loop in main.
     * @return a boolean : true if user is done, false if user wants to continue
     */
    public static boolean run() {
        //ask which cipher
        String cipherType = whatType();

        //send to that cipher's decrypter
        switch (cipherType) {
            case "s" : shiftDecrypter(); break;
            case "v" : vigenereDecrypter(); break;
            case "x" : return true;
            default : {
                System.out.println("That was not an option.");
                whatType();
            }
        }

        return false;
    }

    /**
     * Asks user which cipher they would like to use.
     * @return a String a lower case letter representing which type of cipher to decrypt
     */
    static String whatType() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter: 's' for shift ciphers, 'v' for Vigenere cipher, and 'x' if you are done: ");
        return (input.nextLine()).toLowerCase();
    }

    /**
     * Makes a String that is the alphabet shifted to the correct shift for the shift cipher.
     * @param shift a String that is the letter shifted to a
     * @return a String that is the alphabets shifted to the correct letter
     */
    public static String makeKey(int numShift) {

        //make keyString
        return alphabet.substring(numShift) + alphabet.substring(0, numShift);
    }

    /**
     * Removes all numbers and blank spaces from a String and converts it to lower case.
     * @param text a text to remove numbers and blank spaces from and to convert to lower case
     * @return a String from the text parameter
     */
    public static String removeNumbers(String text) {
        text = text.replace("1", "");
        text = text.replace("2", "");
        text = text.replace("3", "");
        text = text.replace("4", "");
        text = text.replace("5", "");
        text = text.replace("6", "");
        text = text.replace("7", "");
        text = text.replace("8", "");
        text = text.replace("9", "");
        text = text.replace("0", "");
        text = text.replace(" ", "");
        text = text.toLowerCase();
        return text;
    }

    /**
     * Prints a goodbye message for Cipher Decrypter.
     * <p>"Thank you for using the cipher decrypter!
     * <p>Goodbye!"
     */
    public static void goodbye() {
        System.out.println("Thank you for using the cipher decrypter!");
        System.out.println("Goodbye!");
    }
}
