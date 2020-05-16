package Tommy.CCC.Senior;

import java.util.*;

public class S3_2002
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        char[][] grid = new char[rows][columns];

        //read input
        sc.nextLine();
        for (int i = 0; i < rows; i++)
        {
            grid[i] = sc.nextLine().toCharArray();
        }

        int actionCount = sc.nextInt();
        char[] actions = new char[actionCount];
        for (int i = 0; i < actionCount; i++)
        {
            actions[i] = sc.next().toCharArray()[0];
        }

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                if (grid[i][j] == '.' || grid[i][j] == '*')
                {
                    for (int k = 0; k < 4; k++)
                    {
                        var dir = Direction.W;
                        if (k == 1)
                        {
                            dir = Direction.D;
                        }
                        else if (k == 2)
                        {
                            dir = Direction.S;
                        }
                        else if (k == 3)
                        {
                            dir = Direction.A;
                        }

                        int x = j;
                        int y = i;
                        boolean isFinished = true;
                        for (var ac: actions)
                        {
                            if (ac == 'F')
                            {
                                if (dir == Direction.W)
                                {
                                    y--;
                                    if (y < 0)
                                    {
                                        isFinished = false;
                                        break;
                                    }
                                }
                                else if (dir == Direction.D)
                                {
                                    x++;
                                    if (x >= columns)
                                    {
                                        isFinished = false;
                                        break;
                                    }
                                }
                                else if (dir == Direction.S)
                                {
                                    y++;
                                    if (y >= rows)
                                    {
                                        isFinished = false;
                                        break;
                                    }
                                }
                                else
                                {
                                    x--;
                                    if (x < 0)
                                    {
                                        isFinished = false;
                                        break;
                                    }
                                }

                                if (grid[y][x] == 'X')
                                {
                                    isFinished = false;
                                    break;
                                }
                            }
                            else if (ac == 'R')
                            {
                                if (dir == Direction.W)
                                {
                                    dir = Direction.D;
                                }
                                else if (dir == Direction.D)
                                {
                                    dir = Direction.S;
                                }
                                else if (dir == Direction.S)
                                {
                                    dir = Direction.A;
                                }
                                else
                                {
                                    dir = Direction.W;
                                }
                            }
                            else
                            {
                                if (dir == Direction.W)
                                {
                                    dir = Direction.A;
                                }
                                else if (dir == Direction.D)
                                {
                                    dir = Direction.W;
                                }
                                else if (dir == Direction.S)
                                {
                                    dir = Direction.D;
                                }
                                else
                                {
                                    dir = Direction.S;
                                }
                            }
                        }

                        if (isFinished)
                        {
                            grid[y][x] = '*';
                            break;
                        }

                    }

                }
            }
        }

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    enum Direction
    {
        W,
        A,
        S,
        D
    }
}