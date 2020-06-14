package Senior;

import java.util.*;

public class S3_2018
{
    static char[][] grid;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        sc.nextLine();

        //read input
        int startX = 0;
        int startY = 0;

        grid = new char[rows][columns];
        for (int i = 0; i < rows; i++)
        {
            String line = sc.nextLine();
            char[] arr = line.toCharArray();
            grid[i] = arr;

            for (int j = 0; j < columns; j++)
            {
                if (arr[j] == 'S')
                {
                    startX = j;
                    startY = i;
                }
            }
        }

        //iteration
        List<Pair> ans = new ArrayList<>();
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(startX, startY, 0));
        while (queue.size() > 0)
        {
            Pair pair = queue.pop();
            if (!(pair.y >= 1 && pair.y < rows && pair.x >= 1 && pair.x < columns))
            {
                //out of range
                continue;
            }
            char c = grid[pair.y][pair.x];
            if (c == 'C' || c == 'W' || c == 'x')
            {
                //stuck
                continue;
            }

            if (c == '.' || c == 'S')
            {
                //this is walkable. check cameras.
                grid[pair.y][pair.x] = 'x';
                if (!hasCam(pair))
                {
                    ans.add(pair);
                    queue.add(new Pair(pair.x + 1, pair.y, pair.layer + 1));
                    queue.add(new Pair(pair.x - 1, pair.y, pair.layer + 1));
                    queue.add(new Pair(pair.x, pair.y - 1, pair.layer + 1));
                    queue.add(new Pair(pair.x, pair.y + 1, pair.layer + 1));
                }
                else
                {
                    pair.layer = -1;
                    ans.add(pair);
                }
            }
            else
            {
                //on conveyor
                if (c == 'U')
                {
                    queue.add(new Pair(pair.x, pair.y + 1, pair.layer));
                }
                else if (c == 'D')
                {
                    queue.add(new Pair(pair.x, pair.y - 1, pair.layer));
                }
                else if (c == 'L')
                {
                    queue.add(new Pair(pair.x - 1, pair.y, pair.layer));
                }
                else if (c == 'R')
                {
                    queue.add(new Pair(pair.x + 1, pair.y, pair.layer));
                }
            }
        }
        ans.sort((o1, o2) ->
        {
            if (o1.y < o2.y)
            {
                return -1;
            }
            else if (o1.y > o2.y)
            {
                return 1;
            }
            else
            {
                return o1.x - o2.x;
            }
        });

        for (Pair an: ans)
        {
            System.out.println(an.layer);
        }
    }

    private static boolean hasCam(Pair pair)
    {
        //check vertically
        for (int i = pair.y - 1; i >= 0; i--)
        {
            if (grid[i][pair.x] == 'W')
            {
                break;
            }
            else if (grid[i][pair.x] == 'C')
            {
                return true;
            }
        }
        for (int i = pair.y + 1; i < grid.length; i++)
        {
            if (grid[i][pair.x] == 'W')
            {
                break;
            }
            else if (grid[i][pair.x] == 'C')
            {
                return true;
            }
        }
        //check horizontally
        for (int i = pair.x - 1; i >= 0; i--)
        {
            if (grid[pair.y][i] == 'W')
            {
                break;
            }
            else if (grid[pair.y][i] == 'C')
            {
                return true;
            }
        }
        for (int i = pair.x + 1; i < grid[0].length; i++)
        {
            if (grid[pair.y][i] == 'W')
            {
                break;
            }
            else if (grid[pair.y][i] == 'C')
            {
                return true;
            }
        }

        return false;
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


    }
}
