import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_E_1350
{
    static byte[][] board;
    static int[][] distanceBoard;
    static HashSet<Node> alive = new HashSet<>();
    static long n;
    static long m;
    static long t;

    public static void main(String[] args) throws IOException
    {
        n = readLong();
        m = readLong();
        t = readLong();
        board = new byte[(int) n][(int) m];
        distanceBoard = new int[(int) n][(int) m];
        for (int i = 0; i < n; i++)
        {
            char[] chs = br.readLine().toCharArray();
            for (int j = 0; j < m; j++)
            {
                byte color = Byte.parseByte(Character.toString(chs[j]));
                board[i][j] = color;
                int dis = Integer.MAX_VALUE;
                if (i - 1 >= 0 && board[i - 1][j] == color)
                {
                    dis = 0;
                    distanceBoard[i - 1][j] = 0;
                    alive.add(new Node(j, i));
                    alive.add(new Node(j, i - 1));
                }
                if (j - 1 >= 0 && board[i][j - 1] == color)
                {
                    dis = 0;
                    distanceBoard[i][j - 1] = 0;
                    alive.add(new Node(j, i));
                    alive.add(new Node(j - 1, i));
                }
                distanceBoard[i][j] = dis;
            }
        }
        calculateDistances();
        for (int __ = 0; __ < t; __++)
        {
            int i = (int) readLong() - 1;
            int j = (int) readLong() - 1;
            long p = readLong();
            int distance = distanceBoard[i][j];
            int color = board[i][j];
            if (distance == Integer.MAX_VALUE || distance >= p || (p - distance) % 2 == 0)
            {
                System.out.println(color);
            }
            else
            {
                System.out.println(color == 0 ? 1 : 0);
            }
        }
    }

    static void calculateDistances()
    {
        for (Node n: alive)
        {
            ArrayDeque<Node> todo = new ArrayDeque<>();
            HashSet<Node> beenTo = new HashSet<>();
            todo.push(n);
            while (todo.size() > 0)
            {
                Node node = todo.pollLast();
                int newDis = distanceBoard[node.y][node.x] + 1;
                Node left = new Node(node.x - 1, node.y);
                Node right = new Node(node.x + 1, node.y);
                Node top = new Node(node.x, node.y - 1);
                Node bottom = new Node(node.x, node.y + 1);
                pushNode(todo, beenTo, newDis, left, right);
                pushNode(todo, beenTo, newDis, top, bottom);
                beenTo.add(node);
            }
        }
    }

    private static void pushNode(ArrayDeque<Node> todo, HashSet<Node> beenTo, int newDis, Node a, Node b)
    {
        if (Node.isValid(a) && !beenTo.contains(a) && distanceBoard[a.y][a.x] > newDis)
        {
            distanceBoard[a.y][a.x] = newDis;
            todo.push(a);
        }
        if (Node.isValid(b) && !beenTo.contains(b) && distanceBoard[b.y][b.x] > newDis)
        {
            distanceBoard[b.y][b.x] = newDis;
            todo.push(b);
        }
    }

    static class Node
    {
        public int x;
        public int y;

        public Node(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public static boolean isValid(Node node)
        {
            return node.x >= 0 && node.x < m && node.y >= 0 && node.y < n;
        }

        @Override
        public boolean equals(Object o)
        {
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(x, y);
        }

        @Override
        public String toString()
        {
            return String.format("(%1$s, %2$s)", x, y);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static long readLong() throws IOException
    {
        while (st == null || !st.hasMoreTokens())
        {
            st = new StringTokenizer(br.readLine());
        }
        return Long.parseLong(st.nextToken());
    }
}
