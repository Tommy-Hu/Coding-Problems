package Senior;

import java.util.Arrays;
import java.util.Scanner;

public class S2_2016
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        int N = sc.nextInt();
        int[] dmojistan = new int[N];
        int[] pegland = new int[N];
        for (int i = 0; i < N; i++)
        {
            dmojistan[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++)
        {
            pegland[i] = sc.nextInt();
        }

        if (type == 1)
        {
            //min
            Arrays.sort(dmojistan);
            Arrays.sort(pegland);
            System.out.println(getMin(pegland, dmojistan));
        }
        else
        {
            //max
            int[] big = new int[dmojistan.length * 2];
            System.arraycopy(dmojistan, 0, big, 0, dmojistan.length);
            System.arraycopy(pegland, 0, big, dmojistan.length, pegland.length);
            Arrays.sort(big);
            System.out.println(getMax(big));
        }
    }

    private static int getMin(int[] a1, int[] a2)
    {
        int min = 0;
        for (int i = 0; i < a1.length; i++)
        {
            min += max(a1[i], a2[i]);
        }

        return min;
    }

    private static int getMax(int[] big/*, int[] s2*/)
    {
        int max = 0;
        for (int i = big.length - 1; i >= big.length / 2; i--)
        {
            max += big[i];
        }

        return max;
    }

    private static int max(int a, int b)
    {
        return Math.max(a, b);
    }
}
