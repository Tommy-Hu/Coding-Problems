package Tommy.CCC.Junior;

import java.util.*;

public class J4_2005
{
    static boolean[][] went;
    static int bigW;
    static int bigH;
    static int smallW;
    static int smallH;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        bigW = sc.nextInt();
        bigH = sc.nextInt();
        smallW = sc.nextInt();
        smallH = sc.nextInt();
        int steps = sc.nextInt();

        went = new boolean[bigH][bigW];

        for (int i = 0; i < bigH; i++)
        {
            if (i < smallH || i >= bigH - smallH)
            {
                for (int j = 0; j < bigW; j++)
                {
                    if (j < smallW || j >= bigW - smallW)
                    {
                        went[i][j] = true;
                    }
                }
            }
        }

        int velX = 1;
        int velY = 0;
        int posX = smallW;
        int posY = 0;
        setWent(posX, posY);
        for (int i = 0; i < steps; i++)
        {
            if (velX == 1)
            {
                if (check(posX, posY - 1))
                {
                    posY--;
                    setWent(posX, posY);
                    velY = -1;
                    velX = 0;
                }
                else if (check(posX + 1, posY))
                {
                    posX++;
                    setWent(posX, posY);
                }
                else if (check(posX, posY + 1))
                {
                    posY++;
                    setWent(posX, posY);
                    velY = 1;
                    velX = 0;
                }
            }
            else if (velX == -1)
            {
                if (check(posX, posY + 1))
                {
                    posY++;
                    setWent(posX, posY);
                    velY = 1;
                    velX = 0;
                }
                else if (check(posX - 1, posY))
                {
                    posX--;
                    setWent(posX, posY);
                }
                else if (check(posX, posY - 1))
                {
                    posY--;
                    setWent(posX, posY);
                    velY = -1;
                    velX = 0;
                }
            }
            else if (velY == 1)
            {
                //going down
                if (check(posX + 1, posY))
                {
                    posX++;
                    setWent(posX, posY);
                    velY = 0;
                    velX = 1;
                }
                else if (check(posX, posY + 1))
                {
                    posY++;
                    setWent(posX, posY);
                }
                else if (check(posX - 1, posY))
                {
                    posX--;
                    setWent(posX, posY);
                    velX = -1;
                    velY = 0;
                }
            }
            else
            {
                //going up
                if (check(posX - 1, posY))
                {
                    posX--;
                    setWent(posX, posY);
                    velY = 0;
                    velX = -1;
                }
                else if (check(posX, posY - 1))
                {
                    posY--;
                    setWent(posX, posY);
                }
                else if (check(posX + 1, posY))
                {
                    posX++;
                    setWent(posX, posY);
                    velX = 1;
                    velY = 0;
                }
            }
        }

        System.out.print((posX + 1) + "\n" + (posY + 1));
    }

    static boolean check(int posX, int posY)
    {
        return posX >= 0 && posX < bigW && posY >= 0 && posY < bigH && !went[posY][posX];
    }

    static void setWent(int posX, int posY)
    {
        went[posY][posX] = true;
    }
}
