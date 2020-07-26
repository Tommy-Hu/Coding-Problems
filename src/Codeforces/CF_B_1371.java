import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_B_1371
{
    public static void main(String[] args) throws IOException
    {
        long t = readLong();
        for (long __ = 0; __ < t; __++)
        {
            long n = readLong();
            long r = readLong();
            long count = 0;
            if (r >= n)
            {
                count = n * (n - 1) / 2;//maybe +1?
                count++;
            }
            else
            {
                long sum = r + 1;
                count = sum * (sum - 1) / 2;
            }

            System.out.println(count);
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
