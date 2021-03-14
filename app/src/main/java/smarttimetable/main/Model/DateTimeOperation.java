package smarttimetable.main.Model;

import java.security.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeOperation
{
    public static int GetCurrentWeekId()
    {
        Date currentDate = new Date();
        //DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        //String dateText = dateFormat.format(currentDate);
        for (int i = 0; i < DataBase.Weeks.size(); i++)
        {
            if (currentDate.after(DataBase.Weeks.get(i).getDateFrom1()) && currentDate.before(DataBase.Weeks.get(i).getDateTo1()))
            {
                return DataBase.Weeks.get(i).getIdweek();
            }
        }

        return -1;
    }

    public static String GetCurrentDay()
    {
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String dateText = dateFormat.format(currentDate);
        debug.log("currentdate",dateText);
        return "22.02.2021";
    }

    public static String GetDayAfter(int DayAfterCount,String dateString)
    {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        Date date;
        try {
            date = dateFormat.parse(dateString);

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

        Calendar instance = Calendar.getInstance();
        instance.setTime(date); //устанавливаем дату, с которой будет производить операции
        instance.add(Calendar.DAY_OF_MONTH, DayAfterCount);// прибавляем 3 дня к установленной дате
        Date newDate = instance.getTime();


        return dateFormat.format(newDate);
    }


}
