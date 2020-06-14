import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_B_1365
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int __ = 0; __ < t; __++)
        {
            int n = readInt();
            int[] values = new int[n];
            boolean isGood = true;
            int lastEl = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++)
            {
                int num = readInt();
                if (lastEl > num)
                {
                    isGood = false;
                }
                lastEl = num;
                values[i] = num;
            }
            boolean has0 = false;
            boolean has1 = false;
            int[] types = new int[n];
            for (int i = 0; i < n; i++)
            {
                int num = readInt();
                if (num == 1)
                {
                    has1 = true;
                }
                else
                {
                    has0 = true;
                }
                types[i] = num;
            }
            if (isGood || (has0 && has1))
            {
                System.out.println("Yes");
            }
            else
            {
                System.out.println("No");
            }
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
