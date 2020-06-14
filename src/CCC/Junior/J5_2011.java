package Junior;

import java.util.*;

public class J5_2011
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int peopleCt = s.nextInt();

        HashMap<Integer, ArrayList<Integer>> people = new HashMap<>();
        for (int i = 1; i <= peopleCt; i++)
        {
            people.put(i, new ArrayList<>());
        }
        for (int i = 1; i < peopleCt; i++)
        {
            people.get(s.nextInt()).add(i);
        }
        System.out.println(getNum(people, peopleCt));
    }

    public static int getNum(HashMap<Integer, ArrayList<Integer>> people, int current)
    {
        int count = 1;
        for (int i = 0; i < people.get(current).size(); i++)
        {
            int childNum = people.get(current).get(i);
            count *= (getNum(people, childNum) + 1);
        }

        return count;
    }
}
