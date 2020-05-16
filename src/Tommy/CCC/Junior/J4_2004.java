package Tommy.CCC.Junior;

import java.util.Scanner;

public class J4_2004
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String key = sc.nextLine();
        String message = sc.nextLine();
        message = message.replaceAll("[^a-zA-Z]", "");
        String[] parts = new String[(int) Math.ceil((double) message.length() / (double) key.length())];

        for (int i = 0; i < parts.length; i++)
        {
            int startPos = i * key.length();
            if (i < parts.length - 1)
            {
                parts[i] = message.substring(startPos, startPos + key.length());
            }
            else
            {
                parts[i] = message.substring(startPos);
            }
//            System.out.println(parts[i]);
        }

        for (int i = 0; i < parts.length; i++)
        {
            parts[i] = enc(parts[i], key);
            System.out.print(parts[i]);
        }
    }

    static String enc(String part, String key)
    {
        String ans = "";
        for (int i = 0; i < part.length(); i++)
        {
            int shiftAmount = key.charAt(i) - 'A';
            ans += shift(((int) part.charAt(i) + shiftAmount));
        }
        return ans;
    }

    static char shift(int n)
    {
        n -= 'A';
        int ans;
        if (n <= 25)
        {
            ans = n;
        }
        else
        {
            ans = (n - ((int) Math.floor((double) n / (double) 26) * 26));

        }
        return (char) (ans + 'A');
    }
}
