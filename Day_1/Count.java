import java.io.*;
import java.util.*;

public class Count {
    public static void main(String[] args) {
        try {
            System.out.println("Attempting to read input.txt");
            File input = new File("input.txt");
            Scanner s = new Scanner(input);
            int maxCal = 0;
            int tempCal = 0;
            String token;

            while (s.hasNext()) {
                token = s.nextLine();
                
                if(isInteger(token, 10)){
                    tempCal += Integer.parseInt(token);  
                    if(tempCal > maxCal)
                        maxCal = tempCal; 
                }
                else
                    tempCal = 0;
            }
            System.out.println("Most total calories an elf is carrying " + maxCal);

            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file!");
            e.printStackTrace();
        }

    }

    static boolean isInteger(String s, int radix) {
        Scanner sc = new Scanner(s.trim());
        if(!sc.hasNextInt(radix)) return false;
        // we know it starts with a valid int, now make sure
        // there's nothing left!
        sc.nextInt(radix);
        return !sc.hasNext();
    }
}