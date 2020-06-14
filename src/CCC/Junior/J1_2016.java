package Junior;

import java.util.Scanner;

public class J1_2016
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int wonTimes = 0;
        for (int i = 0; i < 6; i++)
        {
            if (s.next().equals("W"))
            {
                wonTimes++;
            }
        }

        if (wonTimes == 0)
        {
            System.out.print("-1");
        }
        if (wonTimes == 1 || wonTimes == 2)
        {
            System.out.print("3");
        }
        if (wonTimes == 3 || wonTimes == 4)
        {
            System.out.print("2");
        }
        if (wonTimes == 5 || wonTimes == 6)
        {
            System.out.print("1");
        }

    }
}
