package Tommy.CCC.Junior;

import java.util.Scanner;

public class J1_2003
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int s = sc.nextInt();
        int h = sc.nextInt();

        int tineWidth = 3 + 2 * s;

        for (int i = 0; i < t; i++)
        {
            //Draw tines
            System.out.print("*");
            for (int j = 0; j < s; j++)
            {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j < s; j++)
            {
                System.out.print(" ");
            }
            System.out.print("*\n");
        }

        for (int i = 0; i < tineWidth; i++)
        {
            //Draw horizontal line
            System.out.print("*");
        }

        System.out.print("\n");

        for (int i = 0; i < h; i++)
        {
            //Draw handle
            for (int j = 0; j < tineWidth / 2; j++)
            {
                System.out.print(" ");
            }
            System.out.print("*\n");
        }
    }
}
