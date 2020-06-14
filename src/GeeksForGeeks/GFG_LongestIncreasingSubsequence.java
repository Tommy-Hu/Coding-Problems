

import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class GFG_LongestIncreasingSubsequence
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int i = 0; i < t; i++)
        {
            int n = readInt();
            int[] arr = new int[n + 1];
            int[] lengthArr = new int[n + 1];
            for (int j = 1; j <= n; j++)
            {
                arr[j] = readInt();
                lengthArr[j] = 1;
            }

            //get the longest to each point
            int maxSoFar = 1;
            for (int j = 1; j <= n; j++)
            {
                for (int cur = j + 1; cur <= n; cur++)
                {
                    if (lengthArr[cur] < lengthArr[j] + 1 && arr[cur] > arr[j])
                    {
                        lengthArr[cur] = lengthArr[j] + 1;
                        maxSoFar = Integer.max(maxSoFar, lengthArr[cur]);
                    }
                }
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
