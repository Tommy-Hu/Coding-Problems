package Tommy.CCC.Senior;

import java.util.Scanner;

public class S2_2007
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int boxCount = sc.nextInt();
        int[][] boxes = new int[boxCount][3];
        for (int i = 0; i < boxCount; i++)
        {
            boxes[i][0] = sc.nextInt();
            boxes[i][1] = sc.nextInt();
            boxes[i][2] = sc.nextInt();
        }
        int itemsCount = sc.nextInt();
        int[][] items = new int[itemsCount][3];
        for (int i = 0; i < itemsCount; i++)
        {
            items[i][0] = sc.nextInt();
            items[i][1] = sc.nextInt();
            items[i][2] = sc.nextInt();
        }

        for (int i = 0; i < items.length; i++)
        {
            checkFit(boxes, items[i]);
        }
    }

    private static void checkFit(int[][] boxes, int[] item)
    {
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < boxes.length; i++)
        {
            int[] box = boxes[i];
            if (getFit(box, item))
            {
                int v = box[0] * box[1] * box[2];
                if (v < smallest)
                {
                    smallest = v;
                }
            }
        }
        if (smallest < Integer.MAX_VALUE)
        {
            System.out.println(smallest);
        }
        else
        {
            System.out.println("Item does not fit.");
        }
    }

    private static boolean getFit(int[] box, int[] item)
    {
        for (int x = 0; x < 3; x++)
        {
            for (int y = 0; y < 3; y++)
            {
                if (y != x)
                {
                    for (int z = 0; z < 3; z++)
                    {
                        if (z != y && z != x)
                        {
                            //Found a variant!!
                            if (checkVariant(box[x], box[y], box[z], item))
                            {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkVariant(int x, int y, int z, int[] item)
    {
        for (int a = 0; a < 3; a++)
        {
            for (int b = 0; b < 3; b++)
            {
                if (b != a)
                {
                    for (int c = 0; c < 3; c++)
                    {
                        if (c != b && c != a)
                        {
                            //Found a variant!!
                            if (item[a] <= x && item[b] <= y && item[c] <= z)
                            {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
