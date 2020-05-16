package Tommy.CCC.Junior;

import java.util.*;

public class J5_2007
{
    static int A;
    static int B;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        int N = sc.nextInt();
        List<Integer> pts = new ArrayList<>();
        pts.add(0);
        pts.add(990);
        pts.add(1010);
        pts.add(1970);
        pts.add(2030);
        pts.add(2940);
        pts.add(3060);
        pts.add(3930);
        pts.add(4060);
        pts.add(4970);
        pts.add(5030);
        pts.add(5990);
        pts.add(6010);
        pts.add(7000);

        for (int i = 0; i < N; i++)
        {
            pts.add(sc.nextInt());
        }

        Collections.sort(pts);
        System.out.println(getCount(pts));
    }

    static long getCount(List<Integer> points)
    {
        long[] ways = new long[points.size()];
        ways[0] = 1;
        for (int i = 0; i < points.size(); i++)
        {
            int cur = points.get(i);
            long ct = ways[i];
            for (int j = i; j < points.size(); j++)
            {
                if (isLegal(cur, points.get(j)))
                {
                    ways[j] += ct;
                }
            }
        }

        return ways[ways.length - 1];
    }

    static boolean isLegal(int start, int end)
    {
        return end - start >= A && end - start <= B;
    }
}
