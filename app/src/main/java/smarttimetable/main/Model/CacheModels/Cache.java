package smarttimetable.main.Model.CacheModels;

import android.content.Context;
import android.util.JsonReader;

import java.util.ArrayList;

import smarttimetable.main.Model.DBModels.Course;
import smarttimetable.main.Model.DBModels.Day;
import smarttimetable.main.Model.DBModels.Group;
import smarttimetable.main.Model.DBModels.Lesson;
import smarttimetable.main.Model.DBModels.Subject;
import smarttimetable.main.Model.DBModels.Teacher;
import smarttimetable.main.Model.DBModels.Week;
import smarttimetable.main.Model.JSONController;
import smarttimetable.main.Model.DataBase;
import smarttimetable.main.Model.DataBaseOperation;
import smarttimetable.main.Model.FileController;

public class Cache {

    public static Context context;

    public static void Read(Context context)
    {
        DataBase.Weeks = ReadWeeks();
        DataBase.Days = ReadDays();
        DataBase.Groups = ReadGroups();
        DataBase.Courses = ReadCourses();
        DataBase.Subjects = ReadSubjects();
        DataBase.Teachers = ReadTeachers();
        DataBase.currentWeek = DataBase.Weeks.get(DataBase.Weeks.size() - 1);
        DataBaseOperation.CreateGroupsForView();
        DataBase.SelectedWeeksLessons = ReadLessons();
    }

    public static void Write()
    {
        FileController.WriteFile(context,CacheFilePath.WeeksFile, JSONController.exportWeeksToJSON());
        FileController.WriteFile(context,CacheFilePath.DaysFile, JSONController.exportDaysToJSON());
        FileController.WriteFile(context,CacheFilePath.GroupsFile, JSONController.exportGroupsToJSON());
        FileController.WriteFile(context,CacheFilePath.CoursesFile, JSONController.exportCoursesToJSON());
        FileController.WriteFile(context,CacheFilePath.SubjectsFile, JSONController.exportSubjectsToJSON());
        FileController.WriteFile(context,CacheFilePath.TeachersFile, JSONController.exportTeachersToJSON());
        FileController.WriteFile(context,CacheFilePath.LessonsFile, JSONController.exportLessonsToJSON());
    }

    public static ArrayList<Week> ReadWeeks()
    {
        return new ArrayList<>(JSONController.importWeeksFromJSON(FileController.ReadFile(context,CacheFilePath.WeeksFile)));
    }

    public static ArrayList<Day> ReadDays()
    {
        return new ArrayList<>(JSONController.importDaysFromJSON(FileController.ReadFile(context,CacheFilePath.DaysFile)));
    }

    public static ArrayList<Group> ReadGroups()
    {
        return new ArrayList<>(JSONController.importGroupsFromJSON(FileController.ReadFile(context,CacheFilePath.GroupsFile)));
    }

    public static ArrayList<Course> ReadCourses()
    {
        return new ArrayList<>(JSONController.importCoursesFromJSON(FileController.ReadFile(context,CacheFilePath.CoursesFile)));
    }

    public static ArrayList<Subject> ReadSubjects()
    {
        return new ArrayList<>(JSONController.importSubjectsFromJSON(FileController.ReadFile(context,CacheFilePath.SubjectsFile)));
    }

    public static ArrayList<Teacher> ReadTeachers()
    {
        return new ArrayList<>(JSONController.importTeachersFromJSON(FileController.ReadFile(context,CacheFilePath.TeachersFile)));
    }

    public static ArrayList<Lesson> ReadLessons()
    {
        return new ArrayList<>(JSONController.importLessonsFromJSON(FileController.ReadFile(context,CacheFilePath.LessonsFile)));
    }

}
