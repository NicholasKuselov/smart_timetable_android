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

    @Override
    public boolean equals(Object subject)
    {
        Subject c = (Subject)subject;
        if (this.idsubject == c.idsubject && this.name.equals(c.name))
        {
            return true;
        }else{
            return false;
        }
    }
}
