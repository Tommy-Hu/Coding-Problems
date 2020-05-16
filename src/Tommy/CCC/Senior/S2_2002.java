package Tommy.CCC.Senior;

import java.util.Scanner;

public class S2_2002
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        double numerator = sc.nextInt();
        double denominator = sc.nextInt();
        if ((int) (numerator / denominator) == (numerator / denominator))
        {
            System.out.println((int) numerator / (int) denominator);
        }
        else
        {
            double gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;

            if (numerator < denominator)
            {
                System.out.println((int) numerator + "/" + (int) denominator);
            }
            else
            {
                int mixAmount = 0;
                while (true)
                {
                    numerator -= denominator;
                    mixAmount++;
                    if (numerator < denominator)
                    {
                        break;
                    }
                }
                System.out.println(mixAmount + " " + (int) numerator + "/" + (int) denominator);
            }
        }
    }

    static double gcd(double a, double b)
    {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }
}
