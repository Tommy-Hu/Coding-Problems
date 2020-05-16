package Tommy.CCC.Senior;

import java.util.*;

public class S3_2012
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        Map<Integer, Integer> nums = new HashMap<>();
        for (int i = 0; i < count; i++)
        {
            int s = sc.nextInt();
            if (nums.containsKey(s))
            {
                nums.put(s, 1 + nums.get(s));
            }
            else
            {
                nums.put(s, 1);
            }
        }

        //key: the number, value: the count of that number
        System.out.println(getHighestDiff(nums));
    }

    static int getHighestDiff(Map<Integer, Integer> nums)
    {
        int highestCount = 0;
        int secondHighestCount = 0;
        List<Integer> highest = new ArrayList<>();
        List<Integer> secondHighest = new ArrayList<>();

        for (Map.Entry<Integer, Integer> pair: nums.entrySet())
        {
            int number = pair.getKey();
            int count = pair.getValue();
            if (count == highestCount)
            {
                highest.add(number);
            }
            else if (count > highestCount)
            {
                highest.clear();
                highest.add(number);
                highestCount = count;
            }
            else if (count > secondHighestCount)
            {
                secondHighest.clear();
                secondHighest.add(number);
                secondHighestCount = count;
            }
            else if (count == secondHighestCount)
            {
                secondHighest.add(number);
            }
        }

        Collections.sort(highest);
        Collections.sort(secondHighest);
        int minH = highest.get(0);
        int maxH = highest.get(highest.size() - 1);
        if (secondHighest.size() != 0)
        {
            int minS = secondHighest.get(0);
            int maxS = secondHighest.get(secondHighest.size() - 1);
            return Math.max(Math.abs(maxH - minS), Math.abs(maxS - minH));
        }
        else
        {
            return Math.abs(maxH - minH);
        }
    }

}
