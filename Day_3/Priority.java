import java.io.*;
import java.util.*;

public class Priority {
    public static void main(String[] args) {
        try {
            System.out.println("Attempting to read input.txt");
            File input = new File("input.txt");
            Scanner s = new Scanner(input);
            String token;
            int count = 0;

            while (s.hasNext()) {
                token = s.nextLine();

                String splitToken1 = token.substring(0, token.length() / 2);
                String splitToken2 = token.substring(token.length() / 2);

                count += getPriority(getMatch(splitToken1, splitToken2));
            }

            System.out.println("Total priorities count of matching item types: " + count);
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file!");
            e.printStackTrace();
        }

    }

    public static int getPriority(char matchChar) { // returns the priority number depending on the char (the "item")

        char myChar = 'A';
        int num = 0;
        for (int i = 0; i < 58; i++) { // (int) A = 65, so we need to subtract an offset of 38 to get A-Z = 27-52

            if (Character.isUpperCase(myChar)) {
                num = (int) myChar - 38;
                if (matchChar == myChar)
                    return num;

            }
            if (Character.isLowerCase(myChar)) {
                num = (int) myChar - 96; // (int) a = 97, so we need to subtract an offset of 96 to get a-z = 1-26
                if (matchChar == myChar)
                    return num;

            }
            myChar++;
        }

        return num;
    }

    public static char getMatch(String str1, String str2) {
        // iterate through str1's index and see if any chars in str2 match
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j))
                    return str1.charAt(i);
            }
        }
        return '*';
    }
}