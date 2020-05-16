package Tommy.Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF_C_1305
{
    public static void main(String[] args) throws IOException
    {
        int n = readInt();
        int m = readInt();

        int[] integers = new int[n];
        for (int i = 0; i < n; i++)
        {
            integers[i] = readInt();
        }
        long bigAnswer = 1;
        for (int i = 0; i < n; i++)
        {
            int cur = integers[i];
            for (int j = i + 1; j < n; j++)
            {
                bigAnswer *= Math.abs(cur - integers[j]);
            }
        }

        System.out.println(bigAnswer % m);
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
