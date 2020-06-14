package Junior;

import java.util.*;

public class J3_2012
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        String starStr = "";
        String xString = "";
        String whiteString = "";
        for (int i = 0; i < k; i++)
        {
            starStr += "*";
            xString += "x";
            whiteString += " ";
        }
        String line1 = "*x*".replaceAll("\\*", starStr).replaceAll("x", xString);
        String line2 = " xx".replaceAll(" ", whiteString).replaceAll("x", xString);
        String line3 = "* *".replaceAll(" ", whiteString).replaceAll("\\*", starStr);
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < k; j++)
            {
                if (i == 0)
                {
                    System.out.println(line1);
                }
                else if (i == 1)
                {
                    System.out.println(line2);
                }
                else
                {
                    System.out.println(line3);
                }
            }
        }
    }
}