package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day3One {
    public static void main(String[] args) {
        try {
            int col = 0;
            int trees = 0;
            File myObj = new File("advent/src/day3/input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                if (line.charAt(col % line.length()) == '#') {
                    trees++;
                }
                col += 3;
            }
            myReader.close();

            System.out.println(trees);
        } catch (FileNotFoundException e) {

        }
    }


}
