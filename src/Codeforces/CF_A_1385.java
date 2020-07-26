import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_A_1385
{
    public static void main(String[] args) throws IOException
    {
        long t = readLong();
        for (int __ = 0; __ < t; __++)
        {
            long x = readLong();
            long y = readLong();
            long z = readLong();

            if (x != y && x != z && y != z)
            {
                System.out.println("NO");
            }
            else if (x == y && y == z)
            {
                System.out.println("YES");
                System.out.println((x + " ").repeat(3));
            }
            else
            {
                if (x == y && z > x)
                {
                    System.out.println("NO");
                }
                else if (x == z && y > x)
                {
                    System.out.println("NO");
                }
                else if (y == z && x > y)
                {
                    System.out.println("NO");
                }
                else
                {
                    System.out.println("YES");
                    if (x == z)
                    {
                        System.out.println(x + " " + y + " 1");
                    }
                    else
                    {
                        System.out.println(x + " " + z + " 1");
                    }
                }
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
