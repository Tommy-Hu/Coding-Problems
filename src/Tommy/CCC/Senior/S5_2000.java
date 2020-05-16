package Tommy.CCC.Senior;

import java.util.*;

public class S5_2000
{
    static List<Sheep> sheep;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sheep = new ArrayList<>();
        for (int i = 0; i < count; i++)
        {
            sheep.add(new Sheep(sc.nextFloat(), sc.nextFloat()));
        }

        final String MAY_EATEN_FORMAT = "The sheep at (%.2f, %.2f) might be eaten." + System.lineSeparator();
        for (int i = 0; i < count; i++)
        {
            Sheep s = sheep.get(i);
            if (check(s))
            {
                System.out.printf(MAY_EATEN_FORMAT, s.X, s.Y);
            }
        }
    }

    public static boolean check(Sheep curSheep)
    {
        Set<Range> ranges = new HashSet<>();
        float left = Float.NEGATIVE_INFINITY;
        float right = Float.POSITIVE_INFINITY;
        for (var sh: sheep)
        {
            if (sh.X != curSheep.X || sh.Y != curSheep.Y)
            {
                float slope = (curSheep.Y - sh.Y) / (curSheep.X - sh.X);
                slope = -1 / slope;
                float midX = (curSheep.X + sh.X) / 2;
                float midY = (curSheep.Y + sh.Y) / 2;
                //y = mx    ---> y = mx + b
                float b = midY - slope * midX;
                float xOnSouthBoundary = -b / slope;//0 = slope * x + b, -b / slope = x
                if (curSheep.X < sh.X)
                {
                    //left
                    //xOnSouthBoundary is the right most point, and zero is the left most point of the range
                    if (right > xOnSouthBoundary) { right = xOnSouthBoundary; }
                }
                else if (curSheep.X > sh.X)
                {
                    //right
                    if (left < xOnSouthBoundary) { left = xOnSouthBoundary; }
                }
                else if (curSheep.Y >= sh.Y)
                {
                    return false;
                }
            }
        }

        return left <= right && left <= 1000 && right >= 0;
    }

}

class Range
{
    public float X1;
    public float X2;

    public Range(float x1, float x2)
    {
        X1 = x1;
        X2 = x2;
    }

    public boolean Overlaps(Collection<Range> ranges)
    {
        for (var range: ranges)
        {
            if (Math.max(X1, range.X1) > Math.min(X2, range.X2))
            {
                return false;
            }
        }
        return true;
    }
}

class Sheep
{
    public float X;
    public float Y;

    public Sheep(float x, float y)
    {
        X = x;
        Y = y;
    }
}
