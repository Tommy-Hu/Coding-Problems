package Tommy.CCC.Junior;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J4_2013
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int minutes = s.nextInt();
        int count = s.nextInt();
        List<Integer> allTimes = new ArrayList<>();
        for (int i = 0; i < count; i++)
        {
            allTimes.add(s.nextInt());
        }

        Collections.sort(allTimes);

        int n = 0;
        int ct = 0;
        for (int f : allTimes)
        {
            n += f;
            if (n > minutes)
            {
                System.out.print(ct);
                return;
            }
            ct++;
        }
        System.out.print(ct);
    }
}
