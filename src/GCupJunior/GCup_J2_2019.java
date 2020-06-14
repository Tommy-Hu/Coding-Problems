

import java.util.Scanner;

public class GCup_J2_2019
{
    static int[][] aliens = new int[10][10];

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int coins = sc.nextInt();
        int drinks = sc.nextInt();
        int coinsNeeded = sc.nextInt();
        int drinksNeeded = sc.nextInt();

        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                aliens[i][j] = sc.nextInt();
            }
        }

        System.out.println(getMax(Math.min(coins / coinsNeeded, drinks / drinksNeeded), new int[]{
                0, 0, 0, 0, 0, 0
        }));
    }

    private static int getMax(int levelsAvailable, int[] level)
    {
        if (levelsAvailable <= 0)
        {
            return getLevel(level);
        }

        int largest = -10000000;
        levelsAvailable--;
        largest = Math.max(largest, getLevel(level));
        for (int i = 0; i < 6; i++)
        {
            level[i]++;
            largest = Math.max(largest, getLevel(level));
            largest = Math.max(largest, getMax(levelsAvailable, level));
            level[i]--;
        }

        return largest;
    }

    private static int getLevel(int[] level)
    {
        return aliens[0][level[0]] + aliens[1][level[1]] + aliens[2][level[2]] + aliens[3][level[3]] + aliens[4][level[4]] + aliens[5][level[5]];
    }
}
