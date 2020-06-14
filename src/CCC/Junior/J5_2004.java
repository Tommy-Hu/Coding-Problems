package Junior;

import java.util.*;

public class J5_2004
{
    static int gridSize;
    static int level;
    static int x_coord;

    public static void main(String[] args)
    {
        //Fractals Problem
        Scanner sc = new Scanner(System.in);
        level = sc.nextInt();
        gridSize = sc.nextInt();
        x_coord = sc.nextInt();

        //Get all the directions of the segments on the graph
        List<Seg> graph = getSegs();
        TreeSet<Integer> set = getYs(graph);
        for (Integer y: set)
        {
            System.out.print(y + " ");
        }
    }

    private static TreeSet<Integer> getYs(List<Seg> graph)
    {
        int unit = (int) (gridSize / Math.pow(3, level));
        int curX = 0;
        TreeSet<Integer> ints = new TreeSet<>();
        int curY = 1;
        for (Seg seg: graph)
        {
            int yBefore = curY;

            int xBefore = curX;
            if (seg == Seg.Right)
            {
                curX += unit;
            }
            else if (seg == Seg.Left)
            {
                curX -= unit;
            }
            else if (seg == Seg.Up)
            {
                curY += unit;
            }
            else if (seg == Seg.Down)
            {
                curY -= unit;
            }

            if ((curX <= x_coord && xBefore >= x_coord) || (xBefore <= x_coord && curX >= x_coord))//if in the middle of two lines
            {
                ints.add(yBefore);
                ints.add(curY);
                for (int i = Math.min(yBefore, curY); i < Math.max(yBefore, curY); i++)
                {
                    ints.add(i);
                }
            }
        }
        return ints;
    }

    private static List<Seg> getSegs()
    {
        List<Seg> start = new ArrayList<>();
        start.add(Seg.Right);
        List<Seg> end = new ArrayList<>();
        for (int i = 0; i < level; i++)
        {
            for (Seg seg: start)
            {
                end.addAll(seg.Expand());//The expand method turns one Seg to five
            }

            List<Seg> tmp = start;
            start = end;
            end = tmp;

            end.clear();
        }

        return start;
    }

    //This enum contains the Segment's Vector
    public enum Seg
    {
        Left
                {
                    List<Seg> Expand()
                    {
                        List<Seg> segs = new ArrayList<>();
                        segs.add(Seg.Left);
                        segs.add(Seg.Down);
                        segs.add(Seg.Left);
                        segs.add(Seg.Up);
                        segs.add(Seg.Left);
                        return segs;
                    }
                },
        Right
                {
                    List<Seg> Expand()
                    {
                        List<Seg> segs = new ArrayList<>();
                        segs.add(Seg.Right);
                        segs.add(Seg.Up);
                        segs.add(Seg.Right);
                        segs.add(Seg.Down);
                        segs.add(Seg.Right);
                        return segs;
                    }
                },
        Up
                {
                    List<Seg> Expand()
                    {
                        List<Seg> segs = new ArrayList<>();
                        segs.add(Seg.Up);
                        segs.add(Seg.Left);
                        segs.add(Seg.Up);
                        segs.add(Seg.Right);
                        segs.add(Seg.Up);
                        return segs;
                    }
                },
        Down
                {
                    List<Seg> Expand()
                    {
                        List<Seg> segs = new ArrayList<>();
                        segs.add(Seg.Down);
                        segs.add(Seg.Right);
                        segs.add(Seg.Down);
                        segs.add(Seg.Left);
                        segs.add(Seg.Down);
                        return segs;
                    }
                };

        abstract List<Seg> Expand();
    }
}
