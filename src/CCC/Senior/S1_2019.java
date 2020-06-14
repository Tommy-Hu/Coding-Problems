package Senior;

import java.util.Scanner;

public class S1_2019
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();

        Integer[][] ans = new Integer[2][2];

        int horiCount = 0;
        int vertCount = 0;

        for (Character c: line.toCharArray())
        {
            if (c.toString().equals("H"))
            {
                horiCount++;
            }
            else
            {
                vertCount++;
            }
        }
        horiCount %= 2;
        vertCount %= 2;

        ans[0][0] = horiCount == 1 ? (vertCount == 1 ? 4 : 3) : (vertCount == 1 ? 2 : 1);
        ans = horiCount == 1 ? (vertCount == 1 ? new Integer[][]{{4, 3}, {2, 1}} : new Integer[][]{{3, 4}, {1, 2}})
                :
                (vertCount == 1 ? new Integer[][]{{2, 1}, {4, 3}} : new Integer[][]{{1, 2}, {3, 4}});

        System.out.print(ans[0][0] + " " + ans[0][1] + "\n" + ans[1][0] + " " + ans[1][1]);
    }
}
