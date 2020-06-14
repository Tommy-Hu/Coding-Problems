package Junior;

import java.util.*;

public class J2_2000
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int start = s.nextInt();
        int last = s.nextInt();

        int count = 0;
        for (int i = start; i <= last; i++)
        {
            String str = Integer.toString(i);
            if (str.contains("2") || str.contains("3") || str.contains("4") || str.contains("5") || str.contains("7"))
            {
                continue;
            }
            else
            {
                int len = str.length();
                boolean isOK = true;
                if (len == 1 && (i == 6 || i == 9))
                {
                    continue;
                }
                for (int j = 0; j <= len / 2; j++)
                {
                    if ((str.charAt(j) == str.charAt(len - j - 1)) && str.charAt(j) != '6' && str.charAt(j) != '9')
                    {
                        continue;
                    }
                    if ((str.charAt(j) == '6' && str.charAt(len - j - 1) == '9') || (str.charAt(j) == '9' && str.charAt(len - j - 1) == '6'))
                    {
                        continue;
                    }
                    else
                    {
                        isOK = false;
                        break;
                    }
                }
                if (isOK)
                {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}