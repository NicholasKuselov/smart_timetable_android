package smarttimetable.main.Model.DBModels;

import android.os.Parcelable;

public class Lesson {
    public int getIdtimetable() {
        return idtimetable;
    }

    public void setIdtimetable(int idtimetable) {
        this.idtimetable = idtimetable;
    }

    public int getSubjectId() {
        return SubjectId;
    }

    public void setSubjectId(int subjectId) {
        SubjectId = subjectId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getDayId() {
        return DayId;
    }

    public void setDayId(int dayId) {
        DayId = dayId;
    }

    public int getWeekId() {
        return WeekId;
    }

    public void setWeekId(int weekId) {
        WeekId = weekId;
    }

    public int getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(int teacherId) {
        TeacherId = teacherId;
    }

    public int getGroupId() {
        return GroupId;
    }

    public void setGroupId(int groupId) {
        GroupId = groupId;
    }

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int courseId) {
        CourseId = courseId;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    int idtimetable;
    int SubjectId;
    String Date;
    int DayId;
    int WeekId;
    int TeacherId;
    int GroupId;
    int CourseId;
    String Time;


    public Lesson(int idtimetable, int subjectId, String date, int dayId, int weekId, int teacherId, int groupId, int courseId, String time) {
        this.idtimetable = idtimetable;
        SubjectId = subjectId;
        Date = date;
        DayId = dayId;
        WeekId = weekId;
        TeacherId = teacherId;
        GroupId = groupId;
        CourseId = courseId;
        Time = time;
    }
}
