package Junior;

import java.util.*;

public class J3_2015_HK
{
    static int N;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();

        boolean[][] attackable = new boolean[N][N];
        for (int i = 0; i < M; i++)
        {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            //horizontal and vertical
            attackable[y][x] = true;
            for (int j = 0; j < N; j++)
            {
                attackable[y][j] = true;
                attackable[j][x] = true;
            }

            //diagonal
            getDiagonal(attackable, x, y, 0, 0);
        }

        //output
        int count = 0;
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (!attackable[i][j])
                {
                    count++;
                }
//                System.out.print(attackable[i][j] ? "O " : "N ");
            }
//            System.out.println();
        }
        System.out.println(count);
    }

    private static void getDiagonal(boolean[][] attackable, int x, int y, int velX, int velY)
    {
        if (x < 0 || y < 0 || x >= N || y >= N)
        {
            return;
        }
        attackable[y][x] = true;
        if (velX == 0 && velY == 0)
        {
            getDiagonal(attackable, x + 1, y + 1, 1, 1);
            getDiagonal(attackable, x - 1, y + 1, -1, 1);
            getDiagonal(attackable, x + 1, y - 1, 1, -1);
            getDiagonal(attackable, x - 1, y - 1, -1, -1);
        }
        else
        {
            if (velX == 1)
            {
                if (velY == 1)
                {
                    getDiagonal(attackable, x + 1, y + 1, 1, 1);
                }
                else
                {
                    getDiagonal(attackable, x + 1, y - 1, 1, -1);
                }
            }
            else
            {
                if (velY == 1)
                {
                    getDiagonal(attackable, x - 1, y + 1, -1, 1);
                }
                else
                {
                    getDiagonal(attackable, x - 1, y - 1, -1, -1);
                }
            }
        }
    }
}