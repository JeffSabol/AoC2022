import java.io.*;
import java.util.*;

public class Priority2 {
    public static void main(String[] args) {
        try {
            System.out.println("Attempting to read input.txt");
            File input = new File("input.txt");
            Scanner s = new Scanner(input);
            String token1, token2, token3;
            int count = 0;

            while (s.hasNext()) {
                token1 = s.nextLine();
                token2 = s.nextLine();
                token3 = s.nextLine();

                getMatch(token1, token2, token3);
                count += (getPriority(getMatch(token1, token2, token3)));
            }

            System.out.println("Total priorities count of matching badges: " + count);
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file!");
            e.printStackTrace();
        }

    }

    public static int getPriority(char matchChar) { // returns the priority number depending on the char (the "item")

        char myChar = 'A';
        int num = 0;
        for (int i = 0; i < 58; i++) { // (int) A = 65 so we need to subtract an offset of 38 to get A-Z = 27-52
            if (Character.isUpperCase(myChar)) {
                num = (int) myChar - 38;
                if (matchChar == myChar) {
                    return num;
                }
            }
            if (Character.isLowerCase(myChar)) {
                num = (int) myChar - 96; // (int) a = 97, so we need to subtract an offset of 96 to get a-z = 1-26
                if (matchChar == myChar) {
                    return num;
                }
            }
            myChar++;
        }

        return num;
    }

    public static char getMatch(String str1, String str2, String str3) {
        // iterate through str1's index and see if any chars in str2 match
        String check;
        for (int i = 0; i < str1.length(); i++) {
            check = String.valueOf(str1.charAt(i)); // must be of type string for .contains because it is for Strings
            if (str2.contains(String.valueOf(str1.charAt(i))) && str3.contains(String.valueOf(str1.charAt(i))))
                return str1.charAt(i);
        }
        return '*'; // default
    }
}