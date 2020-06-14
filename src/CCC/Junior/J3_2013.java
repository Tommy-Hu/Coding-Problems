package Junior;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J3_2013
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        Integer f = s.nextInt();
        while (true)
        {
            f++;
            String num = (f.toString());
            List<Character> numsLooped = new ArrayList<>();
            boolean isGood = true;
            for (int i = 0; i < num.length(); i++)
            {
                char c = num.charAt(i);
                if (numsLooped.contains(c))
                {
                    isGood = false;
                    break;
                }
                numsLooped.add(c);
            }


            if (isGood)
            {
                System.out.print(f);
                return;
            }
        }
    }
}
