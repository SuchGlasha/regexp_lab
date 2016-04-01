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
            long number = Long.parseLong(m.group());
            if (number < 100) m.replaceAll(NumbersToWords.convertLessThanOneThousand((int) number));
            else m.replaceAll(NumbersToWords.convert(number));
        }
    }
}
