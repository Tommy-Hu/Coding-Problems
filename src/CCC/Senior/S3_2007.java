package Senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S3_2007
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Friend> friends = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            String s = br.readLine();

            friends.add(new Friend(Integer.parseInt(s.split(" ")[0]), Integer.parseInt(s.split(" ")[1])));
        }

        while (true)
        {
            String s = br.readLine();
            int x = Integer.parseInt(s.split(" ")[0]);
            int y = Integer.parseInt(s.split(" ")[1]);
            if (x == 0 && y == 0)
            {
                break;
            }

            int ans = getSeperation(x, y, friends);
            System.out.println(ans == -1 ? "No" : "Yes " + ans);

        }
    }

    static int getSeperation(int a, int b, List<Friend> friends)
    {
        int smallestGen = Integer.MAX_VALUE;
        for (int i = 0; i < friends.size(); i++)
        {
            var fr = friends.get(i);
            if (fr.a == a)
            {
                //found the start. now find end using ArrayDeque
                ArrayDeque<Friend> fs = new ArrayDeque<>();
                fs.add(fr);
                HashSet<Friend> beenTo = new HashSet<>();
                int generation = 0;
                beenTo.add(fr);
                while (true)
                {
                    int count = fs.size();
                    if (count <= 0)
                    {
                        break;
                    }
                    for (int j = 0; j < count; j++)
                    {
                        Friend friend = fs.pop();
                        if (friend.b == b)
                        {
                            smallestGen = Math.min(generation, smallestGen);
                            break;
                        }

                        for (Friend next: friends)
                        {
                            if (next.a == friend.b && !beenTo.contains(next))
                            {
                                fs.push(next);
                                beenTo.add(next);
                            }
                        }
                    }

                    generation++;
                }
            }
        }

        return smallestGen == Integer.MAX_VALUE ? -1 : smallestGen;
    }

    static class Friend
    {
        public int a;
        public int b;

        public Friend(int a, int b)
        {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) { return true; }
            if (o == null || getClass() != o.getClass()) { return false; }
            Friend friend = (Friend) o;
            return a == friend.a &&
                    b == friend.b;
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(a, b);
        }
    }
}
