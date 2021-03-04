package smarttimetable.main;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import smarttimetable.main.Model.DBModels.*;
import smarttimetable.main.Model.DBModels.Lesson;
import smarttimetable.main.Model.DBModels.Week;
import smarttimetable.main.setting.SettingConst;

public class JSONController {


    public static boolean testJson(Context context) {
        List<Week> dataList = new ArrayList<>();
        dataList.add(new Week(0,"From","To"));
        dataList.add(new Week(1,"From1","To1"));
        dataList.add(new Week(2,"From2","To2"));
        Gson gson = new Gson();
        WeekDataItems dataItems = new WeekDataItems();
        dataItems.setWeeks(dataList);
        String jsonString = gson.toJson(dataItems);

        Log.println(Log.INFO,"ererererer",jsonString);



        return false;
    }



    public static List<Week> importWeeksFromJSON(String jsonString) {
        //jsonString = "[" +jsonString.split("\\[")[1].split("\\]")[0] + "]";
        Log.println(Log.INFO,"ssssssss",jsonString);
        try{
            Gson gson = new Gson();
            WeekDataItems dataItems = gson.fromJson(jsonString, WeekDataItems.class);
            return  dataItems.getWeeks();
        }
        catch (Exception ex){

            ex.printStackTrace();
        }
        return null;
    }

    public static List<Course> importCoursesFromJSON(String jsonString) {
        try{
            Gson gson = new Gson();
            CourseDataItems dataItems = gson.fromJson(jsonString, CourseDataItems.class);
            return  dataItems.getCourses();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static List<Day> importDaysFromJSON(String jsonString) {

        try{
            Gson gson = new Gson();
            DayDataItems dataItems = gson.fromJson(jsonString, DayDataItems.class);
            return  dataItems.getDays();
        }
        catch (Exception ex){

            ex.printStackTrace();
        }
        return null;
    }

    public static List<Group> importGroupsFromJSON(String jsonString) {

        try{
            Gson gson = new Gson();
            GroupDataItems dataItems = gson.fromJson(jsonString, GroupDataItems.class);
            return  dataItems.getGroups();
        }
        catch (Exception ex){

            ex.printStackTrace();
        }
        return null;
    }

    public static List<Lesson> importLessonsFromJSON(String jsonString) {

        try{
            Gson gson = new Gson();
            LessonDataItems dataItems = gson.fromJson(jsonString, LessonDataItems.class);
            return  dataItems.getLessons();
        }
        catch (Exception ex){

            ex.printStackTrace();
        }
        return null;
    }

    public static List<Subject> importSubjectsFromJSON(String jsonString) {

        try{
            Gson gson = new Gson();
            SubjectDataItems dataItems = gson.fromJson(jsonString, SubjectDataItems.class);
            return  dataItems.getSubjects();
        }
        catch (Exception ex){

            ex.printStackTrace();
        }
        return null;
    }

    public static List<Teacher> importTeachersFromJSON(String jsonString) {

        try{
            Gson gson = new Gson();
            TeacherDataItems dataItems = gson.fromJson(jsonString, TeacherDataItems.class);
            return  dataItems.getTeachers();
        }
        catch (Exception ex){

            ex.printStackTrace();
        }
        return null;
    }




    private static class WeekDataItems {
        public List<Week> getWeeks() {
            return weeks;
        }

        public void setWeeks(List<Week> weeks) {
            this.weeks = weeks;
        }

        private List<Week> weeks;


    }

    private static class CourseDataItems {
        public List<Course> getCourses() {
            return courses;
        }

        public void setCourses(List<Course> courses) {
            this.courses = courses;
        }

        private List<Course> courses;


    }

    private static class DayDataItems {
        public List<Day> getDays() {
            return days;
        }

        public void setDays(List<Day> days) {
            this.days = days;
        }

        private List<Day> days;


    }

    private static class GroupDataItems {
        public List<Group> getGroups() {
            return groups;
        }

        public void setGroups(List<Group> groups) {
            this.groups = groups;
        }

        private List<Group> groups;


    }

    private static class LessonDataItems {
        public List<Lesson> getLessons() {
            return lessons;
        }

        public void setLessons(List<Lesson> lessons) {
            this.lessons = lessons;
        }

        private List<Lesson> lessons;


    }

    private static class SubjectDataItems {
        public List<Subject> getSubjects() {
            return subjects;
        }

        public void setSubjects(List<Subject> subjects) {
            this.subjects = subjects;
        }

        private List<Subject> subjects;


    }

    private static class TeacherDataItems {
        public List<Teacher> getTeachers() {
            return teachers;
        }

        public void setTeachers(List<Teacher> teachers) {
            this.teachers = teachers;
        }

        private List<Teacher> teachers;


    }

}
