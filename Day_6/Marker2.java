import java.io.*;
import java.util.*;

public class Marker2 {
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
                for(int j = 0; j < 14; j++){
                    tester += token.charAt(i+j);
                }
                if (isUnique(tester)) {
                    count = i + 14;
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
        for (int i = 0; i < str.length(); i++)
            for (int j = i + 1; j < str.length(); j++)
                if (str.charAt(i) == str.charAt(j))
                    return false;
        return true;
    }
}
