package smarttimetable.main.Model.DBModels;

import java.sql.Time;

public class Group {
    int idgroup;
    String name;

    public Group(int idgroup, String name) {
        this.idgroup = idgroup;
        this.name = name;
    }

    public int getIdgroup() {
        return idgroup;
    }

    public void setIdgroup(int idgroup) {
        this.idgroup = idgroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
