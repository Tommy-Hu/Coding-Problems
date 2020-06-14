import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_D_1350
{
    public static void main(String[] args) throws IOException
    {
        long t = readLong();
        for (int i = 0; i < t; i++)
        {
            //the answer is yes if there is k at indices greater than 0!
            int n = (int) readLong();
            long k = readLong();
            if (n == 1)
            {
                if (readLong() == k)
                {
                    System.out.println("yes");
                }
                else
                {
                    System.out.println("no");
                }
                continue;
            }
            else if (n == 2)
            {
                long a = readLong();
                long b = readLong();
                if ((b == k && a >= k) || (a == k && b >= k))
                { System.out.println("yes"); }
                else
                { System.out.println("no"); }
                continue;
            }
            boolean lastValid = false;
            boolean secondLastValid = false;
            boolean foundK = false;
            boolean foundValid = false;
            for (int j = 0; j < n; j++)
            {
                long num = readLong();
                if (foundK && foundValid)
                {
                    continue;
                }
                if (num == k)
                {
                    foundK = true;
                    if (lastValid || secondLastValid)
                    {
                        foundValid = true;
                    }
                    else
                    {
                        lastValid = true;
                    }
                }
                else if (num > k)
                {
                    if (lastValid || secondLastValid)
                    {
                        foundValid = true;
                    }
                    else
                    {
                        lastValid = true;
                    }
                }
                else
                {
                    if (lastValid)
                    {
                        secondLastValid = true;
                        lastValid = false;
                    }
                    else
                    {
                        secondLastValid = false;
                    }
                }
            }
            if (foundValid && foundK)
            {
                System.out.println("yes");
            }
            else
            {
                System.out.println("no");
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
