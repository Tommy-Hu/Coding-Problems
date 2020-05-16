package Tommy.CCC.Junior;

import java.util.*;
import java.io.*;

class J5_2018
{
    public static int smallestEnding = Integer.MAX_VALUE;
    public static List<Page> Book = new ArrayList<>();

    static int totalPageNum = 0;

    public static void main(String[] args) throws IOException
    {
        //Read Everything
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        totalPageNum = Integer.parseInt(reader.readLine());
        for (int i = 0; i < totalPageNum; i++)
        {
            String oneLine = reader.readLine();
            Page page = new Page();
            int childrenPageNumber;
            page.pageNum = i;
            if (oneLine.contains(" "))
            {
                childrenPageNumber = Integer.parseInt(oneLine.substring(0, oneLine.indexOf(" ")));
            } else
            {
                page.childrenPages.add(0);
                Book.add(page);
                continue;
            }
            oneLine = oneLine.substring(oneLine.indexOf(" ") + 1);
            for (int j = 0; j < childrenPageNumber; j++)
            {
                page.childrenPages.add(Integer.parseInt(oneLine.split(" ")[j]));
            }
            Book.add(page);
        }
        //Call the first one
        Book.get(0).isTouched = true;
        Book.get(0).currentPathNum = 1;
        Book.get(0).CallChildren();


        //For(...){...} and get the Y or N
        boolean isAllReachable = true;
        for (int i = 0; i < Book.size(); i++)
        {
            if (Book.get(i).isTouched)
            {
//                System.out.println("Page number " + (Book.get(i).pageNum + 1) + " is Touched!");
            } else
            {
                isAllReachable = false;
//                System.out.println("Page number " + (Book.get(i).pageNum + 1) + " is NOT Touched!");
            }
        }
        if(isAllReachable){
            System.out.print("Y\n");
        }
        else{
            System.out.print("N\n");
        }
        //Print the shortest path
        System.out.print(smallestEnding);

    }

    static class Page
    {
        public Page()
        {
        }

        public int pageNum;
        public int currentPathNum = Integer.MAX_VALUE;
        public List<Integer> childrenPages = new ArrayList<>();
        public boolean isTouched = false;

        public void CallChildren()
        {
            //Is Zero(the end of the story)?
            if (childrenPages.get(0) == 0)
            {
                if (smallestEnding > currentPathNum)
                {
                    smallestEnding = currentPathNum;
                }
                return;
            }

            for (int i : childrenPages)
            {
                Page page = Book.get(i - 1);
                if (!page.isTouched)
                {
                    page.currentPathNum = currentPathNum + 1;
                    page.isTouched = true;
                    page.CallChildren();
                } else if (page.currentPathNum > currentPathNum + 1)
                {
                    page.currentPathNum = currentPathNum + 1;
                    page.isTouched = true;
                    page.CallChildren();
                }
            }
        }
    }
}


