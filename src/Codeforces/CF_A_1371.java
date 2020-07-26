import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_A_1371
{
    public static void main(String[] args) throws IOException
    {
        long t = readLong();
        for (long __ = 0; __ < t; __++)
        {
            long n = readLong();
            if (n == 1 || n == 2)
            {
                System.out.println(1);
            }
            else if (n == 3)
            {
                System.out.println(2);
            }
            else
            {
                System.out.println(n % 2 == 0 ? n / 2 : n / 2 + 1);
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
