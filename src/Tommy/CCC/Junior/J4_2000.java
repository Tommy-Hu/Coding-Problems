package Tommy.CCC.Junior;

import java.util.*;

public class J4_2000
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        List<Integer> flows = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            flows.add(s.nextInt());
        }

        int cmd = -1;

        while (cmd != 77)
        {
            cmd = s.nextInt();
            if (cmd == 99)
            {
                //Split
                int index = s.nextInt() - 1;
                int percentage = s.nextInt();
                int amountToLeft = flows.get(index) * percentage / 100;
                flows.add(index + 1, flows.get(index) - amountToLeft);
                flows.set(index, amountToLeft);
            }
            else if (cmd == 88)
            {
                //Rejoin
                int index = s.nextInt() - 1;
                flows.set(index, flows.get(index) + flows.get(index + 1));
                flows.remove(index + 1);
            }
        }

        int size = flows.size();

        for (int i = 0; i < size; i++)
        {
            System.out.print(flows.get(i));
            if (i < size - 1)
            {
                System.out.print(" ");
            }
        }
    }
}