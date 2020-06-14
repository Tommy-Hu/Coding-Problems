package Junior;

import java.util.HashMap;
import java.util.Scanner;

public class J3_2006
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        HashMap<Character, Integer> keys = new HashMap<Character, Integer>()
        {
            {

                put('a', 1);
                put('b', 2);
                put('c', 3);

                put('d', 1);
                put('e', 2);
                put('f', 3);

                put('g', 1);
                put('h', 2);
                put('i', 3);

                put('j', 1);
                put('k', 2);
                put('l', 3);

                put('m', 1);
                put('n', 2);
                put('o', 3);

                put('p', 1);
                put('q', 2);
                put('r', 3);
                put('s', 4);

                put('t', 1);
                put('u', 2);
                put('v', 3);

                put('w', 1);
                put('x', 2);
                put('y', 3);
                put('z', 4);

            }
        };

        Loop:
        while (true)
        {
            String line = sc.next();
            if (line.equals("halt"))
            {
                break;
            }
            int totalSec = 0;
            char lastKey = '*';
            for (int i = 0; i < line.length(); i++)
            {
                char c = line.charAt(i);
                totalSec += keys.get(c);
                if (isSame(lastKey, c))
                {
                    totalSec += 2;
                }
                else
                {
                    lastKey = c;
                }
            }

            System.out.println(totalSec);

        }
    }

    public static boolean isSame(char a, char b)
    {
        if (a == 'a' || a == 'b' || a == 'c')
        {
            if (b == 'a' || b == 'b' || b == 'c')
            {
                return true;
            }
        }
        else if (a == 'd' || a == 'e' || a == 'f')
        {
            if (b == 'd' || b == 'e' || b == 'f')
            {
                return true;
            }
        }
        else if (a == 'g' || a == 'h' || a == 'i')
        {
            if (b == 'g' || b == 'h' || b == 'i')
            {
                return true;
            }
        }
        else if (a == 'j' || a == 'k' || a == 'l')
        {
            if (b == 'j' || b == 'k' || b == 'l')
            {
                return true;
            }
        }
        else if (a == 'm' || a == 'n' || a == 'o')
        {
            if (b == 'm' || b == 'n' || b == 'o')
            {
                return true;
            }
        }
        else if (a == 'p' || a == 'q' || a == 'r' || a == 's')
        {
            if (b == 'p' || b == 'q' || b == 'r' || b == 's')
            {
                return true;
            }
        }
        else if (a == 't' || a == 'u' || a == 'v')
        {
            if (b == 't' || b == 'u' || b == 'v')
            {
                return true;
            }
        }
        else if (a == 'w' || a == 'x' || a == 'y' || a == 'z')
        {
            if (b == 'w' || b == 'x' || b == 'y' || b == 'z')
            {
                return true;
            }
        }
        return false;
    }
}
