import java.io.*;
import java.util.*;

public class Count2 {
    public static void main(String[] args) {
        try {
            System.out.println("Attempting to read input.txt");
            File input = new File("input.txt");
            Scanner s = new Scanner(input);
            int tempCal = 0;
            String token;
            LinkedList<Integer> ll = new LinkedList<Integer>();  

            while (s.hasNext()) {
                token = s.nextLine();
                
                if(isInteger(token, 10)){
                    tempCal += Integer.parseInt(token);  
                }
                else{
                    ll.add(tempCal);
                    tempCal = 0;
                }
            }
            
            Collections.sort(ll,null);
            int llSize = ll.size();
            System.out.println("Top 3 elves: " + ll.get(llSize-1) + " "+ ll.get(llSize-2) +" "+ ll.get(llSize-3));
            int total = ll.get(llSize-3)+ll.get(llSize-2)+ll.get(llSize-1);
            System.out.println("Total of top 3 elves: "+ total);

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