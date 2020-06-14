

import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class GFG_LongestZigZagSubsequence
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int __ = 0; __ < t; __++)
        {
            int N = readInt();
            int[] sequence = new int[N + 1];
            long[] lengthsIncreasing = new long[N + 1];
            long[] lengthsDecreasing = new long[N + 1];
            for (int i = 1; i <= N; i++)
            {
                sequence[i] = readInt();
                lengthsIncreasing[i] = 1;
                lengthsDecreasing[i] = 1;
            }

            long maxSoFar = 1;
            for (int i = 2; i <= N; i++)
            {
                for (int j = 1; j < i; j++)
                {
                    if (sequence[j] > sequence[i])
                    {
                        lengthsDecreasing[i] = Long.max(lengthsIncreasing[j] + 1, lengthsDecreasing[i]);
                    }
                    else if (sequence[j] < sequence[i])
                    {
                        lengthsIncreasing[i] = Long.max(lengthsDecreasing[j] + 1, lengthsIncreasing[i]);
                    }
                }
                maxSoFar = Long.max(Long.max(maxSoFar, lengthsIncreasing[i]), lengthsDecreasing[i]);
            }
            System.out.println(maxSoFar);
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
