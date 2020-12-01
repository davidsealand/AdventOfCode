package day1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day1 {
    public static void main(String[] args) {
        try {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            List<Integer> list3 = new ArrayList<>();
            File myObj = new File("src/input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextInt()) {
                int in = myReader.nextInt();
                list1.add(in);
                list2.add(in);
                list3.add(in);
            }
            myReader.close();

            for (int a : list1) {
                for (int b : list2) {
                    for (int c : list3) {
                        if ((a + b + c) == 2020) {
                            System.out.println(a * b * c);
                            return;
                        }
                    }
                }
            }
        } catch(Exception e) {
        }
    }

}
