package smarttimetable.main.Model.DBModels;

import android.os.Parcelable;

import androidx.annotation.Nullable;

import smarttimetable.main.Model.DataBaseOperation;

public class Lesson {
    int idtimetable;
    int Subject;
    String Date;
    int Day;
    int Week;
    int Teacher;
    int Group;
    int Course;
    String Time;

    public Lesson(int idtimetable, int subject, String date, int day, int week, int teacher, int group, int course, String time) {
        this.idtimetable = idtimetable;
        Subject = subject;
        Date = date;
        Day = day;
        Week = week;
        Teacher = teacher;
        Group = group;
        Course = course;
        Time = time;
    }

    public int getIdtimetable() {
        return idtimetable;
    }

    public void setIdtimetable(int idtimetable) {
        this.idtimetable = idtimetable;
    }

    public int getSubjectId() {
        return Subject;
    }

    public void setSubject(int subject) {
        Subject = subject;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getDayId() {
        return Day;
    }

    public void setDay(int day) {
        Day = day;
    }

    public int getWeekId() {
        return Week;
    }

    public void setWeek(int week) {
        Week = week;
    }

    public int getTeacherId() {
        return Teacher;
    }

    public void setTeacher(int teacher) {
        Teacher = teacher;
    }

    public int getGroupId() {
        return Group;
    }

    public void setGroup(int group) {
        Group = group;
    }

    public int getCourseId() {
        return Course;
    }

    public void setCourse(int course) {
        Course = course;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        Lesson c = (Lesson)obj;
        if (this.idtimetable == c.idtimetable && this.Subject == c.Subject && this.Day == c.Day&& this.Week == c.Week && this.Teacher == c.Teacher && this.Group == c.Group && this.Course == c.Course && this.Date.equals(c.Date) && this.Time.equals(c.Time))
        {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString()
    {
        return getDate()+" "+getTime()+" "+ DataBaseOperation.GetGroupById(getGroupId())+" "+DataBaseOperation.GetCourseById(getCourseId());
    }
}
