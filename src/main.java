/**
 * Created by Student on 01.04.2016.
 */
import jdk.nashorn.internal.runtime.NumberToString;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        string s = "";
        Scanner in = new Scanner(new File(/*way*/));
        while(in.hasNext())
            s += in.nextLine() + "\r\n";
        in.close();

        Pattern p =Pattern.compile("_?\\d+");
        Matcher m = p.matcher(s);
        while (m.find())
        {
            long number = Long.parseLong(m.group());
            if (number < 100) m.replaceAll(NumberToString.convertLessThanOneThousand((int) number));
            else m.replaceAll(NumberToString.convert(number));
        }
    }
}
