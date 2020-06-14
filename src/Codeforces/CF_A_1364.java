import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_A_1364
{
    public static void main(String[] args) throws IOException
    {
        long t = readLong();
        for (long __ = 0; __ < t; __++)
        {
            int n = (int) readLong();
            long x = readLong();
            long sum = 0;

            int firstIndex = -1;
            int lastIndex = -1;

            for (int i = 0; i < n; i++)
            {
                long a = readLong();
                sum += a;
                if (a % x != 0)
                {
                    if (firstIndex == -1)
                    {
                        firstIndex = i;
                    }
                    lastIndex = i;
                }
            }
            if (sum % x == 0)
            {
                if (lastIndex != -1)
                {
                    System.out.println(Integer.max(n - firstIndex - 1, lastIndex));
                }
                else
                {
                    //all are divisible
                    System.out.println(-1);
                }
            }
            else
            {
                System.out.println(n);
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
