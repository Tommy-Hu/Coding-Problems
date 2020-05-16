package Tommy.CCC.Senior;

import java.util.Scanner;

public class S1_2002
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int P = s.nextInt();
        int G = s.nextInt();
        int R = s.nextInt();
        int O = s.nextInt();
        int total = s.nextInt();

        int ways = 0;
        int minWays = 100000;

        for (int p = 0; p <= total / P; p++)
        {
            for (int g = 0; g <= total / G; g++)
            {
                for (int r = 0; r <= total / R; r++)
                {
                    for (int o = 0; o <= total / O; o++)
                    {
                        if (r * R + g * G + p * P + o * O == total)
                        {
                            System.out.println("# of PINK is " + p + " # of GREEN is " + g + " # of RED is " + r + " # of ORANGE is " + o);
                            ways++;
                            int n = p + g + r + o;
                            if (n < minWays)
                            {
                                minWays = n;
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Total combinations is " + ways + ".");
        System.out.println("Minimum number of tickets to print is " + minWays + ".");
    }
}
