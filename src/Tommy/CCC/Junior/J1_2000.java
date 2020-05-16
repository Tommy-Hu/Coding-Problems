package Tommy.CCC.Junior;

import java.util.*;

public class J1_2000
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int start = s.nextInt();
        int length = s.nextInt();

        // System.out.println(start + "||" + length);

        System.out.println("Sun Mon Tue Wed Thr Fri Sat");

        int count = 0;

        for (int i = 1; i < start; i++)
        {
            if (i < start - 1)
            {
                System.out.print("    ");
            }
            else
            {
                System.out.print("   ");
            }
            count++;
        }

        for (int i = start; i < length + start; i++)
        {
            if ((i - 1) % 7 == 0)
            {
                if (i - 1 > 0)
                {
                    System.out.print("\n");
                }
            }
            else
            {
                System.out.print(" ");
            }

            System.out.print(" ");

            int currentDate = (i - start + 1);

            if (currentDate < 10)
            {
                System.out.print(" ");
            }

            System.out.print(currentDate);
        }
        System.out.println("");
    }
}