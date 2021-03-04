package smarttimetable.main.Model.DBModels;

public class Subject {
    int idsubject;
    String name;

    public Subject(int idsubject, String name) {
        this.idsubject = idsubject;
        this.name = name;
    }

    public int getIdsubject() {
        return idsubject;
    }

    public void setIdsubject(int idsubject) {
        this.idsubject = idsubject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
