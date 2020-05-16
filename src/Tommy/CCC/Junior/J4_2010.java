package Tommy.CCC.Junior;

import java.util.*;

public class J4_2010
{
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        while (true)
        {
            int count = sc.nextInt();
            if (count == 0)
            {
                return;
            }
            if (count <= 1)
            {
                sc.nextLine();
                System.out.println(0);
                continue;
            }
            int endIndex = 1;
            List<Integer> sequence = getSeq(count);
            int curIndex = -1;
            for (int i = 0; i < sequence.size(); i++)
            {
                curIndex++;
                if (curIndex == endIndex)
                {
                    if (!sequence.get(i).equals(sequence.get(0)))
                    {
                        endIndex = i + 1;
                    }
                    else
                    {
                        curIndex = 0;
                    }
                }
                else
                {
                    if (!sequence.get(i).equals(sequence.get(curIndex)))
                    {
                        endIndex = i + 1;
                    }
                }
            }

            System.out.println(endIndex);
        }
    }

    private static List<Integer> getSeq(int count)
    {
        int lastNum = sc.nextInt();
        List<Integer> seq = new ArrayList<>();
        for (int i = 0; i < count - 1; i++)
        {
            int n = sc.nextInt();
            seq.add(n - lastNum);
            lastNum = n;
        }

        return seq;
    }
}
