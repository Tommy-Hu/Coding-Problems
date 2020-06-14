

public class Time
{
    public enum TimeMode
    {
        hours, minutes, seconds
    }

    public int Non_FormattedHours = 0;
    public int Hours = 0;
    public int Minutes = 0;
    public int Seconds = 0;

    public boolean TwelveHoursMode = true;

    public Time(TimeMode constructMode, int value, boolean twelveHoursMode)
    {
        TwelveHoursMode = twelveHoursMode;
        if (constructMode == TimeMode.minutes)
        {
            Minutes += value;
        }
        else if (constructMode == TimeMode.hours)
        {
            Hours += value;
            Non_FormattedHours += value;
        }
        else
        {
            Seconds += value;
        }
        RefreshTime();
    }

    public Time(boolean twelveHoursMode)
    {
        TwelveHoursMode = twelveHoursMode;
    }

    public void AddTime(TimeMode timeMode, int value)
    {
        if (timeMode == TimeMode.minutes)
        {
            Minutes += value;
        }
        else if (timeMode == TimeMode.hours)
        {
            Hours += value;
            Non_FormattedHours += value;
        }
        else
        {
            Seconds += value;
        }
        RefreshTime();
    }


    private void RefreshTime()
    {
        if (Seconds >= 60)
        {
            Minutes += Math.floor(Seconds / 60);
            Seconds -= Math.floor(Seconds / 60) * 60;
        }
        if (Minutes >= 60)
        {
            Hours += Math.floor(Minutes / 60);
            Non_FormattedHours += Math.floor(Minutes / 60);
            Minutes -= Math.floor(Minutes / 60) * 60;
        }

        if (TwelveHoursMode)
        {
            if (Hours > 12)
            {
                Hours = Hours - 12 * Math.floorDiv(Hours, 12);
            }
        }
        else
        {
            if (Hours > 24)
            {
                Hours = Hours - 24 * Math.floorDiv(Hours, 24);
            }
        }
    }

    public String toString(boolean containsExtraZeros)
    {
        RefreshTime();
        if (!containsExtraZeros)
        {
            return Hours + ":" + Minutes + ":" + Seconds;
        }
        else
        {
            String ans = "";
            if (String.valueOf(Hours).length() == 1)
            {
                ans += "0" + Hours;
            }
            else
            {
                ans += Hours;
            }

            if (String.valueOf(Minutes).length() == 1)
            {
                ans += ":0" + Minutes;
            }
            else
            {
                ans += ":" + Minutes;
            }

            if (String.valueOf(Seconds).length() == 1)
            {
                ans += ":0" + Seconds;
            }
            else
            {
                ans += ":" + Seconds;
            }
            return ans;
        }
    }

    public String toStringSimple(boolean startsWithZero)
    {
        String ans = Hours + "" + Minutes + "" + Seconds;
        if (!startsWithZero)
        {
            return ans;
        }
        else
        {
            if (ans.substring(0, 1) == "0" && ans.length() % 2 == 0)
            {
                return "0" + ans;
            }
            else
            {
                return ans;
            }
        }
    }
}
