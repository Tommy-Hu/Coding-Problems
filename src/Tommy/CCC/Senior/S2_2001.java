package Tommy.CCC.Senior;

import java.util.*;

public class S2_2001
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int y = s.nextInt();

        int[][] spiral = new int[20][20];

        int coordX = 10;
        int coordY = 10;

        int action = 0;
        int amountLeft = 1;
        int amountTotal = 1;

        int smallX = 10;
        int smallY = 10;

        int bigX = 10;
        int bigY = 10;

        for (int i = x; i <= y; i++)
        {
            if (action == 0)
            {
                //up
                amountLeft--;
                coordY++;
            }
            else if (action == 1)
            {
                //left
                amountLeft--;
                coordX--;
            }
            else if (action == 2)
            {
                //down
                amountLeft--;
                coordY--;
            }
            else
            {
                //right
                amountLeft--;
                coordX++;
            }

            spiral[spiral.length - coordX][spiral.length - coordY] = i;

            if (coordX < smallX)
            {
                smallX = coordX;
            }
            if (coordY < smallY)
            {
                smallY = coordY;
            }
            if (coordX > bigX)
            {
                bigX = coordX;
            }
            if (coordY > bigY)
            {
                bigY = coordY;
            }

            if (amountLeft == 0)
            {
                action++;
                if (action == 4)
                {
                    i++;
                    if (i <= y)
                    {
                        coordX++;
                        spiral[spiral.length - coordX][spiral.length - coordY] = i;
                        action = 0;
                    }
                    else
                    {
                        break;
                    }

                    amountTotal++;
                }
                else if (action == 1 && i != x)
                {
                    amountTotal++;
                }
                amountLeft = amountTotal;
            }
        }

        printOut(smallY, bigY + 1, spiral, smallX, bigX, action);
    }

    public static void printOut(int smallY, int bigY, int[][] spiral, int smallX, int bigX, int lastAction)
    {
        String s = "";
        for (int i = smallY - 1; i < bigY; i++)
        {
            s += printRow(spiral[i], smallX, bigX);
        }
        if (s.split("\n").length > 1)
        {
//            while (s.split("\n")[0].length() < s.split("\n")[1].length())
//            {
//                s = " " + s;
//            }
            if (lastAction != 3)
            {
                for (int i = smallX; i <= bigX; i++)
                {
                    if (i > smallX)
                    {
                        s = "   " + s;
                    }
                    else
                    {
                        s = "  " + s;
                    }
                }
            }
        }
        System.out.print(s);
    }

    public static String printRow(int[] row, int smallX, int bigX)
    {
        String s = "";
        for (int i = smallX - 1; i <= bigX; i++)
        {
            int num = row[i];
            if (num == 0)
            {
                s += ("   ");
            }
            else
            {
                if (num <= 9)
                {
                    s += ("  ");
                }
                else
                {
                    s += (" ");
                }
                s += (num);
            }
        }
        s = s.trim();
        s += "\n";
        if (s.replaceAll(" ", "").equals("") || s.replaceAll(" ", "").equals("\n"))
        {
            return "";
        }
        return s;
    }
}