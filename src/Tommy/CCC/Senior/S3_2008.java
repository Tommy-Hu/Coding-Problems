package Tommy.CCC.Senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S3_2008
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int __ = 0; __ < t; __++)
        {
            //each test case
            int r = Integer.parseInt(br.readLine());
            int c = Integer.parseInt(br.readLine());
            char[][] testCases = new char[r][c];
            //testCases[0] would be all characters of the first ROW, so row first ALWAYS!
            for (int y = 0; y < r; y++)
            {
                String line = br.readLine();
                for (int x = 0; x < c; x++)
                {
                    testCases[y][x] = line.charAt(x);
                }
            }

            System.out.println(getShortestPath(testCases));
        }
    }

    private static int getShortestPath(char[][] cases)
    {
        ArrayDeque<Pair<Integer, Integer>> operands = new ArrayDeque<>();
        HashSet<Pair<Integer, Integer>> beenTo = new HashSet<>();
        operands.add(new Pair<>(0, 0));
        int generation = 0;
        while (true)
        {
            generation++;
            int count = operands.size();
            for (int i = 0; i < count; i++)
            {
                var pos = operands.pop();
                int x = pos.getLeft();
                int y = pos.getRight();
                if (y == cases.length - 1 && x == cases[0].length - 1)
                {
                    return generation;
                }
                if (cases[y][x] == '+')
                {
                    //all four dirs
                    if (isValid(x + 1, y, cases, beenTo))
                    {
                        operands.add(new Pair<>(x + 1, y));
                        beenTo.add(new Pair<>(x + 1, y));
                    }
                    if (isValid(x - 1, y, cases, beenTo))
                    {
                        operands.add(new Pair<>(x - 1, y));
                        beenTo.add(new Pair<>(x - 1, y));
                    }
                    if (isValid(x, y + 1, cases, beenTo))
                    {
                        operands.add(new Pair<>(x, y + 1));
                        beenTo.add(new Pair<>(x, y + 1));
                    }
                    if (isValid(x, y - 1, cases, beenTo))
                    {
                        operands.add(new Pair<>(x, y - 1));
                        beenTo.add(new Pair<>(x, y - 1));
                    }
                }
                else if (cases[y][x] == '-')
                {
                    if (isValid(x + 1, y, cases, beenTo))
                    {
                        operands.add(new Pair<>(x + 1, y));
                        beenTo.add(new Pair<>(x + 1, y));
                    }
                    if (isValid(x - 1, y, cases, beenTo))
                    {
                        operands.add(new Pair<>(x - 1, y));
                        beenTo.add(new Pair<>(x - 1, y));
                    }
                }
                else if (cases[y][x] == '|')
                {
                    if (isValid(x, y + 1, cases, beenTo))
                    {
                        operands.add(new Pair<>(x, y + 1));
                        beenTo.add(new Pair<>(x, y + 1));
                    }
                    if (isValid(x, y - 1, cases, beenTo))
                    {
                        operands.add(new Pair<>(x, y - 1));
                        beenTo.add(new Pair<>(x, y - 1));
                    }
                }

                if (operands.size() == 0)
                {
                    return -1;
                }
            }
        }
    }

    private static boolean isValid(int x, int y, char[][] cases, HashSet<Pair<Integer, Integer>> beenTo)
    {
        return y >= 0 && y < cases.length && x >= 0 && x < cases[0].length && !beenTo.contains(new Pair<>(x, y)) && cases[y][x] != '*';
    }
}

class Pair<L, R>
{

    private final L left;
    private final R right;

    public Pair(L left, R right)
    {
        this.left = left;
        this.right = right;
    }

    public L getLeft() { return left; }

    public R getRight() { return right; }

    @Override
    public int hashCode() { return left.hashCode() ^ right.hashCode(); }

    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Pair)) { return false; }
        Pair pairo = (Pair) o;
        return this.left.equals(pairo.getLeft()) &&
                this.right.equals(pairo.getRight());
    }

}
