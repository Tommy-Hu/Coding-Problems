

import java.util.*;

public class KnightL_on_the_Chessboard
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i < n; i++)
        {
            for (int j = 1; j < n; j++)
            {
                System.out.print(getCount(i, j, n) + " ");
            }
            System.out.println();
        }
    }

    private static int getCount(int i, int j, int n)
    {
        List<Pair> beenTo = new ArrayList<>();
        ArrayDeque<Pair> deque = new ArrayDeque<>();
        deque.push(new Pair(1, 1));
        beenTo.add(new Pair(1, 1));
        int generation = 0;
        while (deque.size() > 0)
        {
            int ct = deque.size();
            for (int k = 0; k < ct; k++)
            {
                Pair cur = deque.pop();
                if (cur.x == n && cur.y == n)
                {
                    return generation;
                }
                deque.addAll(getLegalPairs(cur, n, i, j, beenTo));
            }
            generation++;
        }

        return -1;
    }

    private static List<Pair> getLegalPairs(Pair p, int n, int x, int y, List<Pair> beenTo)
    {
        List<Pair> ans = new ArrayList<>();
        if (isLegal(p.x + x, p.y + y, n, beenTo))
        {
            ans.add(new Pair(p.x + x, p.y + y));
            beenTo.add(new Pair(p.x + x, p.y + y));
        }
        if (isLegal(p.x - x, p.y + y, n, beenTo))
        {
            ans.add(new Pair(p.x - x, p.y + y));
            beenTo.add(new Pair(p.x - x, p.y + y));
        }
        if (isLegal(p.x - x, p.y - y, n, beenTo))
        {
            ans.add(new Pair(p.x - x, p.y - y));
            beenTo.add(new Pair(p.x - x, p.y - y));
        }
        if (isLegal(p.x + x, p.y - y, n, beenTo))
        {
            ans.add(new Pair(p.x + x, p.y - y));
            beenTo.add(new Pair(p.x + x, p.y - y));
        }
        if (isLegal(p.x + y, p.y + x, n, beenTo))
        {
            ans.add(new Pair(p.x + y, p.y + x));
            beenTo.add(new Pair(p.x + y, p.y + x));
        }
        if (isLegal(p.x - y, p.y + x, n, beenTo))
        {
            ans.add(new Pair(p.x - y, p.y + x));
            beenTo.add(new Pair(p.x - y, p.y + x));
        }
        if (isLegal(p.x - y, p.y - x, n, beenTo))
        {
            ans.add(new Pair(p.x - y, p.y - x));
            beenTo.add(new Pair(p.x - y, p.y - x));
        }
        if (isLegal(p.x + y, p.y - x, n, beenTo))
        {
            ans.add(new Pair(p.x + y, p.y - x));
            beenTo.add(new Pair(p.x + y, p.y - x));
        }


        return ans;
    }

    private static boolean isLegal(int x, int y, int n, List<Pair> beenTo)
    {
        return x > 0 && y > 0 && x <= n && y <= n && !beenTo.contains(new Pair(x, y));
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

        @Override
        public boolean equals(Object o)
        {
            return this.x == ((Pair) o).x &&
                    this.y == ((Pair) o).y;
        }
    }
}
