import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_A_1365
{
    static int[][] grid;

    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int __ = 0; __ < t; __++)
        {
            int n = readInt();
            int m = readInt();
            grid = new int[n][m];
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    grid[i][j] = readInt();
                }
            }
            boolean lastPlayedA = false;
            YLoop:
            for (int i = 0; i <= n * 2; i++)
            {
                int y = n / 2 + i / 2;
                if (i % 2 == 0)
                {
                    y = n / 2 - i / 2;
                }
                if (isAvailableRow(y))
                {
                    for (int j = 0; j <= m * 2; j++)
                    {
                        int x = m / 2 + j / 2;
                        if (j % 2 == 0)
                        {
                            x = m / 2 - j / 2;
                        }
                        if (isAvailableColumn(x))
                        {
                            grid[y][x] = 1;
                            lastPlayedA = !lastPlayedA;
                            continue YLoop;
                        }
                    }
                }
            }
            System.out.println(lastPlayedA ? "Ashish" : "Vivek");
        }
    }

    public static boolean isAvailableRow(int y)
    {
        if (y < 0 || y >= grid.length)
        {
            return false;
        }
        int[] row = grid[y];
        for (int value: row)
        {
            if (value == 1)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean isAvailableColumn(int x)
    {
        if (x < 0 || x >= grid[0].length)
        {
            return false;
        }
        for (int[] ints: grid)
        {
            if (ints[x] == 1)
            {
                return false;
            }
        }
        return true;
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
