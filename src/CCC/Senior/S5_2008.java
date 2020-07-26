package Senior;

import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class S5_2008
{
    public static void main(String[] args) throws IOException
    {
        int n = readInt();
        for (int __ = 0; __ < n; __++)
        {
            int A = readInt();
            int B = readInt();
            int C = readInt();
            int D = readInt();

            int[][][][] grid = new int[A + 1][B + 1][C + 1][D + 1];

            for (int a = 0; a <= A; a++)
            {
                for (int b = 0; b <= B; b++)
                {
                    for (int c = 0; c <= C; c++)
                    {
                        for (int d = 0; d <= D; d++)
                        {
                            if ((a >= 2 && b >= 1 && d >= 2 && grid[a - 2][b - 1][c][d - 2] == -1) ||
                                    (a >= 1 && b >= 1 && c >= 1 && d >= 1 && grid[a - 1][b - 1][c - 1][d - 1] == -1) ||
                                    (c >= 2 && d >= 1 && grid[a][b][c - 2][d - 1] == -1) ||
                                    (b >= 3 && grid[a][b - 3][c][d] == -1) ||
                                    (a >= 1 && d >= 1 && grid[a - 1][b][c][d - 1] == -1))
                            {
                                grid[a][b][c][d] = 1;
                            }
                            else
                            {
                                grid[a][b][c][d] = -1;
                            }
                        }
                    }
                }
            }

            System.out.println(grid[A][B][C][D] == 1 ? "Patrick" : "Roland");
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
