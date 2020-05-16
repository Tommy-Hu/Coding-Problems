package Tommy.Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF_A_1342
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int i = 0; i < t; i++)
        {
            long x = readInt();
            long y = readInt();
            long a = readInt();
            long b = readInt();

            if (b > 2 * a)
            {
                b = 2 * a;
            }

            long finalPay = 0;

            while (x != 0 || y != 0)
            {
                if (x == 0)
                {
                    if (y > 0)
                    {
                        finalPay += y * a;
                    }
                    else
                    {
                        finalPay += -y * a;
                    }
                    y = 0;
                }
                else if (y == 0)
                {
                    if (x > 0)
                    {
                        finalPay += x * a;
                    }
                    else
                    {
                        finalPay += x * a;
                    }
                    x = 0;
                }
                else if (x < 0 && y < 0)
                {
                    long max = Math.max(x, y);
                    finalPay += b * -max;
                    x -= max;
                    y -= max;
                }
                else if (x > 0 && y > 0)
                {
                    long min = Math.min(x, y);
                    finalPay += b * min;
                    x -= min;
                    y -= min;
                }
                else if (x > 0 && y < 0)
                {
                    long amountX = x;
                    x -= amountX;
                    finalPay += amountX * a;
                    long amountY = y;
                    y -= amountY;
                    finalPay += a * -amountY;
                }
                else if (x < 0 && y > 0)
                {
                    long amountX = x;
                    x -= amountX;
                    finalPay += -amountX * a;
                    long amountY = y;
                    y -= amountY;
                    finalPay += a * amountY;
                }
            }

            System.out.println(finalPay);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int readInt() throws IOException
    {
        while (st == null || !st.hasMoreTokens())
        {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }
}
