

import java.util.Scanner;

public class GCup_J1_2019
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();//how many other aliens
        int M = sc.nextInt();//current rating
        int A = sc.nextInt();//winning rating amount
        int B = sc.nextInt();//losing rating amount
        int C = sc.nextInt();//amount of games that will be played

        boolean[] winLoose = new boolean[N];
        for (int i = 0; i < N; i++)
        {
            winLoose[i] = sc.nextInt() == 1;
        }

        int[] opponents = new int[C];
        for (int i = 0; i < C; i++)
        {
            opponents[i] = sc.nextInt() - 1;
        }

        for (int i: opponents)
        {
            if (winLoose[i])
            {
                M += A;
            }
            else
            {
                M -= B;
            }
        }

        System.out.println(M);
    }
}
