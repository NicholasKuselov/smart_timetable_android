package smarttimetable.main.Model;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import smarttimetable.main.Model.CacheModels.Cache;
import smarttimetable.main.Model.DBModels.*;
import smarttimetable.main.Model.WebModel.API;
import smarttimetable.main.Model.WebModel.RequestHandler;
import smarttimetable.main.setting.Setting;


public class DataBaseOperation {

    public static Group GetGroupById(int id)
    {
        for (int i = 0; i < DataBase.Groups.size(); i++)
        {
            if (DataBase.Groups.get(i).getIdgroup() == id)
            {
                return DataBase.Groups.get(i);
            }
        }
        return null;
    }

    public static Subject GetSubjectById(int id)
    {
        for (int i = 0; i < DataBase.Subjects.size(); i++)
        {
            if (DataBase.Subjects.get(i).getIdsubject() == id)
            {
                return DataBase.Subjects.get(i);
            }
        }
        return null;
    }

    public static Teacher GetTeacherById(int id)
    {
        for (int i = 0; i < DataBase.Teachers.size(); i++)
        {
            if (DataBase.Teachers.get(i).getIdTeacher() == id)
            {
                return DataBase.Teachers.get(i);
            }
        }
        return null;
    }

    public static Day GetDayById(int id)
    {
        for (int i = 0; i < DataBase.Days.size(); i++)
        {
            if (DataBase.Days.get(i).getIdDay() == id)
            {
                return DataBase.Days.get(i);
            }
        }
        return null;
    }

    public static Course GetCourseById(int id)
    {
        for (int i = 0; i < DataBase.Courses.size(); i++)
        {
            if (DataBase.Courses.get(i).getIdcourse() == id)
            {
                return DataBase.Courses.get(i);
            }
        }
        return null;
    }

    public static Week GetWeekById(int id)
    {
        for (int i = 0; i < DataBase.Weeks.size(); i++)
        {
            if (DataBase.Weeks.get(i).getIdweek() == id)
            {
                return DataBase.Weeks.get(i);
            }
        }
        return null;
    }

    public static Lesson GetLessonById(int id)
    {
        for (int i = 0; i < DataBase.SelectedWeeksLessons.size(); i++)
        {
            if (DataBase.SelectedWeeksLessons.get(i).getIdtimetable() == id)
            {
                return DataBase.SelectedWeeksLessons.get(i);
            }
        }
        return null;
    }

    public static ArrayList<Lesson> GetLessonByGroupAndCourseAndWeek(GroupForView GroupAndCourse,Week week)
    {
        ArrayList<Lesson> tmp = new ArrayList<>();
        for (int i = 0; i< DataBase.SelectedWeeksLessons.size(); i++)
        {
            if (DataBase.SelectedWeeksLessons.get(i).getGroupId() == GroupAndCourse.group.getIdgroup() && DataBase.SelectedWeeksLessons.get(i).getCourseId() == GroupAndCourse.course.getIdcourse() && DataBase.SelectedWeeksLessons.get(i).getWeekId() == week.getIdweek())
            {
                tmp.add(DataBase.SelectedWeeksLessons.get(i));
            }
        }

        return tmp;
    }

    public static ArrayList<Lesson> GetTodayLessonByUser()
    {
        ArrayList<Lesson> tmp = new ArrayList<>();
        for (int i = 0; i< DataBase.SelectedWeeksLessons.size(); i++)
        {
            if (DataBase.SelectedWeeksLessons.get(i).getGroupId() == Setting.GetUserGroup() && DataBase.SelectedWeeksLessons.get(i).getCourseId() == Setting.GetUserCourse() && DataBase.SelectedWeeksLessons.get(i).getDate().equals(DateTimeOperation.GetCurrentDay())) {
                tmp.add(DataBase.SelectedWeeksLessons.get(i));
            }
        }
        return tmp;
    }

    public static List<Lesson> GetLessonsByDay(ArrayList<Lesson> lessons, Day day)
    {
        List<Lesson> tmp = new ArrayList<>();

        for (int i = 0; i< lessons.size(); i++)
        {
            if (lessons.get(i).getDayId() == day.getIdDay())
            {
                tmp.add(lessons.get(i));
            }
        }
        return tmp;
    }

    public static void CreateGroupsForView()
    {
        for(int i = 0; i < DataBase.Courses.size(); i++)
        {
            for(int j = 0; j < DataBase.Groups.size(); j++)
            {
                DataBase.GroupsForView.add(new GroupForView(DataBase.Groups.get(j),DataBase.Courses.get(i)));
            }
        }
    }

    public static boolean ConnectToDb()
    {
        if(!RequestHandler.isOnline()) return false;
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                DataBase.Weeks = new ArrayList<>(JSONController.importWeeksFromJSON(RequestHandler.sendGetRequest(API.URL_GET_Weeks)));
                DataBase.Days = new ArrayList<>(JSONController.importDaysFromJSON(RequestHandler.sendGetRequest(API.URL_GET_Days)));
                DataBase.Groups = new ArrayList<>(JSONController.importGroupsFromJSON(RequestHandler.sendGetRequest(API.URL_GET_Groups)));
                DataBase.Courses = new ArrayList<>(JSONController.importCoursesFromJSON(RequestHandler.sendGetRequest(API.URL_GET_Courses)));
                DataBase.Subjects = new ArrayList<>(JSONController.importSubjectsFromJSON(RequestHandler.sendGetRequest(API.URL_GET_Subjects)));
                DataBase.Teachers = new ArrayList<>(JSONController.importTeachersFromJSON(RequestHandler.sendGetRequest(API.URL_GET_Teacher)));
                DataBase.currentWeek = DataBase.Weeks.get(0);
                DataBaseOperation.CreateGroupsForView();
               // DataBase.CurrentWeekLessons = new ArrayList<>(JSONController.importLessonsFromJSON(RequestHandler.sendGetRequest(API.URL_GET_LessonsByWeekId + DataBase.currentWeek.getIdweek()).toString()));
                DataBase.SelectedWeeksLessons.clear();
                for (int i = 0; i < DataBase.Weeks.size();i++)
                {
                    DataBase.SelectedWeeksLessons.addAll(JSONController.importLessonsFromJSON(RequestHandler.sendGetRequest(API.URL_GET_LessonsByWeekId + DataBase.Weeks.get(i).getIdweek()).toString()));
                }

                //Cache.Write();
            }
        });
        return true;
    }

    public static void SetCurrentWeek(Week week)
    {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
               // DataBase.CurrentWeekLessons = new ArrayList<>(JSONController.importLessonsFromJSON(RequestHandler.sendGetRequest(API.URL_GET_LessonsByWeekId + DataBase.currentWeek.getIdweek())));
            }
        });
    }
}
