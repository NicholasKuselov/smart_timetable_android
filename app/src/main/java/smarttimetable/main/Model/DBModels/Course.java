package smarttimetable.main.Model.DBModels;

public class Course {
    int idcourse;
    int number;

    public Course(int idcourse, int number) {
        this.idcourse = idcourse;
        this.number = number;
    }

    public int getIdcourse() {
        return idcourse;
    }

    public void setIdcourse(int idcourse) {
        this.idcourse = idcourse;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
