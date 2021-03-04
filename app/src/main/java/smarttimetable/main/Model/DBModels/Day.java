package smarttimetable.main.Model.DBModels;

public class Day {
    int idDay;
    String name;

    public Day(int idDay, String name) {
        this.idDay = idDay;
        this.name = name;
    }

    public int getIdDay() {
        return idDay;
    }

    public void setIdDay(int idDay) {
        this.idDay = idDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
