package Tommy.CCC.Senior;

import java.util.*;

public class S2_2015
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int J = sc.nextInt();
        int A = sc.nextInt();
        Map<Integer, Integer> jerseys = new HashMap<>();
        for (int i = 0; i < J; i++)
        {
            String n = sc.next();
            jerseys.put(i + 1, n.equals("M") ? 2 : (n.equals("S") ? 1 : 3));
        }

        int satisfied = 0;
        for (int i = 0; i < A; i++)
        {
            String n = sc.next();
            int wantedSize = n.equals("M") ? 2 : (n.equals("S") ? 1 : 3);
            int wantedNum = sc.nextInt();

            if (jerseys.containsKey(wantedNum) && jerseys.get(wantedNum) >= wantedSize)
            {
                satisfied++;
                jerseys.remove(wantedNum);
            }
        }

        System.out.println(satisfied);
    }
}
