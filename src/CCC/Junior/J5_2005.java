package Junior;

import java.util.*;

public class J5_2005
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        while (true)
        {
            String word = sc.next();
            if (word.equals("X"))
            {
                return;
            }
            else
            {
                System.out.println(IsMWord(word) ? "YES" : "NO");
            }
        }
    }

    private static boolean IsAWord(String word)
    {
        if (word.equals("A")) { return true; }
        else if (word.equals(""))
        {
            return false;
        }
        else if (word.length() == 1)
        {
            return false;
        }
        else
        {
            return IsMWord(word.substring(1, word.length() - 1)) && word.startsWith("B") && word.endsWith("S");
        }
    }

    private static boolean IsMWord(String word)
    {
        if (IsAWord(word)) { return true; }
        else
        {
            for (int i = 0; i < word.length(); i++)
            {
                char c = word.charAt(i);
                if (c == 'N')
                {
                    if (IsAWord(word.substring(0, i)) && IsMWord(word.substring(i + 1)))
                    {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}