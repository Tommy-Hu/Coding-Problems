package Senior;

import java.util.*;

public class S3_2003
{
    static boolean[][] grid;
    static int r;
    static int c;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int bought = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        //True means walkable!
        grid = new boolean[r][c];

        sc.nextLine();

        for (int i = 0; i < r; i++)
        {
            String line = sc.nextLine();
            for (int j = 0; j < c; j++)
            {
                grid[i][j] = line.charAt(j) == '.';
            }
        }

        List<Integer> roomsTiles = getRoomsTilesCount();
        //sorting the list means making sure the count ends with largest.
        Collections.sort(roomsTiles);
        //start from the back of the list, since it's the largest value!
        for (int i = roomsTiles.size() - 1; i >= 0; i--)
        {
            bought -= roomsTiles.get(i);
            if (bought < 0)
            {
                //that's it
                int ct = (roomsTiles.size() - i - 1);
                System.out.println(ct + " room" + (ct == 1 ? "" : "s") + ", " + (bought + roomsTiles.get(i)) + " square metre(s) left over");//OF COURSE, I FORGOT TO MINUS 1 AGAIN!
                return;
                //this is not the only case!
            }
            else if (bought == 0)
            {
                //that's it again
                int ct = (roomsTiles.size() - i);
                System.out.println(ct + " room" + (ct == 1 ? "" : "s") + ", " + bought + " square metre(s) left over");//OF COURSE, I FORGOT TO MINUS 1 AGAIN!
                return;
                //this is not the only case again!
            }
        }
        //if the program continued all the way here, this means that all the rooms are covered!

        int ct = roomsTiles.size();
        System.out.println(ct + " room" + (ct == 1 ? "" : "s") + ", " + bought + " square metre(s) left over");
    }

    public static List<Integer> getRoomsTilesCount()
    {
        //the size of the list would be the room count, and each element would be the tiles count of that specific room!
        List<Integer> roomTilesCountList = new ArrayList<>();
        //1. find the first '.' in the grid.
        //the goal is to find the number of rooms and the number of tiles in those rooms
        //this will continue to find any open spots, until there isn't any left. This is not the fastest though.
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                if (grid[i][j])
                {
                    //found the first empty space.
                    //this will be the starting point.
                    //after that, get all the neighbors that are walkable.
                    ArrayDeque<Pair> currents = new ArrayDeque<>();
                    currents.add(new Pair(j, i));
                    grid[i][j] = false;
                    int roomTilesCount = 0;//there is at least ONE
                    while (true)
                    {
                        //check the tile above this
                        int count = currents.size();

                        for (int k = 0; k < count; k++)
                        {
                            roomTilesCount++;
                            Pair pair = currents.pop();
                            if (isWalkable(pair.x, pair.y - 1))//minus one because I started from the top left corner
                            {
                                currents.add(new Pair(pair.x, pair.y - 1));//needs to be cleaned up!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                                grid[pair.y - 1][pair.x] = false;//set the point to 'went'
                            }
                            if (isWalkable(pair.x, pair.y + 1))
                            {
                                currents.add(new Pair(pair.x, pair.y + 1));
                                grid[pair.y + 1][pair.x] = false;//set the point to 'went'
                            }
                            if (isWalkable(pair.x - 1, pair.y))
                            {
                                currents.add(new Pair(pair.x - 1, pair.y));
                                grid[pair.y][pair.x - 1] = false;//set the point to 'went'
                            }
                            if (isWalkable(pair.x + 1, pair.y))
                            {
                                currents.add(new Pair(pair.x + 1, pair.y));
                                grid[pair.y][pair.x + 1] = false;//set the point to 'went'
                            }
                        }

                        if (currents.size() <= 0)
                        {
                            break;
                            //one room finished
                        }
                    }

                    roomTilesCountList.add(roomTilesCount);
                }
            }
        }

        return roomTilesCountList;
    }

    public static boolean isWalkable(int x, int y)
    {
        return y >= 0 && y < r && x >= 0 && x < c && grid[y][x];
    }

    static class Pair
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
