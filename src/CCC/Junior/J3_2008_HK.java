package Junior;

import java.util.*;

public class J3_2008_HK
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int contactCt = sc.nextInt();
        HashMap<Long, String> contacts = new HashMap<>();
        List<Long> countL = new ArrayList<>();
        List<Integer> countC = new ArrayList<>();
        for (int i = 0; i < contactCt; i++)
        {
            String name = sc.next();
            Long num = sc.nextLong();
            contacts.put(num, name);
        }
        int dialCt = sc.nextInt();
        for (int i = 0; i < dialCt; i++)
        {
            long num = sc.nextLong();
            if (countL.contains(num))
            {
                countC.set(countL.indexOf(num), countC.get(countL.indexOf(num)) + 1);
            }
            else
            {
                countL.add(num);
                countC.add(1);
            }
        }

        int largestC = -1;
        long largestL = -1;
        for (int i = 0; i < countC.size(); i++)
        {
            int c = countC.get(i);
            if (c > largestC)
            {
                largestC = c;
                largestL = countL.get(i);
            }
            else if (c == largestC)
            {
                long l = countL.get(i);
                if (l < largestL)
                {
                    largestL = l;
                }
            }
        }

        System.out.println(contacts.get(largestL));
    }
}
