package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2Two {
    public static void main(String[] args) {
        try {
            File myObj = new File("advent/src/day2/input.txt");
            Scanner myReader = new Scanner(myObj);
            int validCounter = 0;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String parse2 = line.split("-")[1];
                int pos1 = Integer.parseInt(line.split("-")[0]);
                int pos2 = Integer.parseInt(parse2.split(" ")[0]);
                char char1 = parse2.split(" ")[1].charAt(0);
                String password = parse2.split(" ")[2];
                boolean first = false;
                if (password.length() >= pos1) {
                    first = password.charAt(pos1 - 1) == char1;
                }
                boolean second = false;
                if (password.length() >= pos2) {
                    second = password.charAt(pos2 - 1) == char1;
                }
                if ((first && !second) || (!first && second)) {
                    validCounter++;
                }
            }
            myReader.close();

            System.out.println(validCounter);
        } catch (FileNotFoundException e) {

        }
    }

}
