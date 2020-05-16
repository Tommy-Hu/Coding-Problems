package Tommy.CCC.Senior;

import java.util.*;

public class S2_2009
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int L = sc.nextInt();
        int[][] grid = new int[L][R];

        for (int i = 0; i < R; i++)
        {
            for (int j = 0; j < L; j++)
            {
                grid[i][j] = sc.nextInt();
            }
        }

        for (int i = R - 1; i >= 0; i--)
        {
            for (int j = 0; j < L; j++)
            {
                grid[i][j] ^= grid[i + 1][j];
            }
        }


    }
}
