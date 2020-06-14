import java.io.*;
import java.util.*;

public class CF_D_1365
{
    static char[][] grid;

    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        TestLoop:
        for (int __ = 0; __ < t; __++)
        {
            int n = readInt();
            int m = readInt();
            grid = new char[n][m];
            Set<Pair> goodGuys = new HashSet<>();
            Set<Pair> badGuys = new HashSet<>();
            for (int y = 0; y < n; y++)
            {
                char[] chars = br.readLine().toCharArray();
                for (int x = 0; x < m; x++)
                {
                    char c = chars[x];
                    grid[y][x] = c;
                    if (c == 'G')
                    {
                        goodGuys.add(new Pair(x, y));
                    }
                    else if (c == 'B')
                    {
                        badGuys.add(new Pair(x, y));
                    }
                }
            }
            if (goodGuys.size() <= 0)
            {
                pw.println("Yes");
                continue;
            }
            for (Pair bad: badGuys)
            {
                if (!replaceNeighbors(bad.x, bad.y))
                {
                    pw.println("No");
                    continue TestLoop;
                }
            }
            boolean[][] convertedGrid = convertGrid();
            for (Pair p: goodGuys)
            {
                if (!convertedGrid[p.y][p.x])
                {
                    pw.println("No");
                    continue TestLoop;
                }
            }
            pw.println("Yes");
        }
        pw.close();
    }

    public static boolean[][] convertGrid()
    {
        boolean[][] walkable = new boolean[grid.length][grid[0].length];
        boolean[][] beenTo = new boolean[grid.length][grid[0].length];
        beenTo[grid.length - 1][grid[0].length - 1] = true;
        ArrayDeque<Pair> todo = new ArrayDeque<>();
        todo.add(new Pair(grid[0].length - 1, grid.length - 1));
        while (todo.size() > 0)
        {
            Pair pair = todo.pop();
            walkable[pair.y][pair.x] = true;
            Pair left = new Pair(pair.x - 1, pair.y);
            Pair right = new Pair(pair.x + 1, pair.y);
            Pair top = new Pair(pair.x, pair.y + 1);
            Pair bottom = new Pair(pair.x, pair.y - 1);
            if (left.x >= 0 && grid[left.y][left.x] != '#' && !beenTo[left.y][left.x])
            {
                todo.add(left);
                beenTo[left.y][left.x] = true;
            }
            if (right.x < grid[0].length && grid[right.y][right.x] != '#' && !beenTo[right.y][right.x])
            {
                todo.add(right);
                beenTo[right.y][right.x] = true;
            }
            if (bottom.y >= 0 && grid[bottom.y][bottom.x] != '#' && !beenTo[bottom.y][bottom.x])
            {
                todo.add(bottom);
                beenTo[bottom.y][bottom.x] = true;
            }
            if (top.y < grid.length && grid[top.y][top.x] != '#' && !beenTo[top.y][top.x])
            {
                todo.add(top);
                beenTo[top.y][top.x] = true;
            }
        }
        return walkable;
    }

    public static boolean replaceNeighbors(int x, int y)
    {
        if (x - 1 >= 0)
        {
            char c = grid[y][x - 1];
            if (c == 'G')
            {
                return false;
            }
            else if (c == '.')
            {
                grid[y][x - 1] = '#';
            }
        }
        if (x + 1 < grid[0].length)
        {
            char c = grid[y][x + 1];
            if (c == 'G' || (x + 1 == grid[0].length - 1 && y == grid.length - 1))
            {
                return false;
            }
            else if (c == '.')
            {
                grid[y][x + 1] = '#';
            }
        }
        if (y - 1 >= 0)
        {
            char c = grid[y - 1][x];
            if (c == 'G')
            {
                return false;
            }
            else if (c == '.')
            {
                grid[y - 1][x] = '#';
            }
        }
        if (y + 1 < grid.length)
        {
            char c = grid[y + 1][x];
            if (c == 'G' || (x == grid[0].length - 1 && y + 1 == grid.length - 1))
            {
                return false;
            }
            else if (c == '.')
            {
                grid[y + 1][x] = '#';
            }
        }
        return true;
    }

    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int readInt() throws IOException
    {
        while (st == null || !st.hasMoreTokens())
        {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    private static class Pair
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
            if (this == o) { return true; }
            if (o == null || getClass() != o.getClass()) { return false; }
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(x, y);
        }
    }
}
