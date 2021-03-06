package smarttimetable.main.Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeOperation
{
    public int GetCurrentWeekId()
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
        return DataBase.Weeks.get(DataBase.Weeks.size()-1).getIdweek();
    }
}
