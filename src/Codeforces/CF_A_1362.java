import java.io.*;
import java.util.*;

public class CF_A_1362
{
    public static void main(String[] args) throws IOException
    {
        long t = readLong();
        for (int __ = 0; __ < t; __++)
        {
            long a = readLong();
            long b = readLong();
            long temp = a;
            a = Long.min(a, b);
            b = Long.max(b, temp);
            if (a == b)
            {
                pw.println(0);
                continue;
            }
            if (b % a != 0)
            {
                pw.println(-1);
                continue;
            }
            long result = b / a;
            long steps = 0;
            if (!isPowerOfTwo(result))
            {
                pw.println(-1);
                continue;
            }
            while (result > 1)
            {
                if (result % 8 == 0)
                {
                    result /= 8;
                }
                else if (result % 4 == 0)
                {
                    result /= 4;
                }
                else
                {
                    result /= 2;
                }
                steps++;
            }
            pw.println(steps);
        }
        pw.close();
    }

    static boolean isPowerOfTwo(long x)
    {
        return x != 0 && (x & (x - 1)) == 0;
    }

    static final PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
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
