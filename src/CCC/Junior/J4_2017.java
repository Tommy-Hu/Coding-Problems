//package Junior;
//
//import HelperClasses.Time;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//import static java.lang.System.out;
//
//public class J4_2017
//{
//    public static void main(String[] args) throws IOException
//    {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        Time time = new Time(true);
////        time.Hours = 12;
//
//        int totalTimeToAdd = Integer.parseInt(reader.readLine());
//        int totalCount = 0;
//
//        time.AddTime(Time.TimeMode.minutes, totalTimeToAdd);
//        if (time.Non_FormattedHours > 12 && Math.floorDiv(time.Non_FormattedHours, 12) > 1)
//        {
//            Time timeIn12H = new Time(Time.TimeMode.hours, 12, true);
//            for (int i = 0; i <= 720; i++)
//            {
//                String currentTime = timeIn12H.toString(true);
//                if (currentTime.startsWith("0") && currentTime.length() == 8)
//                {
//                    currentTime = currentTime.substring(1);
//                }
//                currentTime = currentTime.split(":")[0] + currentTime.split(":")[1] + currentTime.split(":")[2];
//                currentTime = currentTime.substring(0, currentTime.length() - 2);
//
//                int pattern = Integer.parseInt(currentTime.substring(0, 1)) - Integer.parseInt(currentTime.substring(1, 2));
//                for (int j = 0; j < currentTime.length() - 1; j++)
//                {
//                    if (Integer.parseInt(currentTime.substring(j, j + 1)) - Integer.parseInt(currentTime.substring(j + 1, j + 2)) != pattern)
//                    {
//                        break;
//                    }
//                    else if (j == currentTime.length() - 2)
//                    {
//                        totalCount++;
//                    }
//                }
//                timeIn12H.AddTime(Time.TimeMode.minutes, 1);
//            }
//
//            totalCount *= Math.floorDiv(time.Non_FormattedHours, 12);
//            totalTimeToAdd = totalTimeToAdd - ((int) (Math.floor((double) time.Non_FormattedHours / (double) 12)) * 12 * 60);
//        }
//
//
//        time = new Time(Time.TimeMode.hours, 12, true);
//        for (int i = 0; i <= totalTimeToAdd; i++)
//        {
//            String currentTime = time.toString(true);
//            if (currentTime.startsWith("0") && currentTime.length() == 8)
//            {
//                currentTime = currentTime.substring(1);
//            }
//            currentTime = currentTime.split(":")[0] + currentTime.split(":")[1] + currentTime.split(":")[2];
//            currentTime = currentTime.substring(0, currentTime.length() - 2);
//
//            int pattern = Integer.parseInt(currentTime.substring(0, 1)) - Integer.parseInt(currentTime.substring(1, 2));
//            for (int j = 0; j < currentTime.length() - 1; j++)
//            {
//                if (Integer.parseInt(currentTime.substring(j, j + 1)) - Integer.parseInt(currentTime.substring(j + 1, j + 2)) != pattern)
//                {
//                    break;
//                }
//                else if (j == currentTime.length() - 2)
//                {
//                    totalCount++;
//                }
//            }
//            time.AddTime(Time.TimeMode.minutes, 1);
//        }
//
//        out.print(totalCount);
//    }
//}
