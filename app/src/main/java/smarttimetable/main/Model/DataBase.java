package smarttimetable.main.Model;

import java.util.ArrayList;

import smarttimetable.main.Model.DBModels.Course;
import smarttimetable.main.Model.DBModels.Day;
import smarttimetable.main.Model.DBModels.Group;
import smarttimetable.main.Model.DBModels.GroupForView;
import smarttimetable.main.Model.DBModels.Lesson;
import smarttimetable.main.Model.DBModels.Subject;
import smarttimetable.main.Model.DBModels.Teacher;
import smarttimetable.main.Model.DBModels.Week;

public class DataBase {
    public static ArrayList<Lesson> CurrentWeekLessons = new ArrayList<Lesson>();
    public static ArrayList<Week> Weeks = new ArrayList<>();
    public static ArrayList<Teacher> Teachers = new ArrayList<>();
    public static ArrayList<Group> Groups = new ArrayList<>();
    public static ArrayList<Subject> Subjects = new ArrayList<>();
    public static ArrayList<Course> Courses = new ArrayList<>();
    public static ArrayList<Day> Days = new ArrayList<>();

    public static Week currentWeek;

    public static ArrayList<GroupForView> GroupsForView = new ArrayList<>();


}
