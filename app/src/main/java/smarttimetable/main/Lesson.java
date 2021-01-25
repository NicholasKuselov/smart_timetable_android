package smarttimetable.main;

import java.util.Date;

public class Lesson {
    public String name;
    public String teacher;
    public String date;


    public String getDate() {
        return date;

    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime()
    {
        return date.split(" ")[0];
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
