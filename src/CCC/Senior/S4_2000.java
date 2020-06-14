package Senior;

import java.util.*;

public class S4_2000
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = sc.nextInt();
        int[] dists = new int[count];
        for (int i = 0; i < count; i++)
        {
            dists[i] = sc.nextInt();
        }
        Arrays.sort(dists);

        HashSet<Integer> beenTo = new HashSet<>();
        ArrayDeque<Pair> deque = new ArrayDeque<>();
        deque.add(new Pair(num, 0));
        //always tries the largest possible
        while (true)
        {
            for (int i = 0; i < deque.size(); i++)
            {
                Pair s = deque.pop();
                for (int j = count - 1; j >= 0; j--)
                {
                    int newNum = s.x - dists[j];
                    if (!beenTo.contains(newNum))
                    {
                        if (newNum > 0)
                        {
                            Pair pair = new Pair(newNum, s.y + 1);
                            deque.add(pair);
                            beenTo.add(newNum);
                        }
                        else if (newNum == 0)
                        {
                            System.out.println("Roberta wins in " + (s.y + 1) + " strokes.");
                            return;
                        }
                    }
                }
            }
            if (deque.size() == 0)
            {
                System.out.println("Roberta acknowledges defeat.");
                return;
            }
        }

    }

    static class Pair
    {
        public int x;
        public int y;

        public Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}
