package Tommy.CCC.Junior;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class J5_2019
{
    private static int totalSteps;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String[] left = new String[3];
        String[] right = new String[3];

        for (int i = 0; i < 3; i++)
        {
            left[i] = sc.next();
            right[i] = sc.next();
        }

        totalSteps = sc.nextInt();
        String original = sc.next();
        String end = sc.next();

        int forwardCount = (int) Math.ceil(totalSteps / 2f);

        HashSet<Step> stepsF = new HashSet<>();
        stepsF.add(new Step(original));

        for (int i = 0; i < forwardCount; i++)
        {
            stepsF = getSteps(stepsF, left, right);
        }

        HashSet<Step> stepsB = new HashSet<>();
        stepsB.add(new Step(end));

        for (int i = 0; i < totalSteps - forwardCount; i++)
        {
            stepsB = getSteps(stepsB, right, left);
        }


        for (Step stf : stepsF)
        {
            for (Step stb : stepsB)
            {
                if (stb.current.equals(stf.current))
                {
                    //found!
                    List<Step> ans = new ArrayList<>();
                    Step p = stf;
                    while (true)
                    {
                        if (p == null)
                        {
                            break;
                        }
                        ans.add(0, p);
                        p = p.parent;
                    }
                    p = stb;
                    while (true)
                    {
                        if (p == null)
                        {
                            break;
                        }
                        ans.add(p);
                        p = p.parent;
                    }
                    ans.remove(0);
                    ans.remove(stf);

                    Step previousStep = new Step(original);
                    for (int i = 0; i < ans.size(); i++)
                    {
                        ans.set(i, getNewStep(previousStep, ans.get(i), left, right));
                        previousStep = ans.get(i);
                    }

                    for (Step st : ans)
                    {
                        System.out.println(st.method + " " + (st.index + 1) + " " + st.current);
                    }
                    return;
                }
            }
        }
    }

    private static Step getNewStep(Step previousStep, Step step, String[] left, String[] right)
    {
        for (int j = 0; j < left.length; j++)
        {
            if (previousStep.current.contains(left[j]))
            {
                for (int i = 0; i <= previousStep.current.length() - left[j].length(); i++)
                {
                    if ((previousStep.current.substring(0, i) + right[j] + previousStep.current.substring(i + left[j].length())).equals(step.current))
                    {
                        Step st = new Step(step.current);
                        st.index = i;
                        st.method = j + 1;
                        return st;
                    }
                }
            }
        }

        return step;
    }


    private static HashSet<Step> getSteps(HashSet<Step> start, String[] left, String[] right)
    {
        HashSet<Step> steps = new HashSet<>();
        for (Step st : start)
        {
            String s = st.current;
            for (int f = 0; f < left.length; f++)//Loop through rules
            {
                for (int j = 0; j <= s.length() - left[f].length(); j++)
                {
                    if (s.substring(j, j + left[f].length()).equals(left[f]))
                    {
                        String ans = s.substring(0, j) + right[f] + s.substring(j + left[f].length());
                        steps.add(new Step(ans, st/*, f + 1, j*/));
                    }
                }
            }
        }
        return steps;
    }

    private static class Step
    {
        String current;
        Step parent;
        int method;
        int index;

        Step(String c, Step p)
        {
            current = c;
            parent = p;
        }

        Step(String c)
        {
            current = c;
            parent = null;
        }
    }
}