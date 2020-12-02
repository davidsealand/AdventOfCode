package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class day2One {
    public static void main(String[] args) {
        try {
            ArrayList<Integer> min = new ArrayList<>();
            ArrayList<Integer> max = new ArrayList<>();
            ArrayList<Character> chars = new ArrayList<>();
            ArrayList<HashMap<Character, Integer>> passwords = new ArrayList<>();
            File myObj = new File("advent/src/day2/input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String parse2 = line.split("-")[1];
                min.add(Integer.parseInt(line.split("-")[0]));
                max.add(Integer.parseInt(parse2.split(" ")[0]));
                chars.add(parse2.split(" ")[1].charAt(0));
                passwords.add(new HashMap<>());
                for (char c : parse2.split(" ")[2].toCharArray()) {
                    if (!passwords.get(passwords.size() - 1).containsKey(c)) {
                        passwords.get(passwords.size() - 1).put(c, 1);
                    } else {
                        passwords.get(passwords.size() - 1).put(c, passwords.get(passwords.size() - 1).get(c) + 1);
                    }
                }
            }
            myReader.close();

            int validCounter = 0;
            for (int i = 0; i < passwords.size(); i++) {
                if (passwords.get(i).getOrDefault(chars.get(i), 0) >= min.get(i) && passwords.get(i).getOrDefault(chars.get(i), 0) <= max.get(i)) {
                    validCounter++;
                }
            }

            System.out.println(validCounter);
        } catch (FileNotFoundException e) {

        }
    }

}
