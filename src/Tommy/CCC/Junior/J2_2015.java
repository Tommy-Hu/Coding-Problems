package Tommy.CCC.Junior;

import java.util.*;
import java.util.regex.Pattern;

public class J2_2015
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();

        if(line.equals(":-)")){System.out.println("happy");return;}
        else if(line.equals(":-(")){System.out.println("sad");return;}

        int happyCt = line.split(Pattern.quote(":-)")).length - 1;
        int sadCt = line.split(Pattern.quote(":-(")).length - 1;

        System.out.print(line + " | happy: " + happyCt + " | sad: " + sadCt + "\n");

        if(happyCt == 0 && sadCt == 0)System.out.println("none");
        else if(happyCt==sadCt)System.out.println("unsure");
        else if(happyCt<sadCt)System.out.println("sad");
        else System.out.println("happy");
    }
}
