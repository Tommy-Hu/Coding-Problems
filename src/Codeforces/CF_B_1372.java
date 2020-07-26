import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_B_1372
{
    public static void main(String[] args) throws IOException
    {
        long t = readLong();
        TestLoop:
        for (int __ = 0; __ < t; __++)
        {
            long n = readLong();
            if (n % 2 == 0)
            {
                System.out.println(n / 2 + " " + n / 2);
            }
            else
            {
                for (long i = 3; i <= Math.sqrt(n); i += 2)
                {
                    if (n % i == 0)
                    {
                        System.out.println(n / i + " " + (n - n / i));
                        continue TestLoop;
                    }
                }
                System.out.println("1 " + (n - 1));
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
