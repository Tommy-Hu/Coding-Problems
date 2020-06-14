

import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class GFG_LongestCommonSubsequence
{
    public static void main(String[] args) throws IOException
    {
        int T = readInt();
        for (int __ = 0; __ < T; __++)
        {
            int A = readInt();
            int B = readInt();
            String str1 = br.readLine();
            String str2 = br.readLine();
            int[][] grid = new int[A + 1][B + 1];
            for (int i = 1; i < A + 1; i++)
            {
                for (int j = 1; j < B + 1; j++)
                {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    {
                        grid[i][j] = grid[i - 1][j - 1] + 1;
                    }
                    else
                    {
                        grid[i][j] = Integer.max(grid[i - 1][j], grid[i][j - 1]);
                    }
                }
            }
            System.out.println(grid[A][B]);
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
