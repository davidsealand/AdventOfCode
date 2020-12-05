package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day5One {
    public static void main(String[] args) {
        try {
            File myObj = new File("advent/src/day5/input.txt");
            Scanner myReader = new Scanner(myObj);
            int max = 0;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String fb = line.substring(0, 7);
                String lr = line.substring(7);
                int front = 0;
                int back = 128;
                for (char c : fb.toCharArray()) {
                    if (c == 'B') {
                        front = (back - front) / 2 + front;
                    } else {
                        back = back - (back - front)/2;
                    }
                }
                int left = 0;
                int right = 8;
                for (char c : lr.toCharArray()) {
                    if (c == 'L') {
                        right = right - (right - left) / 2;
                    } else {
                        left = (right - left) / 2 + left;
                    }
                }
                if (front * 8 + left > max) {
                    max = front * 8 + left;
                }
            }
            myReader.close();

            System.out.println(max);
        } catch (FileNotFoundException e) {

        }
    }
}
