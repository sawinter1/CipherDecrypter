package VigenereCipher;

import java.util.Scanner;
import static Methods.MethodsForMain.*;

public class Vigenere {
    static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public static void vigenereDecrypter() {
        Scanner input = new Scanner(System.in);

        //ask for ciphertext
        System.out.print("Input your ciphertext: ");
        String ciphertext = input.nextLine();
        ciphertext = removeNumbers(ciphertext);

        //ask for key
        System.out.print("Input the key: ");
        String key = input.nextLine();
        key = removeNumbers(key);

        decrypt(ciphertext, key);
    }

    static void decrypt(String ciphertext, String key) {
        //assign a letter of the key to every letter of the ciphertext
        //make a string array for each letter of ciphertext
        String[] lettersCipher = new String[ciphertext.length()];
        for(int i = 0; i < ciphertext.length(); i++) {
            lettersCipher[i] = ciphertext.substring(i, i+1);
        }

        //make a String array repeating the key
        String[] keyRepeating = new String[ciphertext.length()];
        for(int i = 0; i < ciphertext.length(); i++) {
            int keyIndex = i % key.length(); //if key is shorter than ciphertext
            keyRepeating[i] = key.substring(keyIndex, keyIndex+1);
        }

        //decrypt each letter
        String plaintext = "";
        for(int i = 0; i < ciphertext.length(); i++) {
            plaintext += decryptLetter(lettersCipher[i], keyRepeating[i]);
        }

        System.out.println("For ciphertext: " + ciphertext + " and key: " + key);
        System.out.println("The plaintext is: " + plaintext);
    }

    static String decryptLetter(String cipherLetter, String keyLetter) {
        //make key
        String[] vigenereKey = vigenereKey();

        //find how far into the alphabet the key letter is
        //using the string from the square that starts with that letter
        String row = vigenereKey[alphabet.indexOf(keyLetter)];

        //find the index of the cipher letter
        int index = row.indexOf(cipherLetter);

        //find the letter that is at that index in the alphabet
        return alphabet.substring(index, index+1);
    }

    /**
     * Creates an alphabet key for Vigenere cipher.
     * @return a String array of 26 Strings each containing a line of the vigenere square
     */
    static String[] vigenereKey() {
        String[] vigenereKey = new String[26];
        for(int i = 0; i < 26; i++) {
            vigenereKey[i] = makeKey(i);
        }

        return vigenereKey;
    }

}
