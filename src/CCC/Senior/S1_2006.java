package Senior;

import java.util.*;

public class S1_2006
{
    enum stat
    {
        r, d, b
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String p1 = sc.nextLine();
        String p2 = sc.nextLine();

        int nums = sc.nextInt();
        String[] kids = new String[nums];
        boolean[] kidsOK = new boolean[nums];

        sc.nextLine();

        for (int i = 0; i < nums; i++)
        {
            kids[i] = sc.nextLine();
            kidsOK[i] = true;
        }

        for (int i = 0; i < 5; i++)
        {
            stat pstat = getStat(p1.substring(i * 2, i * 2 + 2), p2.substring(i * 2, i * 2 + 2));
            for (int j = 0; j < nums; j++)
            {
                stat cstat = getStat(kids[j].charAt(i));
                if (!pstat.equals(cstat) && !pstat.equals(stat.b))
                {
                    kidsOK[j] = false;
                }
            }
        }

        for (boolean b: kidsOK)
        {
            if (b)
            {
                System.out.println("Possible baby.");
            }
            else
            {
                System.out.println("Not their baby!");
            }
        }
    }

    public static stat getStat(String p1, String p2)
    {
        boolean dp11 = false;
        char p11 = p1.charAt(0);
        if (Character.toLowerCase(p11) != (p11))
        {//capital
            dp11 = true;
        }
        boolean dp12 = false;
        char p12 = p1.charAt(1);
        if (Character.toLowerCase(p12) != (p12))
        {//capital
            dp12 = true;
        }

        boolean dp21 = false;
        char p21 = p2.charAt(0);
        if (Character.toLowerCase(p21) != (p21))
        {//capital
            dp21 = true;
        }
        boolean dp22 = false;
        char p22 = p2.charAt(1);
        if (Character.toLowerCase(p22) != (p22))
        {//capital
            dp22 = true;
        }

        if ((dp11 == dp12 && dp11) || (dp21 == dp22 && dp21))
        {
            return stat.d;
        }
        else if (!dp11 && !dp12 && !dp21 && !dp22)
        {
            return stat.r;
        }
        else
        {
            return stat.b;
        }
    }

    public static stat getStat(char c)
    {
        if (Character.toLowerCase(c) != c)
        {//capital
            return stat.d;
        }
        return stat.r;
    }
}