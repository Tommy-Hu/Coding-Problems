package Junior;

import java.util.*;

public class J4_2012
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int K = s.nextInt();

//        System.out.print(clampPos(78) + "\n");

        String line = s.next();
        String ans = "";
        for (int i = 0; i < line.length(); i++)
        {
            char c = line.charAt(i);
            int fixAmount = getPos(c) - K - 3 * (i + 1);//-1 skips 0
            ans += getChar(clampPos(fixAmount));
        }
        System.out.print(ans);
    }

    static int getPos(char c)
    {
        return (int) c - 'A' + 1;
    }

    static char getChar(int i)
    {
        return (char) (i + 'A' - 1);
    }

    /*
     *Should input a number that had entered getPos(char c){ }
     */
    static int clampPos(int i)
    {
        if (i <= 26 && i > 0) { return i; }
        else if (i > 26)
        {
            i -= 26 * (int) Math.floor((float) i / (float) 27);
            return i;
        }
        else
        {//i<=0
            i += 26 * (int) Math.floor(((float) -i / (float) 27) + 1);//the last + 1 means to skip 0!
            return i;
        }
    }
}
//S=3P+K