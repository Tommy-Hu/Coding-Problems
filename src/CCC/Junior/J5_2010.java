package Junior;

import java.util.*;

public class J5_2010
{
    static int endX;
    static int endY;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int startX = sc.nextInt();
        int startY = sc.nextInt();
        endX = sc.nextInt();
        endY = sc.nextInt();

        System.out.println(findPos(new Pair(startX, startY, 1)));
    }

    public static int findPos(Pair pair)
    {
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(pair);
        while (true)
        {
            pair = queue.pop();
            if (!pair.isValid())
            {
                continue;
            }
            if (pair.x == endX && pair.y == endY)
            {
                return pair.layer - 1;
            }

            int layer = pair.layer + 1;
            Pair one = new Pair(pair.x + 1, pair.y + 2, layer);
            Pair two = new Pair(pair.x + 2, pair.y + 1, layer);
            Pair three = new Pair(pair.x + 2, pair.y - 1, layer);
            Pair four = new Pair(pair.x + 1, pair.y - 2, layer);
            Pair five = new Pair(pair.x - 1, pair.y - 2, layer);
            Pair six = new Pair(pair.x - 2, pair.y - 1, layer);
            Pair seven = new Pair(pair.x - 2, pair.y + 1, layer);
            Pair eight = new Pair(pair.x - 1, pair.y + 2, layer);

            queue.add(one);
            queue.add(two);
            queue.add(three);
            queue.add(four);
            queue.add(five);
            queue.add(six);
            queue.add(seven);
            queue.add(eight);
        }
    }

    public static class Pair
    {
        public int x;
        public int y;
        public int layer;

        public Pair()
        {

        }

        public Pair(int x, int y, int layer)
        {
            this.x = x;
            this.y = y;
            this.layer = layer;
        }

        public boolean isValid()
        {
            return x > 0 && x <= 8 && y > 0 && y <= 8;
        }
    }
}
