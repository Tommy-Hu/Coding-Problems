package Tommy.CCC.Senior;

import java.util.Scanner;

public class S1_2009
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int count = 0;
        for (int i = a; i <= b; i++)
        {
            double sqrt = Math.sqrt(i);
            if (sqrt == Math.floor(sqrt))
            {
                //perfectsqr
                float cb = (float)Math.pow(i, 1.0 / 3.0);
                if (cb == Math.round(cb))
                {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
