import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Algorithms
{
    public static void main(String[] args) throws IOException
    {
        System.out.println(BinarySearch(new long[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 15, 15, 15, 16, 17
        }, 5));
    }

    public static int BinarySearch(long[] arr, long key)
    {
        if (arr == null || arr.length <= 0) { return 0; }

        int start = 0;
        int end = arr.length - 1;
        while (true)
        {
            int mid = (start + end) / 2;
            long element = arr[mid];
            if (element == key)
            {
                return mid;
            }
            if (start == end)
            {
                return -start;
            }

            if (key > element)
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
    }
}
