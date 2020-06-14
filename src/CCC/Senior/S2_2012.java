package Senior;

import java.util.Scanner;

public class S2_2012
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        String line = sc.nextLine();

        sc = new Scanner(line);
        int lastVal = 10000;
        int lastCt = 0;
        sc.useDelimiter("\\D");

        while (sc.hasNextInt())
        {
            int ct = sc.nextInt();
            line = line.substring(String.valueOf(ct).length());
            char c = line.charAt(0);
            line = line.substring(1);
            int val = getVal(c);
            if (val > lastVal)
            {
                total -= 2 * lastVal * lastCt;
            }
            total += val * ct;
            lastVal = val;
            lastCt = ct;

            sc = new Scanner(line);
            sc.useDelimiter("\\D");
        }

        System.out.print(total);
    }

    static int getVal(char c)
    {
        if (c == 'I')
        {
            return 1;
        }
        else if (c == 'V')
        {
            return 5;
        }
        else if (c == 'X')
        {
            return 10;
        }
        else if (c == 'L')
        {
            return 50;
        }
        else if (c == 'C')
        {
            return 100;
        }
        else if (c == 'D')
        {
            return 500;
        }
        else if (c == 'M')
        {
            return 1000;
        }
        return '\n';
    }
}
