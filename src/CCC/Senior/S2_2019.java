package Senior;

import java.util.Scanner;

public class S2_2019
{
    static final int LIMIT = 1000000;
    static boolean[] primes = new boolean[LIMIT * 2 + 1];

    public static void main(String[] args)
    {
        findPrimes(primes.length);

        Scanner s = new Scanner(System.in);
        int ct = s.nextInt();
        for (int i = 0; i < ct; i++)
        {
            int[] a = getTwoPrimes(s.nextInt() * 2);
            System.out.println(a[0] + " " + a[1]);
        }
    }

    static void findPrimes(int n)
    {
        primes = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
        {
            primes[i] = true;
        }
        primes[0] = false;
        primes[1] = false;

        final int u = (int) Math.sqrt(n);
        for (int i = 2; i <= u; i++)
        {
            if (primes[i])
            {
                int f = i + i;
                for (int j = 2; i * j <= n; j++)
                {
                    primes[f] = false;
                    f += i;
                }
            }
        }

    }

    static int[] getTwoPrimes(int n)
    {
        for (int i = 2; i < n; i++)
        {
            if (primes[i] && primes[n - i])
            {
                //Once found one prime, minus
                return new int[]{i, n - i};
            }
        }
        return null;
    }
}