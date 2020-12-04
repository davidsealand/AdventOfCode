package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day4Two {
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
                    int byr = 0;
                    if (passport.contains("byr:")) {
                        byr = (Integer.parseInt(passport.substring(passport.indexOf("byr:") + 4, passport.indexOf("byr:") + 8)) >= 1920
                                && Integer.parseInt(passport.substring(passport.indexOf("byr:") + 4, passport.indexOf("byr:") + 8)) <= 2002) ? 1 : 0;
                    }

                    int iyr = 0;
                    if (passport.contains("iyr:")) {
                        iyr = (Integer.parseInt(passport.substring(passport.indexOf("iyr:") + 4, passport.indexOf("iyr:") + 8)) >= 2010
                                && Integer.parseInt(passport.substring(passport.indexOf("iyr:") + 4, passport.indexOf("iyr:") + 8)) <= 2020) ? 1 : 0;
                    }

                    int eyr = 0;
                    if (passport.contains("eyr:")) {
                        eyr = (Integer.parseInt(passport.substring(passport.indexOf("eyr:") + 4, passport.indexOf("eyr:") + 8)) >= 2020
                                && Integer.parseInt(passport.substring(passport.indexOf("eyr:") + 4, passport.indexOf("eyr:") + 8)) <= 2030) ? 1 : 0;
                    }

                    int hgt = 0;
                    if (passport.contains("hgt:")) {
                        String h = passport.substring(passport.indexOf("hgt:") + 4);
                        String temp1 = "";
                        String temp2 = "";
                        for (int i=0; i < h.indexOf(' '); i++) {
                            if (Character.isDigit(h.charAt(i))) {
                                temp1 += h.charAt(i);
                            } else {
                                temp2 += h.charAt(i);
                            }
                        }
                        if (temp2.contains("cm") && Integer.parseInt(temp1) >= 150 && Integer.parseInt(temp1) <= 193) {
                            hgt = 1;
                        } else if (temp2.contains("in") && Integer.parseInt(temp1) >= 59 && Integer.parseInt(temp1) <= 76) {
                            hgt = 1;
                        }
                    }

                    int hcl = 0;
                    if (passport.contains("hcl:#") && passport.charAt(passport.indexOf("hcl:") + 11) == ' ') {
                        String h = passport.substring(passport.indexOf("hcl:") + 5, passport.indexOf("hcl:") + 11);
                        boolean v = true;
                        for (char c : h.toCharArray()) {
                            if (!Character.isDigit(c) && !Character.isAlphabetic(c)) {
                                v = false;
                            }
                        }
                        hcl = v ? 1 : 0;
                    }

                    int ecl = 0;
                    if (passport.contains("ecl:") && passport.charAt(passport.indexOf("ecl:") + 7) == ' ') {
                        String color = passport.substring(passport.indexOf("ecl:") + 4, passport.indexOf("ecl:") + 7);
                        if (color.equals("amb") || color.equals("blu") || color.equals("brn") || color.equals("gry") ||
                            color.equals("grn") || color.equals("hzl") || color.equals("oth")) {
                            ecl = 1;
                        }
                    }

                    int pid = 0;
                    if (passport.contains("pid:") && passport.charAt(passport.indexOf("pid:") + 13) == ' ') {
                        String s = passport.substring(passport.indexOf("pid:") + 4, passport.indexOf("pid:") + 13);
                        boolean v = true;
                        for (char c : s.toCharArray()) {
                            if (!Character.isDigit(c)) {
                                v = false;
                            }
                        }
                        pid = v ? 1 : 0;
                    }

                    if (byr + iyr + eyr + hgt + hcl + ecl + pid == 7) {
                        valid++;
                    }

                    passport = "";
                } else {
                    passport += (line + " ");
                }
            }
            myReader.close();

            System.out.println(valid);
        } catch (FileNotFoundException e) {

        }
    }
}
