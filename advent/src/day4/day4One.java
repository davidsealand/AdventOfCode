package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day4One {
    public static void main(String[] args) {
        try {
            String passport = "";
            int valid = 0;
            File myObj = new File("advent/src/day4/input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNext()) {
                String line = myReader.nextLine();
                if (!myReader.hasNextLine()) {
                    passport += (line + " ");
                }
                if (line.equals("") || !myReader.hasNextLine()) {
                    int byr = passport.contains("byr:") ? 1 : 0;
                    int iyr = passport.contains("iyr:") ? 1 : 0;
                    int eyr = passport.contains("eyr:") ? 1 : 0;
                    int hgt = passport.contains("hgt:") ? 1 : 0;
                    int hcl = passport.contains("hcl:") ? 1 : 0;
                    int ecl = passport.contains("ecl:") ? 1 : 0;
                    int pid = passport.contains("pid:") ? 1 : 0;
                    int cid = passport.contains("cid:") ? 1 : 0;
                    if (byr + iyr + eyr + hgt + hcl + ecl + pid + cid == 8 ||
                            (byr + iyr + eyr + hgt + hcl + ecl + pid + cid == 7 && cid == 0)) {
                        valid++;
                    }
                    passport = "";
                } else {
                    passport += line;
                }
            }
            myReader.close();

            System.out.println(valid);
        } catch (FileNotFoundException e) {

        }
    }
}
