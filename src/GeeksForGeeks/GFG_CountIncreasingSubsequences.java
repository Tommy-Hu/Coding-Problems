

import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class GFG_CountIncreasingSubsequences
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int __ = 0; __ < t; __++)
        {
            int N = readInt();
            int[] digits = new int[N + 1];
            long[] counts = new long[N + 1];
            for (int i = 1; i <= N; i++)
            {
                digits[i] = readInt();
                counts[i] = 1;
            }

            for (int i = 1; i <= N; i++)
            {
                for (int j = 1; j < i; j++)
                {
                    if (digits[j] < digits[i])
                    {
                        counts[i] += counts[j];
                    }
                }
            }
            long totalCount = 0;
            for (int i = 1; i <= N; i++)
            {
                totalCount += counts[i];
            }
            System.out.println(totalCount);
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
