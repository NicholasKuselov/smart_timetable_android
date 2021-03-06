package smarttimetable.main.Model.CacheModels;

import java.util.ArrayList;

import smarttimetable.main.JSONController;
import smarttimetable.main.Model.DataBase;
import smarttimetable.main.Model.DataBaseOperation;
import smarttimetable.main.Model.FileController;
import smarttimetable.main.Model.WebModel.API;
import smarttimetable.main.Model.WebModel.RequestHandler;

public class Cache {
    public static void Read()
    {
        DataBase.Weeks = new ArrayList<>(JSONController.importWeeksFromJSON(FileController.ReadFile(CacheFilePath.WeeksFile)));
        DataBase.Days = new ArrayList<>(JSONController.importDaysFromJSON(FileController.ReadFile(CacheFilePath.WeeksFile)));
        DataBase.Groups = new ArrayList<>(JSONController.importGroupsFromJSON(FileController.ReadFile(CacheFilePath.WeeksFile)));
        DataBase.Courses = new ArrayList<>(JSONController.importCoursesFromJSON(FileController.ReadFile(CacheFilePath.WeeksFile)));
        DataBase.Subjects = new ArrayList<>(JSONController.importSubjectsFromJSON(FileController.ReadFile(CacheFilePath.WeeksFile)));
        DataBase.Teachers = new ArrayList<>(JSONController.importTeachersFromJSON(FileController.ReadFile(CacheFilePath.WeeksFile)));
        DataBase.currentWeek = DataBase.Weeks.get(DataBase.Weeks.size() - 1);
        DataBaseOperation.CreateGroupsForView();
        DataBase.CurrentWeekLessons = new ArrayList<>(JSONController.importLessonsFromJSON(FileController.ReadFile(CacheFilePath.WeeksFile)));
    }
}
