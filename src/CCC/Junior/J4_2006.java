package Junior;

import java.util.*;

public class J4_2006
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        List<Integer>[] instructions = new ArrayList[8];
        //region initialization
        for (int i = 1; i < 8; i++)
        {
            instructions[i] = new ArrayList<>();
        }
        instructions[1].add(7);
        instructions[1].add(4);
        instructions[2].add(1);
        instructions[3].add(4);
        instructions[3].add(5);
        //endregion

        while (true)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x == 0 && y == 0)
            {
                break;
            }

            instructions[x].add(y);
        }

        for (int i = 1; i < 8; i++)
        {
            for (int j = 1; j < 8; j++)
            {
                if (j != i)
                {
                    for (int k = 1; k < 8; k++)
                    {
                        if (k != j && k != i)
                        {
                            for (int l = 1; l < 8; l++)
                            {
                                if (l != k && l != j && l != i)
                                {
                                    for (int m = 1; m < 8; m++)
                                    {
                                        if (m != l && m != k && m != j && m != i)
                                        {
                                            for (int n = 1; n < 8; n++)
                                            {
                                                if (n != m && n != l && n != k && n != j && n != i)
                                                {
                                                    for (int o = 1; o < 8; o++)
                                                    {
                                                        if (o != n && o != m && o != l && o != k && o != j && o != i)
                                                        {
                                                            if (isGood(new int[]{0, i, j, k, l, m, n, o}, instructions))
                                                            {
                                                                System.out.println(i + " " + j + " " + k + " " + l + " " + m + " " + n + " " + o);
                                                                return;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Cannot complete these tasks. Going to bed.");
    }

    private static boolean isGood(int[] ints, List<Integer>[] instructions)
    {
        String str = Arrays.toString(ints);

        for (int i = 1; i < 8; i++)
        {
            var l = instructions[i];
            for (int n: l)
            {
                if (str.indexOf(String.valueOf(n)) < str.indexOf(String.valueOf(i)))
                {
                    return false;
                }
            }
        }

        return true;
    }
}

/*
    1,7
    1,4
    2,1
    3,4
    3,5
*/