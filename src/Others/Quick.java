import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Quick
{
    public static void main(String[] args) throws IOException
    {
        solve("123        456           789                                              0            ");
    }

    public static int maxSubArray(final List<Integer> A)
    {
        int max_to_here = 0;
        int max_so_far = 0;
        boolean foundPositive = false;
        int largestNegative = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++)
        {
            if (A.get(i) > 0)
            {
                foundPositive = true;
            }
            else
            {
                largestNegative = Integer.max(largestNegative, A.get(i));
            }
            max_to_here += A.get(i);
            if (max_to_here < 0)
            {
                max_to_here = 0;
            }
            else if (max_to_here > max_so_far)
            {
                max_so_far = max_to_here;
            }
        }

        return foundPositive ? max_so_far : largestNegative;
    }

    public static void rotate(ArrayList<ArrayList<Integer>> a)
    {
        int[][] rotated = new int[a.size()][a.size()];
        for (int i = 0; i < a.size(); i++)//loop rows
        {
            ArrayList<Integer> row = a.get(i);//we will move this entire row and make it be an entire column in the answer
            for (int j = 0; j < a.size(); j++)//loop columns horizontally. j represents the jth column
            {
                int num = row.get(j);//num is on the ith row and jth column
                rotated[j][a.size() - 1 - i] = num;
            }
        }

        for (int i = 0; i < a.size(); i++)
        {
            for (int j = 0; j < a.size(); j++)
            {
                a.get(i).set(j, rotated[i][j]);
            }
        }
    }

    //region Find Repeated Number
    public int findRepeatedNumber(final List<Integer> A)
    {
        boolean[] found = new boolean[A.size() - 1];
        for (int n: A)
        {
            if (found[n - 1])
            {
                return n;
            }
            else
            {
                found[n - 1] = true;
            }
        }
        return -1;
    }
    //endregion

    //region Merge Intervals

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval)
    {
        //There are five different cases
        if (intervals.size() <= 0)
        {
            intervals.add(newInterval);
            return intervals;
        }
        else if (newInterval.end < intervals.get(0).start)
        {
            intervals.add(0, newInterval);
            return intervals;
        }
        else if (newInterval.start > intervals.get(intervals.size() - 1).end)
        {
            intervals.add(newInterval);
            return intervals;
        }
        else
        {
            ArrayList<Interval> answer = new ArrayList<>();
            int start = newInterval.start;
            int end = newInterval.end;
            for (Interval current: intervals)
            {
                if (IsOverlap(current, newInterval))
                {
                    start = Integer.min(current.start, start);
                    end = Integer.max(current.end, end);
                }
                else
                {
                    answer.add(current);
                }
            }

            //add the result to the list by finding the start. result will definitely not overlap with any intervals
            //in the list anymore.
            Interval result = new Interval(start, end);
            boolean found = false;
            for (int i = answer.size() - 1; i >= 0; i--)
            {
                if (answer.get(i).end < result.start)
                {
                    answer.add(i + 1, result);
                    found = true;
                    break;
                }
            }
            if (!found)
            {
                answer.add(0, result);
            }

            return answer;
        }
    }

    public static boolean IsOverlap(Interval a, Interval b)
    {
        return a.start <= b.end && b.start <= a.end;
    }

    public static class Interval
    {
        int start;
        int end;

        public Interval()
        {
            start = 0;
            end = 0;
        }

        public Interval(int s, int e)
        {
            start = s;
            end = e;
        }

        @Override
        public String toString()
        {
            return "(" + start + ", " + end + ')';
        }
    }

    //endregion

    //region Set Zeros
    public void setZeroes(ArrayList<ArrayList<Integer>> a)
    {
        boolean[] rowIsZero = new boolean[a.size()];
        boolean[] columnIsZero = new boolean[a.get(0).size()];
        for (int i = 0; i < a.size(); i++)
        {
            ArrayList<Integer> row = a.get(i);
            for (int j = 0; j < row.size(); j++)
            {
                int num = row.get(j);
                if (num == 0)
                {
                    rowIsZero[i] = true;
                    columnIsZero[j] = true;
                }
            }
        }

        for (int i = 0; i < a.size(); i++)
        {
            ArrayList<Integer> row = a.get(i);
            for (int j = 0; j < row.size(); j++)
            {
                if (rowIsZero[i] || columnIsZero[j])
                {
                    row.set(j, 0);
                }
            }
        }
    }
    //endregion

    //region Pascal Triangle
    public static ArrayList<ArrayList<Integer>> solve(int A)
    {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> lastRow = null;
        for (int i = 0; i < A; i++)
        {
            ArrayList<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            if (lastRow != null)
            {
                for (int j = 1; j < lastRow.size(); j++)
                {
                    currentRow.add(lastRow.get(j - 1) + lastRow.get(j));
                }
                currentRow.add(1);
            }
            answer.add(currentRow);
            lastRow = currentRow;
        }

        return answer;
    }
    //endregion

    //region Hotel Rooms
    public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K)
    {
        depart.sort(Comparator.comparing(Integer::intValue));
        Collections.sort(arrive);

        Queue<Integer> currentArrives = new ArrayDeque<>();
        Queue<Integer> currentDeparts = new ArrayDeque<>();
        for (int i = 0; i < arrive.size(); i++)
        {
            int currentArr = arrive.get(i);
            int currentDep = depart.get(i);
            while (currentArrives.size() > 0)
            {
                int a = currentArrives.element();
                int d = currentDeparts.element();
                if (IsOverlap(currentArr, currentDep, a, d))
                {
                    break;
                }
                else
                {
                    currentArrives.remove();
                    currentDeparts.remove();
                }
            }
            currentArrives.add(currentArr);
            currentDeparts.add(currentDep);
            if (currentArrives.size() > K)
            {
                return false;
            }
        }

        return true;
    }

    public static boolean IsOverlap(int astart, int aend, int bstart, int bend)
    {
        return astart < bend && bstart < aend;
    }
    //endregion

    public static ArrayList<Integer> repeatedNumber(final List<Integer> A)
    {
        Collections.sort(A);
        ArrayList<Integer> answer = new ArrayList<>();

        answer.add(-1);
        answer.add(-1);

        boolean foundMissing = false;
        boolean foundRepeat = false;
        int addFactor = 0;
        for (int i = 0; i < A.size(); i++)
        {
            int expectedNumber = i + addFactor + 1;
            int actualNumber = A.get(i);
            if (actualNumber != expectedNumber)
            {
                if (actualNumber > expectedNumber)
                {
                    answer.set(1, expectedNumber);
                    foundMissing = true;
                    addFactor++;
                }
                else
                {
                    answer.set(0, expectedNumber - 1);
                    foundRepeat = true;
                    addFactor--;
                }

                if (foundMissing && foundRepeat)
                {
                    break;
                }
            }
        }

        return answer;
    }

    public String convert(String A, int B)
    {
        if (B == 1)
        {
            return A;
        }
        StringBuilder[] sbs = new StringBuilder[B];
        for (int i = 0; i < B; i++)
        {
            sbs[i] = new StringBuilder();
        }

        boolean increase = true;
        for (int i = 0, j = 0; i < A.length(); i++)
        {
            sbs[j].append(A.charAt(i));
            if (increase)
            {
                j++;
                if (j == B - 1)
                {
                    increase = false;
                }
            }
            else
            {
                j--;
                if (j == 0)
                {
                    increase = true;
                }
            }
        }

        return String.join("", sbs);
    }

    public static String solve(String A)
    {
        String[] splits = A.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = splits.length - 1; i >= 0; i--)
        {
            String cur = splits[i].trim();
            if (!cur.equals(""))
            {
                sb.append(cur).append(' ');
            }
        }
        return sb.toString().trim();
    }

    public String longestCommonPrefix(ArrayList<String> A)
    {
        if (A.size() == 0) { return ""; }

        String curPre = A.get(0);
        for (int i = 1; i < A.size(); i++)
        {
            if (curPre.length() == 0)
            {
                return "";
            }
            String curWord = A.get(i);

            if (curWord.length() < curPre.length())
            {
                curPre = curPre.substring(0, curWord.length());
            }

            for (int j = 0; j < curPre.length(); j++)
            {
                if (curPre.charAt(j) != curWord.charAt(j))
                {
                    curPre = curPre.substring(0, j);
                }
            }
        }
        return curPre;
    }

    public int strStr(final String A, final String B)
    {
        if (A.length() > B.length() || A.length() <= 0)
        {
            return -1;
        }

        char first = A.charAt(0);
        int AIndex = 0;
        int LastAStartIndex = -1;
        for (int i = 0; i < B.length(); i++)
        {
            char chb = B.charAt(i);
            char cha = A.charAt(AIndex);
            if (chb == cha)
            {
                if (AIndex == 0)
                {
                    LastAStartIndex = -1;
                }
                if (AIndex == A.length() - 1)
                {
                    return i - A.length();
                }
                AIndex++;
            }
            else if (chb == first)
            {
                LastAStartIndex = i;
            }
            else
            {
                AIndex = 0;
                if (LastAStartIndex != -1)
                {
                    i = LastAStartIndex;
                }
            }
        }
        return -1;
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int readInt() throws IOException
    {
        while (st == null || !st.hasMoreTokens())
        {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }
}
