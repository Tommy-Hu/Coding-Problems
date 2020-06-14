package Senior;

import java.util.Scanner;

public class S2_2011
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String[] a = new String[count];
        for (int i = 0; i < count; i++)
        {
            a[i] = sc.next();
        }
        int ans = 0;
        for (int i = 0; i < count; i++)
        {
            if (a[i].equals(sc.next()))
            {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
