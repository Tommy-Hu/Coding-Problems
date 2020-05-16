package Tommy.Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF_B_1305
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        ArrayDeque<Character> operand = new ArrayDeque<>();
        List<Character> nextOperandStart = new ArrayList<>();
        List<Character> nextOperandEnd = new ArrayList<>();
        for (char c: line.toCharArray())
        {
            operand.add(c);
        }

        List<Integer> places = new ArrayList<>();

        int startIndex = 0;
        InnerLoop:
        while (true)
        {
            if (operand.size() < 2)
            {
                break;
            }

            char start = operand.pop();
            char end = operand.pollLast();
            if (start == '(')
            {
                if (end == ')')
                {
                    places.add(startIndex);
                    places.add(startIndex + operand.size() + 1);
                }
                else
                {
                    nextOperandEnd.add(0, end);
                    while (true)
                    {
                        if (operand.size() == 0)
                        {
                            break InnerLoop;
                        }

                        end = operand.pollLast();
                        if (end == ')')
                        {
                            places.add(startIndex);
                            places.add(startIndex + operand.size() + 1);
                            break;
                        }
                        else
                        {
                            nextOperandEnd.add(0, end);
                        }
                    }
                }
            }
            else if (end == ')')
            {
                //found end but no start
                nextOperandStart.add(start);
                while (true)
                {
                    if (operand.size() == 0)
                    {
                        break InnerLoop;
                    }

                    start = operand.pop();
                    if (start == '(')
                    {
                        places.add(startIndex);
                        places.add(startIndex + operand.size() + 1);
                        break;
                    }
                    else
                    {
                        nextOperandStart.add(start);
                    }
                    startIndex++;
                }
            }
            startIndex++;
        }

        if (places.size() == 0)
        {
            System.out.println(0);
        }
        else
        {
            System.out.println(1);
            System.out.println(places.size());
            Collections.sort(places);
            for (var index: places)
            {
                System.out.print((index + 1) + " ");
            }
        }
    }
}
