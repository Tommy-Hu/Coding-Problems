package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class J5_2009
{
    static HashSet<Friend> friends = new HashSet<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        friends.add(new Friend(1, 6));
        friends.add(new Friend(2, 6));
        friends.add(new Friend(3, 6));
        friends.add(new Friend(4, 6));
        friends.add(new Friend(5, 6));
        friends.add(new Friend(3, 5));
        friends.add(new Friend(3, 4));
        friends.add(new Friend(4, 5));
        friends.add(new Friend(6, 7));
        friends.add(new Friend(7, 8));
        friends.add(new Friend(8, 9));
        friends.add(new Friend(9, 12));
        friends.add(new Friend(9, 10));
        friends.add(new Friend(10, 11));
        friends.add(new Friend(11, 12));
        friends.add(new Friend(3, 15));
        friends.add(new Friend(12, 13));
        friends.add(new Friend(13, 15));
        friends.add(new Friend(13, 14));
        friends.add(new Friend(16, 18));
        friends.add(new Friend(16, 17));
        friends.add(new Friend(17, 18));

        while (true)
        {
            char operation = br.readLine().charAt(0);
            if (operation == 'q')
            {
                return;
            }
            else if (operation == 'i')
            {
                //add friend
                int a = Integer.parseInt(br.readLine());
                int b = Integer.parseInt(br.readLine());
                friends.add(new Friend(a, b));
            }
            else if (operation == 'd')
            {
                //del friend
                int a = Integer.parseInt(br.readLine());
                int b = Integer.parseInt(br.readLine());
                friends.remove(new Friend(a, b));
            }
            else if (operation == 'n')
            {
                //out num of friends
                int person = Integer.parseInt(br.readLine());
                System.out.println(getFriends(person, null).size());
            }
            else if (operation == 'f')
            {
                //out num of friends of friends
                int person = Integer.parseInt(br.readLine());
                HashSet<Friend> fs = new HashSet<>();
                for (var friend: friends)
                {
                    if (friend.a == person)
                    {
                        //friend.a is person, so friend.b is their friend.
                        fs.addAll(getFriends(friend.b, friend));
                    }
                    else if (friend.b == person)
                    {
                        //friend.b is person, so friend.a is their friend.
                        fs.addAll(getFriends(friend.a, friend));
                    }
                }

                HashSet<Integer> ans = new HashSet<>();

                for (var f: fs)
                {
                    if (f.b != person && !isFriend(f.b, person))
                    {
                        ans.add(f.b);
                    }
                }

                System.out.println(ans.size());
            }
            else if (operation == 's')
            {
                //out degree of separation
                int a = Integer.parseInt(br.readLine());
                int b = Integer.parseInt(br.readLine());

                ArrayDeque<Integer> currents = new ArrayDeque<>();
                currents.add(a);

                int generation = 0;
                HashSet<Integer> beenTo = new HashSet<>();
                beenTo.add(currents.peek());

                WhileLoop:
                while (true)
                {
                    int count = currents.size();
                    for (int i = 0; i < count; i++)
                    {
                        int person = currents.pop();
                        if (person == b)
                        {
                            System.out.println(generation);
                            break WhileLoop;
                        }
                        else
                        {
                            for (var f: friends)
                            {
                                if (f.a == person && !beenTo.contains(f.b))
                                {
                                    currents.add(f.b);
                                    beenTo.add(f.b);
                                }
                                else if (f.b == person && !beenTo.contains(f.a))
                                {
                                    currents.add(f.a);
                                    beenTo.add(f.a);
                                }
                            }
                        }
                    }
                    if (count <= 0)
                    {
                        System.out.println("Not connected");
                        break;
                    }
                    generation++;
                }
            }
        }
    }

    public static boolean isFriend(int a, int b)
    {
        var test = new Friend(a, b);
        for (var friend: friends)
        {
            if (friend.equals(test))
            {
                return true;
            }
        }
        return false;
    }

    public static HashSet<Friend> getFriends(int person, Friend exclusive)
    {
        HashSet<Friend> fs = new HashSet<>();
        for (var friend: friends)
        {
            if (!friend.equals(exclusive))
            {
                if (friend.a == person)
                {
                    fs.add(friend);
                }
                else if (friend.b == person)
                {
                    fs.add(new Friend(friend.b, friend.a));
                }
            }
        }
        return fs;
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
            return (a == friend.a &&
                    b == friend.b) || (b == friend.a &&
                    a == friend.b);
        }

        @Override
        public int hashCode()
        {
            return a ^ b;
        }
    }
}
