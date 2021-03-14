package smarttimetable.main.Model.DBModels;

import android.text.style.TtsSpan;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Week {
    int idweek;

    public String getDateFrom() {
        return dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    String dateFrom;
    String dateTo;

    public Week(int idweek, String dateFrom, String dateTo) {
        this.idweek = idweek;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public int getIdweek() {
        return idweek;
    }

    public void setIdweek(int idweek) {
        this.idweek = idweek;
    }

    public Date getDateFrom1() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        try {
            Date date = dateFormat.parse(dateFrom);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo1() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        try {
            Date date = dateFormat.parse(dateTo);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public String toString()
    {
        return dateFrom+" - "+dateTo;
    }

    @Override
    public boolean equals(Object week)
    {
        Week c = (Week)week;
        if (this.idweek == c.idweek && this.dateFrom.equals(c.dateFrom) && this.dateTo.equals(c.dateTo))
        {
            return true;
        }else{
            return false;
        }
    }
}
