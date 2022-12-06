import java.io.*;
import java.util.*;

public class Marker {
    public static void main(String[] args) {
        try {
            System.out.println("Attempting to read input.txt");
            File input = new File("input.txt");
            Scanner s = new Scanner(input);
            String token;
            String tester = "";
            int count = 0;

            token = s.nextLine();

            for (int i = 0; i < token.length() - 4; i++) {
                if (i > token.length() - 3)
                    break;
                tester += token.charAt(i);
                tester += token.charAt(i + 1);
                tester += token.charAt(i + 2);
                tester += token.charAt(i + 3);
                if (isUnique(tester)) {
                    count = i + 4;
                    break;
                }
                tester = "";
            }

            System.out.println(count);
            System.out.println(tester);
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file!");
            e.printStackTrace();
        }

    }

    public static boolean isUnique(String str) {
        if (str.charAt(0) != str.charAt(1) && str.charAt(0) != str.charAt(2) && str.charAt(0) != str.charAt(3)
                && str.charAt(1) != str.charAt(2) && str.charAt(1) != str.charAt(3)
                && str.charAt(2) != str.charAt(3))
            return true;
        return false;
    }
}