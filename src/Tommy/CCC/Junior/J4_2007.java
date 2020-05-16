package Tommy.CCC.Junior;

import java.util.Scanner;

public class J4_2007
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String line1 = sc.nextLine().replaceAll(" ", "");
        String line2 = sc.nextLine().replaceAll(" ", "");

        int i = 0;
        while (true)
        {
            if (line1.length() != 0 && line2.length() != 0)
            {
                String c = String.valueOf(line1.charAt(0));
                line1 = line1.replaceFirst(c, "");
                line2 = line2.replaceFirst(c, "");
            }
            else
            {
                if (line1.length() != line2.length())
                {
                    System.out.println("Is not an anagram.");
                    break;
                }
                else
                {
                    System.out.println("Is an anagram.");
                    break;
                }
            }
        }
    }
}
