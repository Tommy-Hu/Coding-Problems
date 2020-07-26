import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_C_1371
{
    public static void main(String[] args) throws IOException
    {
        long t = readLong();
        for (long __ = 0; __ < t; __++)
        {
            long a = readLong();//vanilla cookies
            long b = readLong();//chocolate cookies
            long n = readLong();//likes vanilla when more vanilla than chocolate (I.E. always pick the cookies from the
//                                largest piles)

            long m = readLong();//likes chocolate (I.E. always pick the cookies from the smallest piles)

            if (a + b < n + m)
            {
                System.out.println("No");
                continue;
            }

            long lessCookies = Long.min(a, b);
            long moreCookies = Long.max(a, b);
            if (m <= lessCookies)
            {
                if (n <= (moreCookies + (lessCookies - m)))
                {
                    System.out.println("Yes");
                }
                else
                {
                    System.out.println("No");
                }
            }
            else
            {
                System.out.println("No");
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
