package Tommy.HelperClasses;

public class Vector2
{
    public int x;
    public int y;

    public Vector2()
    {
        x = 0;
        y = 0;
    }

    public Vector2(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * @param str              The inputting String
     * @param separationString The String which separates the str to two integers
     * @return Returns a Vector2 that is converted from the String
     */
    public Vector2(String str, String separationString)
    {
        x = Integer.parseInt(str.split(separationString)[0]);
        y = Integer.parseInt(str.split(separationString)[1]);
    }

    public Vector2 duplicate()
    {
        return new Vector2(x, y);
    }

    public static double Distance(Vector2 vec1, Vector2 vec2)
    {
        double ans;

        int a = Math.abs(vec1.x - vec2.x);
        int b = Math.abs(vec1.y - vec2.y);
        ans = Math.sqrt(a * a + b * b);

        return ans;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj.getClass().equals(Vector2.class))
        {
            Vector2 vec = (Vector2) obj;
            if (vec.x == x && vec.y == y)
            {
                return true;
            }
            return false;
        }
        else
        {
            return false;
        }
    }

    @Override
    public String toString()
    {
        return x + ", " + y;
    }

    /**
     * @param v1
     * @param v2
     * @return Returns if opObj is between v1 and v2
     */
    public static boolean Overlaps(Vector2 opObj, Vector2 v1, Vector2 v2)
    {
        if (v1.x == v2.x && v1.x == opObj.x)
        {
            if (v1.y >= opObj.y && v2.y <= opObj.y)
            {
                return true;
            }
            else if (v1.y <= opObj.y && v2.y >= opObj.y)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if (v1.y == v2.y && v1.y == opObj.y)
        {
            if (v1.x >= opObj.x && v2.x <= opObj.x)
            {
                return true;
            }
            else if (v1.x <= opObj.x && v2.x >= opObj.x)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if (v1.x == opObj.x && v1.y == opObj.y)
        {
            return true;
        }
        else if (v2.x == opObj.x && v2.y == opObj.y)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static Vector2 Add(Vector2 a, Vector2 b)
    {
        return new Vector2(a.x + b.x, a.y + b.y);
    }

    public static Vector2 Minus(Vector2 a, Vector2 b)
    {
        return new Vector2(a.x - b.x, a.y - b.y);
    }
}
