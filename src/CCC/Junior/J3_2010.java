package Junior;

import java.util.*;
import java.lang.Math;

public class J3_2010
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int A = 0;
        int B = 0;

        while (true)
        {
            int n = sc.nextInt();
            if (n == 7) { break; }
            if (n == 2)
            {
                String str = sc.next();
                System.out.println(str.equals("A") ? A : B);
            }
            else
            {
                String v = sc.next();
                if (n == 1)
                {
                    int val = sc.nextInt();
                    if (v.equals("A"))
                    {
                        A = val;
                    }
                    else
                    {
                        B = val;
                    }
                }
                else
                {
                    String v2 = sc.next();
                    if (n == 3)
                    {
                        if (v.equals("A"))
                        {
                            A += B;
                        }
                        else
                        {
                            B += A;
                        }
                    }
                    else if (n == 4)
                    {
                        if (v.equals("A"))
                        {
                            A *= B;
                        }
                        else
                        {
                            B *= A;
                        }
                    }
                    else if (n == 5)
                    {
                        if (v.equals("A"))
                        {
                            A -= B;
                        }
                        else
                        {
                            B -= A;
                        }
                    }
                    else if (n == 6)
                    {
                        if (v.equals("A"))
                        {
                            double d = (double) A / (double) B;
                            A = d < 0 ? (int) Math.ceil(d) : (int) Math.floor(d);
                        }
                        else
                        {
                            double d = (double) B / (double) A;
                            B = d < 0 ? (int) Math.ceil(d) : (int) Math.floor(d);
                        }
                    }
                }
            }
        }
    }
}