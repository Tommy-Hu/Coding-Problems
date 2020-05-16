package Tommy.CCC.Senior;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class S1_2015
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        final int ct = s.nextInt();
        List<Integer> arr = new ArrayList<>();
        int ans = 0;
        for (int i = 0; i < ct; i++)
        {
            final int nextNum = s.nextInt();
            if (nextNum == 0)
            {
                ans -= arr.get(arr.size() - 1);
                arr.remove(arr.size() - 1);
                continue;
            }
            arr.add(nextNum);
            ans += nextNum;
        }

        System.out.print(ans);
    }
}
