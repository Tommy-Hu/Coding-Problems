package Tommy.CCC.Junior;

import java.util.Scanner;

public class J3_2014
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int A = 100;
        int D = 100;

        for (int i = 0; i < n; i++)
        {
            int a = s.nextInt();
            int d = s.nextInt();
            if (a < d)
            {
                A -= d;
            } else if (d < a)
            {
                D -= a;
            }
        }

        System.out.print(A + "\n" + D);
    }
}
