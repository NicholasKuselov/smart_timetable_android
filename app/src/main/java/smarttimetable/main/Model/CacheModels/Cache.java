package smarttimetable.main.Model.CacheModels;

import android.content.Context;
import android.util.JsonReader;

import java.util.ArrayList;

import smarttimetable.main.Model.DBModels.Week;
import smarttimetable.main.Model.JSONController;
import smarttimetable.main.Model.DataBase;
import smarttimetable.main.Model.DataBaseOperation;
import smarttimetable.main.Model.FileController;

public class Cache {

    public static Context context;

    public static void Read(Context context)
    {
        DataBase.Weeks = new ArrayList<>(JSONController.importWeeksFromJSON(FileController.ReadFile(context,CacheFilePath.WeeksFile)));
        DataBase.Days = new ArrayList<>(JSONController.importDaysFromJSON(FileController.ReadFile(context,CacheFilePath.DaysFile)));
        DataBase.Groups = new ArrayList<>(JSONController.importGroupsFromJSON(FileController.ReadFile(context,CacheFilePath.GroupsFile)));
        DataBase.Courses = new ArrayList<>(JSONController.importCoursesFromJSON(FileController.ReadFile(context,CacheFilePath.CoursesFile)));
        DataBase.Subjects = new ArrayList<>(JSONController.importSubjectsFromJSON(FileController.ReadFile(context,CacheFilePath.SubjectsFile)));
        DataBase.Teachers = new ArrayList<>(JSONController.importTeachersFromJSON(FileController.ReadFile(context,CacheFilePath.TeachersFile)));
        DataBase.currentWeek = DataBase.Weeks.get(DataBase.Weeks.size() - 1);
        DataBaseOperation.CreateGroupsForView();
        DataBase.SelectedWeeksLessons = new ArrayList<>(JSONController.importLessonsFromJSON(FileController.ReadFile(context,CacheFilePath.LessonsFile)));
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
}
