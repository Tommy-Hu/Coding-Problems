package Junior;

import java.util.Scanner;

public class J4_2016
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int H = Integer.parseInt(str.substring(0, 2));
        int M = Integer.parseInt(str.substring(3, 5));

        float left = 120;
        while (left > 0)
        {
            if (isTraffic(H, M))
            {
                M += 2;
            }
            else
            {
                M++;
            }
            left--;

            if (M >= 60)
            {
                M -= 60;
                H++;
            }
            if (H >= 24)
            {
                H -= 24;
            }
        }
        System.out.println(format(H, M));
    }

    private static String format(int h, int m)
    {
        String H = String.valueOf(h);
        String M = String.valueOf(m);
        if (H.length() < 2)
        {
            H = "0" + H;
        }
        if (M.length() < 2)
        {
            M = "0" + M;
        }
        return H + ":" + M;
    }

    static boolean isTraffic(int h, int m)
    {
        float time = h + m * 0.01f;
        return (time >= 7 && time < 10) || (time >= 15 && time < 19);
    }
}
