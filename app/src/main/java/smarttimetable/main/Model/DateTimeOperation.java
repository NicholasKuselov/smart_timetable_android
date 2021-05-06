package smarttimetable.main.Model;

import java.security.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateTimeOperation
{
    public static int GetCurrentWeekPos()
    {
        Date currentDate = new Date();
        //DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        //String dateText = dateFormat.format(currentDate);
        for (int i = 0; i < DataBase.Weeks.size(); i++)
        {
            if (currentDate.after(DataBase.Weeks.get(i).getDateFrom1()) && currentDate.before(DataBase.Weeks.get(i).getDateTo1()))
            {
                return i;
            }
        }

        if (DataBase.Weeks.size()==0)
            return -1;
        return DataBase.Weeks.size()-1;
    }

    public static String GetCurrentDay()
    {
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String dateText = dateFormat.format(currentDate);

        return dateText;
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

    public static int GetNextLessonIndex(List<String> dateStrings) //debug
    {

        Date currentDate = new Date();

        DateFormat dateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
/*
        Date currentDate = null;
        try {
            currentDate = dateFormat.parse("15:04");
        } catch (ParseException e) {
            e.printStackTrace();
        }

 */
        String dateText = dateFormat.format(currentDate);

        int res = -1;
        long diff = 0;
        for (int i = 0; i < dateStrings.size(); i++) {
            Date date;
            try {
                date = dateFormat.parse(dateStrings.get(i));
                long diffLocal = date.getTime() - currentDate.getTime();
                if(diffLocal<=0) continue;
                if (diffLocal<diff || diff==0){
                    diff = diffLocal;
                    res = i;
                }
            } catch (ParseException e) {
                e.printStackTrace();
                return -1;
            }
        }

        return res;
    }

}
