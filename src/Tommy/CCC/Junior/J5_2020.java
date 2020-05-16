package Tommy.CCC.Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    static int M;
    static int N;

    public static void main(String[] args) throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        M = Integer.parseInt(reader.readLine());
        N = Integer.parseInt(reader.readLine());

        int[][] grid = new int[M][N];
        for (int i = 0; i < M; i++)
        {
            String[] ls = reader.readLine().split(" ");
            for (int j = 0; j < N; j++)
            {
                grid[i][j] = Integer.parseInt(ls[j]);//1 11 12 12
            }
        }

        ArrayDeque<pair> queue = new ArrayDeque<>();
        queue.add(new pair(0, 0));
        HashSet<Integer> beenTo = new HashSet<>();//taking so long
        while (queue.size() > 0)
        {
            pair pair = queue.pop();
            int x = pair.x;
            int y = pair.y;
            if (pair.x == N - 1 && pair.y == M - 1)
            {
                System.out.println("yes");
                return;
            }
            int cur = grid[y][x];
            //get all multiples, and add them to the stack
            if (!beenTo.contains(cur))
            {
                double max = Math.ceil(Math.sqrt(cur));
                for (int i = 1; i <= max; i++)
                {
                    if (cur % i == 0)
                    {
                        int d = cur / i;
                        pair a = new pair(i - 1, d - 1);
                        pair b = new pair(d - 1, i - 1);
                        if (valid(a))
                        { queue.add(a); }
                        if (valid(b))
                        { queue.add(b); }
                    }
                }
            }
            else
            {
                continue;
            }
            beenTo.add(cur);
        }

        System.out.println("no");
    }

    private static boolean valid(pair pair)
    {
        return pair.x >= 0 && pair.y >= 0 && pair.x < N && pair.y < M;
    }

    static class pair
    {
        public int x;
        public int y;

        public pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}
