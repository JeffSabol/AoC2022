import java.io.*;
import java.util.*;

public class Score2 {
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
                    case 'A': // ROCK
                        switch (token.charAt(2)) {
                            case 'X': // NEED TO LOSE
                                score += 3 + 0; 
                                break;
                            case 'Y': // NEED TO DRAW
                                score += 1 + 3; 
                                break;
                            case 'Z': // NEED TO WIN
                                score += 2 + 6; 
                                break;
                        }
                        break;
                    case 'B': // PAPER
                        switch (token.charAt(2)) {
                            case 'X': 
                                score += 1 + 0; // NEED TO LOSE
                                break;
                            case 'Y':
                                score += 2 + 3; // NEED TO DRAW
                                break;
                            case 'Z':
                                score += 3 + 6; // NEED TO WIN
                                break;
                        }
                        break;

                    case 'C': // SCISSORS 
                        switch (token.charAt(2)) {
                            case 'X':
                                score += 2 + 0; // NEED TO LOSE
                                break;
                            case 'Y':
                                score += 3 + 3; // NEED TO DRAW
                                break;
                            case 'Z':
                                score += 1 + 6; // NEED TO WIN
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