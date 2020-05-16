package Tommy.CCC.Senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S3_2001
{
    static HashSet<Line> roads = new HashSet<>();
    static HashSet<Character> points = new HashSet<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            String str = reader.readLine();
            if (str.equals("**"))
            {
                break;
            }
            char c1 = str.charAt(0);
            char c2 = str.charAt(1);
            points.add(c1);
            points.add(c2);
            Line road = new Line(c1, c2);
            roads.add(road);
        }

        var routes = getAllRoutes();
        List<Line> allEdges = new ArrayList<>(roads);
        for (Line edge: roads)
        {
            for (List<Line> es: routes)
            {
                if (!es.contains(edge))
                {
                    allEdges.remove(edge);
                }
            }
        }

        for (var answer: allEdges)
        {
            System.out.println(answer.point1 + "" + answer.point2);
        }
        System.out.println(String.format("There are %d disconnecting roads.", allEdges.size()));
    }

    private static ArrayDeque<List<Line>> getAllRoutes()
    {
        ArrayDeque<List<Line>> finished = new ArrayDeque<>();
        ArrayDeque<List<Line>> allRoutes = new ArrayDeque<>();
        List<Line> n = new ArrayList<>(Line.getAllNeighbors('A'));//????????????????
        for (var l: n)
        {
            List<Line> arr = new ArrayList<>();
            arr.add(l);
            allRoutes.add(arr);
        }
        while (true)
        {
            boolean isDone = true;
            int count = allRoutes.size();
            for (int i = 0; i < count; i++)
            {
                List<Line> route = allRoutes.pop();
                if (route.get(route.size() - 1).point2 == 'B')
                {
                    //This route is finished
                    finished.add(route);
                    continue;
                }
                List<Line> neighbors = Line.getAllNeighbors(route.get(route.size() - 1).point2);//????????????????
                if (neighbors.size() <= 1)
                {
                    //This path met its end, and the end is not on B, so it is deleted from the route.
                    continue;
                }
                isDone = false;
                for (var line: neighbors)
                {
                    if (!route.contains(line) && line.point2 != 'A' && line.point1 != 'A')
                    {
                        List<Line> r = new ArrayList<>(route);
                        r.add(line);
                        allRoutes.add(r);
                    }
                }
            }

            if (isDone)
            {
                break;
            }
        }
        return finished;
    }

    static class Line
    {
        public char point1;
        public char point2;

        public Line(char point1, char point2)
        {
            this.point1 = point1;
            this.point2 = point2;
        }

        public static List<Line> getAllNeighbors(char point1)
        {
            List<Line> pts = new ArrayList<>();
            for (var p: points)
            {
                if (p != point1 && isConnected(point1, p))
                {
                    pts.add(new Line(point1, p));
                }
            }
            return pts;
        }

        public static boolean isConnected(char p1, char p2)
        {
            if (p1 == p2)
            {
                return false;
            }
            for (var rd: roads)
            {
                if ((rd.point1 == p1 || rd.point2 == p1) && (rd.point1 == p2 || rd.point2 == p2))
                {
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) { return true; }
            if (o == null || getClass() != o.getClass()) { return false; }
            Line road = (Line) o;
            return (point1 == road.point1 &&
                    point2 == road.point2) ||
                    (point1 == road.point2 &&
                            point2 == road.point1);
        }
    }

}

