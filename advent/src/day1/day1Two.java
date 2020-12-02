package day1;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class day1Two {
    public static void main(String[] args) {
        try {
            HashSet<Integer> set = new HashSet<>();
            List<Integer> list = new ArrayList<>();
            File myObj = new File("advent/src/day1/input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextInt()) {
                int in = myReader.nextInt();
                set.add(in);
                list.add(in);
            }
            myReader.close();

            set.stream().forEach(one -> {
                Optional<Integer> two = list.stream().filter(b -> set.contains(2020 - (one + b))).findFirst();
                if (two.isPresent()) {
                    System.out.println(one * two.get() * (2020 - (one + two.get())));
                }
            });
        } catch(Exception e) {

        }
    }

}
