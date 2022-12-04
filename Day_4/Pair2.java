import java.io.*;
import java.util.*;

public class Pair2 {
    public static void main(String[] args) {
        try {
            System.out.println("Attempting to read input.txt");
            File input = new File("input.txt");
            Scanner s = new Scanner(input);
            int count = 0;
            String token;

            while (s.hasNext()) {
                token = s.nextLine();
                String[] arr = token.split(",");
                if(isAnyOverlap(arr[0], arr[1])){
                    count++;
                    System.out.print("OVERLAP\t");
                }
                System.out.println(arr[0]+ " "+arr[1]);
            }

            System.out.println("Total overlaps:" + count);

            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file!");
            e.printStackTrace();
        }

    }

    public static boolean isAnyOverlap(String str1, String str2){
        String[] splitStr1 = str1.split("-");
        String[] splitStr2 = str2.split("-");
        if(Integer.parseInt(splitStr1[0])<=Integer.parseInt(splitStr2[1]) && Integer.parseInt(splitStr2[0])<=Integer.parseInt(splitStr1[1]))
            return true;
        else
            return false;

    }
}