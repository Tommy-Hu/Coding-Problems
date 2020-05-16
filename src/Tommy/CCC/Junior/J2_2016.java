package Tommy.CCC.Junior;

import java.util.Scanner;

public class J2_2016
{
    public static void main(String[] args)
    {
        int[][] arr = new int[4][4];

        Scanner s = new Scanner(System.in);

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                arr[i][j] = s.nextInt();
            }
        }

        int otherNumsRow = 0;
        int otherNumsColl = 0;

        for (int i = 0; i < 4; i++)
        {
            int lastNumRow = 0;
            int lastNumColl = 0;
            for (int j = 0; j < 4; j++)
            {
                lastNumRow += arr[i][j];
                lastNumColl += arr[j][i];
            }

            if (i == 0)
            {
                otherNumsRow = lastNumRow;
                otherNumsColl = lastNumColl;
            }
            if (otherNumsRow != lastNumRow || otherNumsColl != lastNumColl || otherNumsColl != otherNumsRow)
            {
                System.out.print("not magic\n");
                return;
            }
        }

        System.out.print("magic\n");
    }
}
