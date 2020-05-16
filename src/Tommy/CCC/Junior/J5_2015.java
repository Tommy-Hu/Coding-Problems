package Tommy.CCC.Junior;

import java.util.*;

public class J5_2015
{
    static int pies;
    static int people;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        pies = sc.nextInt();
        people = sc.nextInt();
        if (pies == people || people == 1)
        {
            System.out.println(1);
            return;
        }
        //start from 1, 1, 1, 1, ..., pies - people + 1
        int[] way = new int[people];
        for (int i = 0; i < way.length - 1; i++)
        {
            way[i] = 1;
        }
        way[way.length - 1] = pies - people + 1;

//        System.out.println(getWays(new Pair(people - 1, way, 1)));
    }

    static int getWays(List<Integer> dif, int minusAmount, int last)
    {
        int count = 0;
        if (dif.size() <= 1)
        {
            return 1;
        }
        else
        {
            int z = dif.get(0);
            if (z < last)
            {
                //dif[0] ++;
                minusAmount += last - z;
                dif.set(0, last);
            }
//            for (int i = 0; i < ; i++)
//            {
//
//            }
            dif.remove(0);
            count += getWays(dif, minusAmount, dif.get(0));
            return count;
        }
    }
}
