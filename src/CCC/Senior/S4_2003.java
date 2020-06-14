package Senior;

import java.util.Arrays;
import java.util.Scanner;

public class S4_2003
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();

        s.nextLine(); //Removes the first empty line

        for (int i = 0; i < count; i++)
        {
            String currentString = s.nextLine();

            int ct = 0;

            String[] suffixs = new String[currentString.length()];
            for (int j = 0; j < currentString.length(); j++)
            {
                suffixs[j] = currentString.substring(j);
            }

            Arrays.sort(suffixs);

            for (int j = 0; j < suffixs.length - 1; j++)
            {
                for (int k = 0; k < suffixs[j].length(); k++)
                {
                    if (suffixs[j].charAt(k) == suffixs[j].charAt(k))
                    {
                        count--;
                    }
                }
            }

            System.out.println(ct + 1 + currentString.length());
        }
    }
}
//abac
