package Senior;

import java.util.*;

public class S2_2005
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();
        int r = sc.nextInt();

        int posX = 0;
        int posY = 0;

        while (true)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (x == 0 && y == 0)
            {
                return;
            }

            posX += x;
            posY += y;

            posX = Clamp(posX, c, 0);
            posY = Clamp(posY, r, 0);

            System.out.println(posX + " " + posY);
        }
    }

    public static int Clamp(int number, int max, int min)
    {
        if (min > max)
        {
            int f = min;
            min = max;
            max = f;
        }

        if (number > max)
        {
            number = max;
        }

        if (number < min)
        {
            number = min;
        }

        return number;
    }
}