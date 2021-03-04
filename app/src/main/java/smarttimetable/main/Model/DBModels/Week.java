package smarttimetable.main.Model.DBModels;

public class Week {
    int idweek;
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

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }
}
