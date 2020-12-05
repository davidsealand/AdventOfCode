package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day5Two {
    public static void main(String[] args) {
        try {
            File myObj = new File("advent/src/day5/input.txt");
            Scanner myReader = new Scanner(myObj);
            int max = 0;
            ArrayList<ArrayList<Integer>> x = new ArrayList<>();
            for (int i=0; i<128; i++) {
                x.add(new ArrayList<>());
                for (int j=0; j<8; j++) {
                    x.get(i).add(0);
                }
            }
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
                x.get(front).set(left, front * 8 + left);
            }
            myReader.close();

            for (int i = 0; i<x.size(); i++) {
                for (int j = 0; j < x.get(i).size(); j++) {
                    if (x.get(i).get(j) == 0) {
                        if (j != 7 && x.get(i).get(j + 1) > 0 && j != 0 && x.get(i).get(j - 1) > 0) {
                            System.out.println(i * 8 + j);
                        } else if (j == 0 && i != 0) {
                            if (x.get(i-1).get(7) > 0 && x.get(i).get(j+1) > 0) {
                                System.out.println(i * 8 + j);
                            }
                        } else if (j == 7 && i != x.size()-1) {
                            if (x.get(i+1).get(0) > 0 && x.get(i).get(j-1) > 0) {
                                System.out.println(i * 8 + j);
                            }
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {

        }
    }
}
