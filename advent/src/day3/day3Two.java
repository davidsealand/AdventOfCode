package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day3Two {
    public static void main(String[] args) {
        try {
            int row = 0;
            long treesR1D1 = 0;
            long treesR3D1 = 0;
            long treesR5D1 = 0;
            long treesR7D1 = 0;
            long treesR1D2 = 0;
            File myObj = new File("advent/src/day3/input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                treesR1D1 += isTree(row, 1, line);
                treesR3D1 += isTree(row, 3, line);
                treesR5D1 += isTree(row, 5, line);
                treesR7D1 += isTree(row, 7, line);
                if (row % 2 == 0) {
                    treesR1D2 += isTree(row, 0.5, line);
                }
                row++;
            }
            myReader.close();

            System.out.println(treesR1D1 * treesR3D1 * treesR5D1 * treesR7D1 * treesR1D2);
        } catch (FileNotFoundException e) {

        }
    }

    private static int isTree(int row, double right, String line) {
            if (line.charAt((int) ((row * right) % line.length())) == '#') {
                return 1;
            }
        return 0;
    }

}
