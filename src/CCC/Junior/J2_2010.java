package Junior;

import java.util.*;

public class J2_2010
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int s = sc.nextInt();

        int N = ((int) Math.floor((float) s / (a + b)) * (a - b)) + (s % (a + b)) - Math.max(s % (a + b) - a, 0);
        int B = ((int) Math.floor((float) s / (c + d)) * (c - d)) + (s % (c + d)) - Math.max(s % (c + d) - c, 0);

        System.out.println(N > B ? "Nikky" : (N == B ? "Tied" : "Byron"));
    }
}