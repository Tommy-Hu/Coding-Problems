import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_C_1385
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        TestLoop:
        for (int __ = 0; __ < t; __++)
        {
            int n = readInt();
            int[] deque = new int[n];
            for (int i = 0; i < n; i++)
            {
                deque[i] = readInt();
            }

            int small = Integer.MAX_VALUE;
            int big = Integer.MIN_VALUE;
            for (int i = n - 1; i >= 0; i--)
            {
                if (small < deque[i] && small < big)
                {
                    System.out.println(i + 1);
                    continue TestLoop;
                }
                else
                {
                    small = deque[i];
                }

                big = Integer.max(big, deque[i]);
            }
            System.out.println(0);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int readInt() throws IOException
    {
        while (st == null || !st.hasMoreTokens())
        {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }
}
