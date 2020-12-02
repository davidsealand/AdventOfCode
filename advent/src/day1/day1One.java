package day1;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class day1One {
    public static void main(String[] args) {
        try {
            HashSet<Integer> set = new HashSet<>();
            File myObj = new File("advent/src/day1/input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextInt()) {
                int in = myReader.nextInt();
                set.add(in);
            }
            myReader.close();

            Optional<Integer> answer = set.stream().filter(a -> set.contains(2020 - a)).findFirst();

            System.out.println(answer.get() * (2020 - answer.get()));
        } catch(Exception e) {

        }
    }
}
