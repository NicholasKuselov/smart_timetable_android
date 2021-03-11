package smarttimetable.main.Model;

import android.util.Log;

public class debug {
    public static void log(String a,String b)
    {
        Log.println(Log.INFO,a,b);
    }

    public static void log(String a,int b)
    {
        Log.println(Log.INFO,a,String.valueOf(b));
    }
}
