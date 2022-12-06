import java.io.*;
import java.util.*;

public class Crates1 {
    public static void main(String[] args) {
        try {
            System.out.println("Attempting to read input.txt");
            File input = new File("input.txt");
            Scanner s = new Scanner(input);
            String token;
            List<Stack<String>> stacks = new ArrayList<Stack<String>>();
            // hardcoding cause I can't be arsed to parse
            // ... this is embarassing tho
            Stack<String> s1 = new Stack<String>();
                s1.push("B");
                s1.push("Z");
                s1.push("T");
                stacks.add(s1);
            Stack<String> s2 = new Stack<String>();
                s2.push("V");
                s2.push("H");
                s2.push("T");
                s2.push("D");
                s2.push("N");
                stacks.add(s2);
            Stack<String> s3 = new Stack<String>();
                s3.push("B");
                s3.push("F");
                s3.push("M");
                s3.push("D");
                stacks.add(s3);
            Stack<String> s4 = new Stack<String>();
                s4.push("T");
                s4.push("J");
                s4.push("G");
                s4.push("W");
                s4.push("V");
                s4.push("Q");
                s4.push("L");
                stacks.add(s4);
            Stack<String> s5 = new Stack<String>();
                s5.push("W");
                s5.push("D");
                s5.push("G");
                s5.push("P");
                s5.push("V");
                s5.push("F");
                s5.push("Q");
                s5.push("M");
                stacks.add(s5);
            Stack<String> s6 = new Stack<String>();
                s6.push("V");
                s6.push("Z");
                s6.push("Q");
                s6.push("G");
                s6.push("H");
                s6.push("F");
                s6.push("S");
                stacks.add(s6);
            Stack<String> s7 = new Stack<String>();
                s7.push("Z");
                s7.push("S");
                s7.push("N");
                s7.push("R");
                s7.push("L");
                s7.push("T");
                s7.push("C");
                s7.push("W");
                stacks.add(s7);
            Stack<String> s8 = new Stack<String>();
                s8.push("Z");
                s8.push("H");
                s8.push("W");
                s8.push("D");
                s8.push("J");
                s8.push("N");
                s8.push("R");
                s8.push("M");
                stacks.add(s8);
            Stack<String> s9 = new Stack<String>();
                s9.push("M");
                s9.push("Q");
                s9.push("L");
                s9.push("F");
                s9.push("D");
                s9.push("S");
                stacks.add(s9);


            int count = 0; // how many items we are moving
            int from = 0; // from which stack
            int to = 0; // to which stack

            while (s.hasNext()) {
                token = s.nextLine();
                System.out.println(token);
                Scanner readInt = new Scanner(extractInt(token));

                readInt.close();

                for(int i = 0; i<count; i++){
                    stacks.get(to-1).push((stacks.get(from-1)).pop());
                }
            }

            System.out.println(s1.peek()+"\t"+s2.peek()+"\t"+s3.peek()+"\t"+s4.peek()+"\t"+s5.peek()+"\t"+s6.peek()+"\t"+s7.peek()+"\t"+s8.peek()+"\t"+s9.peek());

            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file!");
            e.printStackTrace();
        }

    }

    public static String extractInt(String str){
        // Replacing every non-digit number
        // with a space(" ")
        str = str.replaceAll("[^0-9]", " "); // regular expression

        // Replace all the consecutive white
        // spaces with a single space
        str = str.replaceAll(" +", " ");


        return str;
    }
}