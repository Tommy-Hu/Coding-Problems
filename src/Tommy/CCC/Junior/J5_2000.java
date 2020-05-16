package Tommy.CCC.Junior;

import java.util.*;

public class J5_2000
{

    static WebPage[] pages = new WebPage[0];

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();

        pages = new WebPage[n];

        for (int i = 0; i < n; i++)
        {
            String url = "";
            url = s.nextLine();
            List<String> urls = new ArrayList<>();
            while (true)
            {//Operations to get urls on all lines
                String line = s.nextLine();
                if (line.equals("</HTML>"))
                {
                    break;
                }

                while (true)
                {//Operations to get urls on one line
                    int indexOf = line.indexOf("<A HREF=\"");
                    if (indexOf != -1)
                    {
                        indexOf += 9;
                        int finishIndex = line.indexOf("\">");
                        String currentUrl = line.substring(indexOf, finishIndex);
                        urls.add(currentUrl);
                        System.out.println("Link from " + url + " to " + currentUrl);
                        line = line.substring(finishIndex + 2);
                    }
                    else
                    {
                        break;
                    }
                }
            }

            pages[i] = new WebPage(url, urls);
        }

        while (true)
        {
            String url1 = s.nextLine();
            if (url1.equals("The End"))
            {
                break;
            }
            String url2 = s.nextLine();
            if (getPage(url1).havePath(url2, new ArrayList<>()))
            {
                System.out.println("Can surf from " + url1 + " to " + url2 + ".");
            }
            else
            {
                System.out.println("Can't surf from " + url1 + " to " + url2 + ".");
            }
        }
    }

    static WebPage getPage(String url)
    {
        for (WebPage wp : pages)
        {
            if (wp.pageURL.equals(url))
            {
                return wp;
            }
        }
        return null;
    }

    static class WebPage
    {
        public List<String> URLs;
        public String pageURL = "";

        public WebPage(String pageURL, List<String> URLs)
        {
            this.pageURL = pageURL;
            this.URLs = URLs;
        }

        public boolean havePath(String URL, List<String> dictionary)
        {
            //Recursion?
            //Loops?
            //Whatever
            if (URLs.contains(URL))
            {
                return true;
            }
            dictionary.add(pageURL);
            for (String url : URLs)
            {
                if (!dictionary.contains(url))
                {
                    if (getPage(url).havePath(URL, dictionary))
                    {
                        return true;
                    }
                }
            }

            return false;
        }
    }
}