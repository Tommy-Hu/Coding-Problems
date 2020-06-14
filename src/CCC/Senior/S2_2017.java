package Senior;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class S2_2017
{

    static int count = 0;
    static List<Integer> nums = new ArrayList<>();
    static boolean isLastSmallTide = false;

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        count = s.nextInt();
        for (int i = 0; i < count; i++)
        {
            nums.add(s.nextInt());
        }

        String ansLine = "";

        isLastSmallTide = count % 2 != 0;

        for (int i = 0; i < count; i++)
        {
            ansLine = " " + GetNextNum() + ansLine;
        }

        out.print(ansLine.substring(1));
    }

    private static String GetNextNum()
    {
        int extremeNum = isLastSmallTide ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        for (Integer num: nums)
        {
            if (isLastSmallTide)
            {
                if (num < extremeNum)
                {
                    extremeNum = num;
                }
            }
            else
            {
                if (num > extremeNum)
                {
                    extremeNum = num;
                }
            }
        }

        nums.remove(nums.indexOf(extremeNum));

        isLastSmallTide = !isLastSmallTide;

        return String.valueOf(extremeNum);
    }
}
