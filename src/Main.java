/**
 * Created by Student on 01.04.2016.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

    public static void main(String[] args) {
        String s = "";
        Scanner in = null;
        try {
            in = new Scanner(new File("C://Users//Student//IdeaProjects//regexp_lab//text.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(in.hasNext())
            s += in.nextLine() + "\r\n";
        in.close();

        Pattern p =Pattern.compile("_?\\d+");
        Matcher m = p.matcher(s);
        while (m.find())
        {
            System.out.println("Match started");
            long number = Long.parseLong(m.group());

            s = s.replace(m.group(), NumbersToWords.convert(number));

            try (FileWriter writer = new FileWriter("C://Users//Student//IdeaProjects//regexp_lab//newtext.txt")) {
                writer.write(s);
                writer.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
