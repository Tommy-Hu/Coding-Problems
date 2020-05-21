package Tommy.Codeforces;

import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.zip.Inflater;

public class CF_A_1354
{
    public static void main(String[] args) throws IOException
    {
        long t = readLong();
        for (int i = 0; i < t; i++)
        {
            long a = readLong();
            long b = readLong();
            long c = readLong();
            long d = readLong();
            if (b < a)
            {
                if (c <= d)
                {
                    System.out.println("-1");
                    continue;
                }
                long dif = c - d;
                long timeLeft = a - b;//how much time he wants to sleep still
                long times = (long) Math.ceil(timeLeft / (double) dif);//how many times he repeats the alarm process
                System.out.println(b + c * times);
            }
            else
            {
                System.out.println(b);
            }
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static long readLong() throws IOException
    {
        while (st == null || !st.hasMoreTokens())
        {
            st = new StringTokenizer(br.readLine());
        }
        return Long.parseLong(st.nextToken());
    }
}
