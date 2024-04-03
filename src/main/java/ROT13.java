import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13 {

    char cs;
    char cf;

    ROT13(Character cs, Character cf) {
        this.cs = cs;
        this.cf = cf;
    }

    ROT13() {
        this('a','n');
    }


    public String crypt(String text) throws UnsupportedOperationException {
        return encrypt(text);
    }

    public String encrypt(String text) {
        String[] split = text.split(" ");
        StringBuilder sb = new StringBuilder();
        String ch = String.valueOf(cf).toLowerCase();
        String alphabetSmall = "";
        String alphabetCapital = "";
        String encrypt = "";

        //alphabetSmall
        for (int i = 'a'; i <= 'z'; i++) {
            alphabetSmall += (char) i;
        }
        //alphabetCapital
        for (int i = 'A'; i <= 'Z'; i++) {
            alphabetCapital += (char) i;
        }

        int index = alphabetSmall.indexOf(ch);
        //find sliding alphabet
        String slidingSmall = alphabetSmall.substring(alphabetSmall.length() - index) + alphabetSmall.substring(0,index);
        String slidingCapital = alphabetCapital.substring(alphabetCapital.length() - index) + alphabetCapital.substring(0,index);

        for (int s = 0; s < split.length; s++) {

            for (int p = 0; p < split[s].length(); p++) {
                if (Character.isLowerCase(split[s].charAt(p))) {
                    int smallLetterIndex = 0;
                    for (int m = 0; m < alphabetSmall.length(); m++) {
                        if (split[s].charAt(p) == alphabetSmall.charAt(m)) {
                            smallLetterIndex = m;
                            break;
                        }
                    }
                    encrypt += slidingSmall.charAt(smallLetterIndex);
                } else if (Character.isUpperCase(split[s].charAt(p))) {
                    int capitalLetterIndex = 0;
                    for (int m = 0; m < alphabetCapital.length(); m++) {
                        if (split[s].charAt(p) == alphabetCapital.charAt(m)) {
                            capitalLetterIndex = m;
                            break;
                        }
                    }
                    encrypt += slidingCapital.charAt(capitalLetterIndex);
                } else {
                    encrypt += split[s].charAt(p);
                }
            }//inner loop
            sb.append(encrypt).append(" ");
            encrypt = "";
        }//outer loop

        return sb.toString().trim();

    }

    public String decrypt(String text) {
        return encrypt(text);
    }

    public static String rotate(String s, Character c) {
        int index = s.indexOf(c);  // changed code to simplified code
        return s.substring(index) + s.substring(0, index);
    }



    public  void fileReader() {
        try{
            File file = new File("/Users/asan/Desktop/Projects/SimpleCrypt/sonnet18.txt");
            FileWriter fileWriter = new FileWriter("/Users/asan/Desktop/Projects/SimpleCrypt/sonnet19.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String str = scanner.nextLine();
                fileWriter.write(encrypt(str));
                fileWriter.append("\n");
                fileWriter.flush();
            }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public  void fileReader1() {
        try{
            File file = new File("/Users/asan/Desktop/Projects/SimpleCrypt/sonnet19.txt");
            FileWriter fileWriter = new FileWriter("/Users/asan/Desktop/Projects/SimpleCrypt/sonnet20.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String str = scanner.nextLine();
                fileWriter.write(encrypt(str));
                fileWriter.append("\n");
                fileWriter.flush();
            }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        ROT13 rot13 = new ROT13();
        rot13.fileReader();
        rot13.fileReader1();
    }

}
