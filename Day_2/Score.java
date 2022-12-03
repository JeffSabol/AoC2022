import java.io.*;
import java.util.*;

public class Score {
    public static void main(String[] args) {
        try {
            System.out.println("Attempting to read input.txt");
            File input = new File("input.txt");
            Scanner s = new Scanner(input);
            String token;
            int score = 0;

            while (s.hasNext()) {
                token = s.nextLine();

                switch (token.charAt(0)) {
                    case 'A': // rock 
                        switch (token.charAt(2)) {
                            case 'X':
                                score += 1 + 3; // draw
                                break;
                            case 'Y':
                                score += 2 + 6; // win
                                break;
                            case 'Z':
                                score += 3 + 0; // loss
                                break;
                        }
                        break;
                    case 'B': // paper
                        switch (token.charAt(2)) {
                            case 'X':
                                score += 1 + 0; // loss
                                break;
                            case 'Y':
                                score += 2 + 3; // draw
                                break;
                            case 'Z':
                                score += 3 + 6; // win
                                break;
                        }
                        break;

                    case 'C': // scissors 
                        switch (token.charAt(2)) {
                            case 'X':
                                score += 1 + 6; // win
                                break;
                            case 'Y':
                                score += 2 + 0; // loss
                                break;
                            case 'Z':
                                score += 3 + 3; // draw
                                break;
                        }
                        break;

                }
            }
            System.out.println("Total score: " + score);

            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file!");
            e.printStackTrace();
        }
    }
}