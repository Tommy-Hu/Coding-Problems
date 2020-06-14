import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_A_1350
{
    public static void main(String[] args) throws IOException
    {
        long t = readLong();
        for (int i = 0; i < t; i++)
        {
            long n = readLong();
            long k = readLong();
            if (n % 2L == 0)
            {
                //answer is still even!
                System.out.println(n + k * 2L);
            }
            else
            {
                n += f(n);
                //n is definitely even!
                System.out.println(n + (k - 1L) * 2L);
            }
        }
    }

    public static long f(long n)
    {
        if (n % 2 == 0) { return 2; }
        long sqrtN = (long) Math.sqrt(n);
        for (long i = 3; i <= sqrtN; i += 2)
        {
            if (n % i == 0)
            {
                return i;
            }
        }
        return n;
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
